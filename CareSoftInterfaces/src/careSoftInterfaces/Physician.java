package careSoftInterfaces;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser
{
	private ArrayList<String> patientNotes; //this is a member variable
	
	//Constructor
	public Physician(int id)
	{
		this.id=id;
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if(pin<1000||pin>9999) return false;
		this.pin=pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) 
	{
		
		return confirmedAuthID==pin;
	}       
    
	
      
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    


};
