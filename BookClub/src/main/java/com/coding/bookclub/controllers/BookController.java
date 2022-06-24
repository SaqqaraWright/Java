package com.coding.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.bookclub.models.Book;
import com.coding.bookclub.models.User;
import com.coding.bookclub.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public String bookAll( Model model )
	{
		model.addAttribute("books", bookService.findAll());
		return "book_all";
	}
	
	@GetMapping("/{id}/edit")
	public String bookEdit( @PathVariable("id") Long bookId, Model model, HttpSession session )
	{
		if(session.getAttribute("user")==null) //this will keep anyone who's not logged in from being able to edit a book
		{
			return "redirect:/books";
		}
		
		model.addAttribute("book", bookService.findById(bookId));
		return "book_edit";
	}
	
	@PostMapping("/{id}/edit")
	public String bookUpdate( @Valid @ModelAttribute("book") Book book, BindingResult res, HttpSession session)
	{
		if(res.hasErrors())
		{
			return "book_edit";
		}
		book.setUser((User)session.getAttribute("user") );//remember to add this line so that the foreign key of the user gets attached to the book/item
		bookService.update(book);
		return "redirect:/books";
	}
	
	@GetMapping("/new")
	public String bookNew(Model model, HttpSession session )
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:/books";
		}
		model.addAttribute("book", new Book());
		return "book_new";
	}
	
	@PostMapping("/new")
	public String bookCreate( @Valid @ModelAttribute("book") Book book, BindingResult res, HttpSession session )
	{
		if(res.hasErrors())
		{
			return "book_new";
		}//in other words, this sets the foreign key onto the object
		book.setUser((User)session.getAttribute("user") );//this is the better more secure way of setting the book object onto a user rather than the way given on the platform of storing a hidden variable in the jsp (this method is not very secure).
		bookService.create(book);
		return "redirect:/books";
	}
	
	@GetMapping("/{id}")
	public String showOne( @PathVariable("id") Long bookId, Model model )
	{
		model.addAttribute("book", bookService.findById(bookId));
		return "show_one";
	}
	

}
