package com.coding.teatime.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="rating")
public class Rating 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //added this in due to error got in server; however, now sure if this is actually needed here.
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tea_id")
	private Tea tea;
	
	@Min(value=1, message="Rating must be a minimum of 1")
	@Max(value=5, message="Rating can be no higher than 5")	
	private int rating;
	
	
	//Getters and Setters
	
	public Long getId() { //this was added, check if actually needed
		return id;
	}
	public void setId(Long id) { //this was added as well...
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tea getTea() {
		return tea;
	}
	public void setTea(Tea tea) {
		this.tea = tea;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
};
