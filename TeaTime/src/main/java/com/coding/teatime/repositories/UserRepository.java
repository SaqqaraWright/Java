package com.coding.teatime.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.coding.teatime.models.User;



public interface UserRepository extends CrudRepository<User, Long>
{
	public ArrayList<User> findAll();
	//select * from user where user.name=?
	public User findByName(String name); //Note: these must match the properties in the User model i.e in this case name and email (don't want to opt to find someone by password, this is sketchy, not very secure)
	
	//select * from user where user.email=?
	public User findByEmail(String email);//This is the only one that is truly needed, the findByName function was included just for educational purposes

};