package com.coding.teatime.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.teatime.models.Tea;
import com.coding.teatime.repositories.TeaRepository;



@Service
public class TeaService 
{
	@Autowired
	private TeaRepository teaRepository;
	
	public void create(Tea tea) //create method
	{
		teaRepository.save(tea);		
	}
	
	public void update(Tea tea) //update method
	{
		teaRepository.save(tea);		
	}
	
	public ArrayList<Tea> findAll()  //"find all" method: read
	{
		return teaRepository.findAll();
	}
	
	public Tea findById(Long id)
	{
		return teaRepository.findById(id).orElse(null); //"find one" method
	}
	
	public void deleteById(Long id) //delete method
	{
		teaRepository.deleteById(id);
	}

};
