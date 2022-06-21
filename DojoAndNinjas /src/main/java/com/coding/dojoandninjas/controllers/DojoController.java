package com.coding.dojoandninjas.controllers;

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

import com.coding.dojoandninjas.models.Dojo;
import com.coding.dojoandninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController 
{
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/new")
	public String createDojo(Model model)
	{
		model.addAttribute("dojo", new Dojo());
		return "dojo";
	}
	
	@PostMapping("/new")
	public String insertDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res)
	{
		if(res.hasErrors())
		{
			return "dojo";
		}
		dojoService.create(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/{id}")
	public String findDojoById(@PathVariable("id") Long dojoid, Model model)
	{
		//select * from dojo join ninja on dojo.id=ninja.dojo_id;
		model.addAttribute("dojo", dojoService.findById(dojoid));
		return "show";
		
	}

};
