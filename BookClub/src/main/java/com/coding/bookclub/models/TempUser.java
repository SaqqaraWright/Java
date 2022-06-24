package com.coding.bookclub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    
public class TempUser 
{ //LoginUser, but calling it TempUser because they aren't actually getting stored in the database, just comparing them against info already stored in the database
	    
    @NotEmpty(message="Email is required!") //Could use @NotNull, but @NotEmpty means/does the exact same thing
    @Email(message="Please enter a valid email")
    private String email;
    
    @NotEmpty(message="Password is required")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    public TempUser() {}

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
	    
	    
};


