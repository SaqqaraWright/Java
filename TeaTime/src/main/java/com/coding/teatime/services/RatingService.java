package com.coding.teatime.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.teatime.models.Rating;
import com.coding.teatime.models.Tea;
import com.coding.teatime.repositories.RatingRepository;



@Service
public class RatingService 
{
	@Autowired
	private RatingRepository ratingRepository;
	
	public void create(Rating rating) //create method
	{
		ratingRepository.save(rating);		
	}
	
	public void update(Rating rating) //update method
	{
		ratingRepository.save(rating);		
	}
	
	public ArrayList<Rating> findAll()  //"find all" method: read
	{
		return ratingRepository.findAll();
	}
	
	public ArrayList<Rating> findAllWithTea(Tea tea)  //"find all with tea" method: read
	{
		return ratingRepository.findAllByTea(tea);
	}
	
	public Rating findById(Long id)
	{
		return ratingRepository.findById(id).orElse(null); //"find one" method
	}
	
	public void deleteById(Long id) //delete method
	{
		ratingRepository.deleteById(id);
	}

}
