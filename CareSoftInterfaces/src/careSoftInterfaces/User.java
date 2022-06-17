package careSoftInterfaces;

public class User 
{
	protected Integer id; //capital Integer is here so that it can be null unlike with the lower case version i.e. int
	protected int pin;
	
	//Constructor
	public User()
	{
		
	}
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}		
	
	
};
