package com.coding.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.dojoandninjas.models.Ninja;
import com.coding.dojoandninjas.services.DojoService;
import com.coding.dojoandninjas.services.NinjaService;




@Controller
@RequestMapping("/ninjas")
public class NinjaController 
{
	@Autowired//this keeps me from having to manually type a constructor for NinjaService, it condenses the whole thing
	private NinjaService ninjaService;	
	@Autowired
	private DojoService dojoService;
	
	
	@GetMapping("/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja )
	{
		model.addAttribute("dojo", dojoService.findAll());
		return "ninja";
	}
	
	@PostMapping("/new") //added this including the @Autowired, not sure if I need it for this assignment
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult res) //allows me to run/show validations located in the model onto the page Note: BindingResult holds onto possible errors
	{
		if(res.hasErrors())
		{
			return "ninja";	
		}
		ninjaService.create(ninja);		
		return "redirect:/ninjas/new"; //could have this redirect back to /ninjas/new; however, the show page seems to pretty ideal here.
	}
	



};
