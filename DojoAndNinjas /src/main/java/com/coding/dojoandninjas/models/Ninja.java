package com.coding.dojoandninjas.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ninja")
public class Ninja 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="First name is required")
	@Size(min=3, message="First name must be atleast 3 characters long")
	private String firstName;
	
	@NotNull(message="Last name is required")
	@Size(min=3, message="Last name must be atleast 3 characters long")
	private String lastName;
	
	@NotNull(message="Age is required")
	@Min(value=18, message="Must be atleast 18 years of age")
	private Integer age;
	
	@NotNull(message="Dojo is required")
	@ManyToOne(fetch=FetchType.LAZY) //this is where the join/relationship is established and happens between the ninjas and the dojos
	@JoinColumn(name="dojo_id")
	private Dojo dojo; //the key dojo in purple to the right must match the "dojo" in the ninja model.
	
	public Dojo getDojo() {
		return dojo;
	}


	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}


	public Ninja()//I don't think I need this; however, will keep temporarily unless causes issues...then delete.
	{
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

};
