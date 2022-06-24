package com.coding.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.bookclub.models.TempUser;
import com.coding.bookclub.models.User;
import com.coding.bookclub.services.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String log_reg( Model model )
	{
		model.addAttribute("userRegister", new User());
		model.addAttribute("userLogin", new TempUser());
		return "log_reg";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("userRegister")User form_user, BindingResult res, Model model)
	{
		if(res.hasErrors())
		{
			model.addAttribute("userLogin", new TempUser());
			return "log_reg";
		}
		User db_user=userService.register(form_user, res);
		if(db_user==null)
		{
			model.addAttribute("userLogin", new TempUser());
			return "log_reg";			
		}
		return "redirect:/";
	}
	
	@GetMapping("/userdash")
	public String userdash(HttpSession session)//place session on any route that want to protect and to keep people who aren't logged in, out of.
	{
		if(session.getAttribute("user")==null) //the purpose of this statement is to redirect anyone who tries to navigate directly to the dashboard w/o logging in first
		{
			return "redirect:/";
		}
		
		return"user_dash";
	}
	
	
	@PostMapping("/login")
	public String login( @Valid @ModelAttribute("userLogin") TempUser tempUser, BindingResult res, Model model, HttpSession session )
	{
		if(res.hasErrors())
		{
			model.addAttribute("userRegister", new User());
			return "log_reg";
		}
		
		User db_user=userService.login(tempUser, res);
		if(db_user==null)
		{
			model.addAttribute("userRegister", new User());
			return "log_reg";
		}
		session.setAttribute("user", db_user);
		return"redirect:/userdash";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		userService.logout(session);
		return "redirect:/";
	}

};
