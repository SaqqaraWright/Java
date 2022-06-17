package com.coding.travels.controllers;

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

import com.coding.travels.models.Travel;
import com.coding.travels.services.TravelService;

@Controller
@RequestMapping("/travel")
public class TravelsController 
{
	@Autowired//this keeps me from having to manually type a constructor for TravelService, it condenses the whole thing
	private TravelService travelService;
	
	
	
	@GetMapping("") //no need for the slash here as well as on the @PostMapping route because it's /travel not /travel/ in 8080 route...
	public String index(Model model)
	{
		model.addAttribute("travel", new Travel());//do this on any page that takes a model or creates an instance of something
		model.addAttribute("travels", travelService.findAll()); //"travels" will be placed in the "items" as the object that we will be iterating
		return "index";
	}
	
	@PostMapping("")
	public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult res) //allows me to run/show validations located in the model onto the page Note: BindingResult holds onto possible errors
	{
		if(res.hasErrors())
		{
			return "index";	
		}
		travelService.create(travel);		
		return "redirect:/travel";
	}
	
	@PostMapping("delete/{id}")
	public String deleteTravel(@PathVariable("id") Long travelId)
	{
		travelService.deleteOne(travelId);
		return "redirect:/travel";
		
	}
	
	@GetMapping("/show/{id}")
	public String show( @PathVariable("id") Long travelId, Model model )
	{
		model.addAttribute("travel", travelService.findOne(travelId));
		return "show";
	}
	
	@GetMapping("/edit/{id}")
	public String edit( @PathVariable("id") Long travelId, Model model )
	{
		model.addAttribute("travel", travelService.findOne(travelId));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult res)
	{
		if(res.hasErrors())
		{
			return "edit";
		}
		travelService.update(travel);
		return "redirect:/travel";
	}
			

}
