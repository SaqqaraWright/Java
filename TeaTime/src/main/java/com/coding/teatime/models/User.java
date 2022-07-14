package com.coding.teatime.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required")
	@Size(min=3, max=255, message="Name must be between 3 and 255 characters")
	private String name;
	
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	private String password;
	
	@Transient //this keeps it from storing this property in the database but allows us to include it in the model, so that we can compare the passwords to it.
	@NotEmpty(message="Confirm Password is required") 
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;	
	
	//This is where the join takes place
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List <Rating> ratings;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List <Tea> teas;//make sure to check to see if this is done correctly


	
	
	public List<Tea> getTeas() {
		return teas;
	}


	public void setTeas(List<Tea> teas) {
		this.teas = teas;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public List<Rating> getRatings() {
		return ratings;
	}


	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
	
};
