package com.coding.travels.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.travels.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> //the Long refers to the primary key type in my Travel model which is the id and it is a Long. Primary meaning first key type.
{
	//custom queries can go here
};
