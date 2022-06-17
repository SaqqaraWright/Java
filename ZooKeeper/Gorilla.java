public class Gorilla extends Mammal
{
	public Gorilla(String name)
	{
		super(name, "gorilla",100);
	}

	public void throwSomething()
	{
        energyLevel-=5;
		System.out.println("King Kong just threw something, oh noooo!");

	}

    public void eatBananas()
	{
        energyLevel+=10;
		System.out.println("Our Friendly Gorilla, King Kong, just ate a banana...all is right in the world again...oh yeah");
	}

    public void climb()
	{
        energyLevel-=10;
		System.out.println("Our Gorilla friend climbed a tree! What a workout, whew...");
	}
};