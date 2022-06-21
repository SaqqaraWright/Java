package com.coding.dojoandninjas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dojoandninjas.models.Dojo;
import com.coding.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService 
{
	@Autowired
	private DojoRepository dojoRepository;
	
	public void create(Dojo dojo)
	{
		//insert into dojo(name) values(dojo.getName());
		dojoRepository.save(dojo);
	}
	
	public ArrayList<Dojo> findAll()
	{
		//select * from dojo;
		return (ArrayList<Dojo>)dojoRepository.findAll();
	}
	
	public Dojo findById(Long id)
	{
		//select * from dojo where dojo.id=?
		return dojoRepository.findById(id).orElse(null);
	}
	
	public void update(Dojo dojo)
	{
		dojoRepository.save(dojo);
	}
	
	public void deleteById(Long id)
	{
		//delete from dojo where id = ?
		dojoRepository.deleteById(id);
	}

};
