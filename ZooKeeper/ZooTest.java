public class ZooTest
{
    
	public static void main(String[] args)
	{
		Gorilla kingKong = new Gorilla("kingKong");
        kingKong.setEnergyLevel(150);
        kingKong.setSpecies("gorilla");
        kingKong.throwSomething();
        kingKong.throwSomething();
        kingKong.throwSomething();
        kingKong.eatBananas();
        kingKong.eatBananas();
        kingKong.climb();
        System.out.println(kingKong.displayEnergy());


        Bat crazyBat= new Bat("crazyBat");
        crazyBat.attackTown();
        crazyBat.attackTown();
        crazyBat.attackTown();
        crazyBat.eatHumans();
        crazyBat.eatHumans();
        crazyBat.fly();
        crazyBat.fly();
        System.out.println(crazyBat.displayEnergy());




		// Penguin pete=new Penguin("Pete","penguin",20,true);

		// Deer bambi=new Deer();
		// bambi.setAge(40);
		// bambi.setName("Bambi");
		// bambi.setSpecies("Deer");
		// bambi.setIsmammal(true);
	}


};