package com.coding.teatime.repositories;

import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.teatime.models.Rating;
import com.coding.teatime.models.Tea;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>
{
	 ArrayList<Rating> findAllByTea(Tea tea);
	 
	 public ArrayList<Rating> findAll();
	 
	 

};
