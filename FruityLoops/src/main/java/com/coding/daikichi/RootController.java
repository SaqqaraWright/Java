package com.coding.daikichi;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RootController 
{
	@GetMapping("/")
	public String index(Model model) 
	{
						        
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75)); 
        
        model.addAttribute("basket", fruits); //the first one (in the string) is that key and the second one is the actual array
		//the first argument "fruits" is more important than the second one fruits because it's what we will have to use to reference the whole array in the .jsp			
		
		return "index";
	}
	
};
