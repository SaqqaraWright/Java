package com.coding.bookclub.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.bookclub.models.Book;
import com.coding.bookclub.repositories.BookRepository;

@Service
public class BookService
{
	@Autowired
	private BookRepository bookRepository;
	
	public void create(Book book) //create method
	{
		bookRepository.save(book);		
	}
	
	public void update(Book book) //update method
	{
		bookRepository.save(book);		
	}
	
	public ArrayList<Book> findAll()  //"find all" method: read
	{
		return bookRepository.findAll();
	}
	
	public Book findById(Long id)
	{
		return bookRepository.findById(id).orElse(null); //"find one" method
	}
	
	public void deleteById(Long id) //delete method
	{
		bookRepository.deleteById(id);
	}
	

};
