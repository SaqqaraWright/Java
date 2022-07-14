package com.coding.teatime.controllers;

import java.util.ArrayList;

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

import com.coding.teatime.models.Rating;
import com.coding.teatime.models.Tea;
import com.coding.teatime.models.User;
import com.coding.teatime.services.RatingService;
import com.coding.teatime.services.TeaService;



@Controller
@RequestMapping("/teas")
public class TeaController 
{
	@Autowired
	private TeaService teaService;
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("")
	public String dashboard( Model model, HttpSession session )
	{
		if(session.getAttribute("user")==null) //the purpose of this statement is to redirect anyone who tries to navigate directly to the dashboard w/o logging in first
		{
			return "redirect:/login";
		}
		model.addAttribute("teas", teaService.findAll());
		model.addAttribute("rating", new Rating());
		return "dashboard";
	}
	
	@PostMapping("/rate")
	public String teaRate( @Valid @ModelAttribute("rating") Rating rating, BindingResult res, HttpSession session)
	{
		if(res.hasErrors())
		{
			return "dashboard";
		}
		ratingService.create(rating);
		return "redirect:/teas";
	}
	
	@GetMapping("/{id}/edit")
	public String teaEdit( @PathVariable("id") Long showId, Model model, HttpSession session )
	{
		if(session.getAttribute("user")==null) //this will keep anyone who's not logged in from being able to edit a show
		{
			return "redirect:/login";
		}
		
		model.addAttribute("tea", teaService.findById(showId));
		return "edit";
	}
	
	@PostMapping("/{id}/edit")
	public String teaUpdate( @Valid @ModelAttribute("tea") Tea tea, BindingResult res, HttpSession session)
	{
		if(res.hasErrors())
		{
			return "edit";
		}
		tea.setUser((User)session.getAttribute("user") );//remember to add this line so that the foreign key of the user gets attached to the show/item
		teaService.update(tea);
		return "redirect:/teas";
	}
	
	@GetMapping("/add")//this route allows user to add new tea
	public String teaAdd(Model model, HttpSession session )
	{
		if(session.getAttribute("user")==null)
		{
			return "redirect:/login"; //this initially was set to send non-logged in users to the user dashboard; however, I've redirected to send them to the login page. People who aren't logged in, shouldn't be in the app.
		}
		model.addAttribute("tea", new Tea());
		return "add";
	}
	
	@PostMapping("/add")
	public String teaCreate( @Valid @ModelAttribute("tea") Tea tea, BindingResult res, HttpSession session )
	{
		if(res.hasErrors())
		{
			return "add";
		}//in other words, this sets the foreign key onto the object
		tea.setUser((User)session.getAttribute("user") );//this is the better more secure way of setting the tea object onto a user rather than the way given on the platform of storing a hidden variable in the jsp (this method is not very secure).
		teaService.create(tea);
		return "redirect:/teas";
	}
	
	@GetMapping("/{id}")
	public String showOne( @PathVariable("id") Long teaId, Model model )
	{
		Tea tea= teaService.findById(teaId);
		model.addAttribute("tea", tea);
		return "show_one";
	}
	
	@PostMapping("delete/{id}") //this allows me to delete a tea
	public String deleteTea(@PathVariable("id") Long teaId)
	{
		teaService.deleteById(teaId);
		return "redirect:/teas";
		
	}
	

}

