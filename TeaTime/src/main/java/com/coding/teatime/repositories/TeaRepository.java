package com.coding.teatime.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.coding.teatime.models.Tea;

public interface TeaRepository extends CrudRepository<Tea, Long>
{
	public ArrayList<Tea> findAll();

};
