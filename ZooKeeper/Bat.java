public class Bat extends Mammal
{
    public Bat(String name)//this should include the data types
	{
		super(name, "bat", 300);
	}

	public void fly()
	{
        energyLevel-=50;
		System.out.println("screeeech!!!..intense wing flapping sound");
	}

    public void eatHumans()
	{
        energyLevel+=25;
		System.out.println("munch, munch, yummmm, humans taste good...burrrp");
	}

    public void attackTown()
	{
        energyLevel-=100;
		System.out.println("fire!!! The sound of a town burning to the ground! Oh noooo!!!!");
	}
}