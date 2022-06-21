package com.coding.dojoandninjas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dojoandninjas.models.Ninja;
import com.coding.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService
{
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public void create(Ninja ninja)
	{
		//insert into ninja(firstName, lastName, age) values(ninja.getFirstName(), ninja.getLastName(), ninja.getAge());
		ninjaRepository.save(ninja);
	}
	
	public ArrayList<Ninja> findAll()
	{
		//select * from ninja;
		return (ArrayList<Ninja>)ninjaRepository.findAll();
	}
	
	public Ninja findById(Long id)
	{
		//select * from ninja where ninja.id=?
		return ninjaRepository.findById(id).orElse(null);
	}
	
	public void update(Ninja ninja)
	{
		ninjaRepository.save(ninja);
	}
	
	public void deleteById(Long id)
	{
		//delete from ninja where id = ?
		ninjaRepository.deleteById(id);
	}
};
