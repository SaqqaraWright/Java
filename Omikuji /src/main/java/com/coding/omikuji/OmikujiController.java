package com.coding.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController 
{
	@GetMapping("/")
	public String home() 
	{
		return "index";
		
	}
	
	@GetMapping("/show")
	public String show(Model model, HttpSession session)
	{
		int number=(int)session.getAttribute("number");
		String city=(String)session.getAttribute("city");
		String name=(String)session.getAttribute("name");
		String hobby=(String)session.getAttribute("hobby");
		String thing=(String)session.getAttribute("thing");
		String compliment=(String)session.getAttribute("compliment");
		
		String omikuji="In "+number+" years, you will live in "+city+" with "+name+" as your roommate, selling "+hobby+" for a living"+"The next time you see a "+thing+" , you will have good luck."+" Also, "+compliment;
		model.addAttribute("omikuji", omikuji);
		return "show";
	}
	
	@PostMapping("/submit")
	public String process
	(
			@RequestParam("number") int number, 
			@RequestParam("city") String city,
			@RequestParam("name") String name, 
			@RequestParam("hobby") String hobby, 
			@RequestParam("thing") String thing, 
			@RequestParam("compliment") String compliment,
			HttpSession session
	)
	{
//		System.out.println(number);
//		System.out.println(city);
//		System.out.println(name);
//		System.out.println(hobby);
//		System.out.println(thing);
//		System.out.println(compliment);
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("compliment", compliment);
		
		return "redirect:/show";
	}
};
