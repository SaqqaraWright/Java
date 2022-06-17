import java.util.ArrayList;
import java.util.Scanner;//allows for user to give user input

class CafeUtil {
    public int getStreakGoal(int numWeeks) //static allows for a function or variable that is only accessible on a class but not an instance, to be accessed globally.  That is why static was placed on this method as well.
    {
        int i=1;
        int sum=0;
        while (i<numWeeks)
        {
            i++;
            sum+=i;
        }
            return sum;
    }
    public double getOrderTotal(double[] prices)
    {
        double sum=0;

        for (int i=0; i<prices.length; i++)
        {
            sum+=i;
        }
            return sum;
    } 
    public void displayMenu(ArrayList<String>menuItems)
    {
        for (int i=0; i<menuItems.size(); i++){
            String name= menuItems.get(i);
            System.out.println(name);
        }
    }
    public void addCustomer(ArrayList<String> customers, Scanner scan)
    {
        System.out.println("Please enter your name");
        String userName = scan.nextLine(); // this does the same thing as the System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customers.size() + " in front of you");
        customers.add(userName);
    }







}