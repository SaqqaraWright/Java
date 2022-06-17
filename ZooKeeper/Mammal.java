import java.util.ArrayList;

class Mammal{
    
    //Member Variables
    protected String name;
    protected String species;
    protected Integer energyLevel=100;
    
    //Constructor
    public Mammal(String name,String species,Integer energyLevel) 
	{
		this.name=name;
		this.species=species;
		this.energyLevel=energyLevel;
	}

    //Methods
    public int displayEnergy()
    {
        System.out.println(name+"'s energy level is "+energyLevel);
        return energyLevel;
    }

    //Getters and Setters
    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int number) {
		this.energyLevel = number;
	}

    public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}




}