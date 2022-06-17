import java.util.ArrayList;

class BankAccount {
    //member variables
    private Double savingsBalance;
    private Double checkingBalance;
    private static int numberOfAccounts; //these two are static because their tied to the class and not individual instances
    private static Double totalFunds;
    
    //Class methods
    public BankAccount(Double _savingsBalance, Double _checkingBalance)// this is my constructor
    {
        savingsBalance = _savingsBalance;
        checkingBalance = _checkingBalance;
        numberOfAccounts++;
    }

    //getter
    public Double getsavingsBalance() {
        return savingsBalance;
    }

    //setter
    public void setsavingsBalance(Double number) {
        this.savingsBalance = number;
    }

    //getter
    public Double getcheckingBalance() {
        return checkingBalance;
    }

    //setter
    public void setcheckingBalance(Double number) {
        this.checkingBalance = number;
    }
    

    // getter
    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    
    // setter
    public void setNumberOfAccounts(int number) {
        this.numberOfAccounts = number;
    }

    public void Deposit(Double number, String account)//void means it doesn't return anything
    {
        if(account.equals("checking")){
            checkingBalance+=number;
        }else{
            savingsBalance+=number;
        }
    }

    public void Withdraw(Double amount, String account)
    {
        if(account.equals("checking")){
            if(amount>checkingBalance){
                System.out.println("Insufficient Funds");
            }else{
                checkingBalance-=amount;
            }
        } 
        
        if(account.equals("savings")){
            if(amount>savingsBalance){
                System.out.println("Insufficient Funds");
            }else{
                savingsBalance-=amount;
            }
        } 
    }

    public double viewAccountTotals()
    {
        return checkingBalance+savingsBalance;
    }





};