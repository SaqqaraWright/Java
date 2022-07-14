package com.coding.teatime.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.teatime.models.TempUser;
import com.coding.teatime.models.User;
import com.coding.teatime.services.UserService;



@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
//	@GetMapping("") //this applied to the one page log-reg which didn't required different routes for the login/registration
//	public String log_reg( Model model )
//	{
//		model.addAttribute("userRegister", new User());
//		model.addAttribute("userLogin", new TempUser());
//		return "log_reg";
//	}
	
	
	@GetMapping("/register") //I separated the register and login into two diff. jsps thus I've given them each their own route
	public String regUser(Model model)
	{
		model.addAttribute("userRegister", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("userRegister")User form_user, BindingResult res, Model model)
	{
		if(res.hasErrors())
		{
			model.addAttribute("userLogin", new TempUser());
			return "register";
		}
		User db_user=userService.register(form_user, res);
		if(db_user==null)
		{
			model.addAttribute("userLogin", new TempUser());
			return "register";			
		}
		return "redirect:/teas";
	}	
	
	@GetMapping("/login")
	public String logUser(Model model)
	{
		model.addAttribute("userLogin", new TempUser());
		return "login";
	}
	
	@PostMapping("/login")
	public String login( @Valid @ModelAttribute("userLogin") TempUser tempUser, BindingResult res, Model model, HttpSession session )
	{
		if(res.hasErrors())
		{
			model.addAttribute("userRegister", new User());
			return "login";
		}
		
		User db_user=userService.login(tempUser, res);
		if(db_user==null)
		{
			model.addAttribute("userRegister", new User());
			return "login";
		}
		session.setAttribute("user", db_user);
		return"redirect:/teas";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		userService.logout(session);
		return "redirect:/login";
	}

};



