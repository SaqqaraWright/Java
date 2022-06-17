package com.coding.travels.models;



import javax.persistence.Entity;//this (persistence) is jpa and will turn data into mysql code
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity //this says make it a database table
@Table(name="expense")
public class Travel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Expense name is required")
	@Size(min=3, max=255, message="Expense name must be between 3-255 characters")
	private String name;
	
	@NotNull(message="Vendor is required")
	@Size(min=3, max=255, message="Vendor name must be between 3-255 characters")
	private String vendor;
	
	@NotNull(message="price amount is required")
	@Min(value=1, message="price amount must be at least a $1.00")	
	private Double amount;
	
	@NotNull(message="Description is required")
	@Size(min=10, message="Description must be at least 10 characters long")
	private String description;
	
	public Travel()
	{
		
		
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
};
