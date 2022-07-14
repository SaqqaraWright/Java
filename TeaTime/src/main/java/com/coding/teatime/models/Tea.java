package com.coding.teatime.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Tea 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message="Tea name is required")
	@Size(min=3, max=255, message="Name must be between 3 and 255 characters")
	private String name;
	
	@NotEmpty(message="Tea type is required i.e Bubble tea, herbal tea, etc.")
	private String type;
	
	@NotEmpty(message="Ingredients are required")
	@Size(min=8, message="Ingredients must be atleast 8 characters")
	private String ingredient;
	
	@NotEmpty(message="Description is required")
	@Size(min=8, message="Description must be atleast 8 characters")
	private String description;
	
	//This is where the join takes place
	@OneToMany(mappedBy="tea", fetch=FetchType.LAZY)
	private List <Rating> ratedTeas;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public double calcRating()
	{
	  int total = 0;
	  //iterate over ratings, add into total;
	  for(Rating r : ratedTeas) { 
		  total+=r.getRating();
	  }
	  if(total==0)
		  return 0;
	  double avg = total / ratedTeas.size();
	  return avg;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Rating> getRatedTeas() {
		return ratedTeas;
	}

	public void setRatedTeas(List<Rating> ratedTeas) {
		this.ratedTeas = ratedTeas;
	}
};
