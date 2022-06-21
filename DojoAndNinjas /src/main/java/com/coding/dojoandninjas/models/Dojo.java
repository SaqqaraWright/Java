package com.coding.dojoandninjas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="dojo")
public class Dojo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Dojo name is required")
	@Size(min=3, message="Dojo name must be atleast 3 characters long")
	private String name;
	
	@OneToMany(mappedBy="dojo",fetch=FetchType.LAZY) //what is placed in the double quotes, in this case "dojo", must be located on the opposing model, they must match.
	private List<Ninja> ninjas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Ninja> getNinjas() { //I created the setters and getters for this
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) { //and this as well...
		this.ninjas = ninjas;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dojo()
	{
		
	}
			

};
