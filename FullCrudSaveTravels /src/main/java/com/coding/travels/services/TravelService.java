package com.coding.travels.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.travels.models.Travel;
import com.coding.travels.repositories.TravelRepository;

//All service class files will look like this so can basically copy and paste it for other assignments and change variable names.
@Service
public class TravelService 
{
	@Autowired
	private TravelRepository travelRepository;
	
	//insert into travel() values();
	public void create (Travel travel)
	{
		travelRepository.save(travel); //no need to create an update function in java because the system is smart enough to just update on its own, a "save" function is sufficient enough for both.
	}
	
	//update table movie(lknakd,jkaljd, ajkdj) values(jamdn,jakdaj) where travel.id=travel.getId()
	public void update(Travel travel)// this isn't necessary as noted above but just made it for visual
	{
		travelRepository.save(travel);
	}
	
	//select * from Travel
	public ArrayList<Travel> findAll()
	{
		return (ArrayList<Travel>) travelRepository.findAll();
	}
	
	//select * from Travel where travel.id=?;
	public Travel findOne(Long id)
	{
		Optional<Travel> travel=travelRepository.findById(id);
		return travel.isPresent()?travel.get():null; //this ternary operator allows me to bypass the typical mystery response that comes with an optional and to have more control over what the response I get back by stating if there's nothing in the list then return null.
	}
	
	public void deleteOne(Long id)
	{
		travelRepository.deleteById(id);
	}
	
};
