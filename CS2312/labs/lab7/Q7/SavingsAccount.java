public class SavingsAccount extends Account{
    private double balance;


    public SavingsAccount(String ano, double bal) {
        super(ano);
        this.balance = bal;
    }

    @Override
    public double getTotal() {
        return balance;
    }

    @Override
    public String toString() {        
        return "Savings A/C Number: "+this.getAccountNumber()+
        " Balance: $"+String.format("%.2f",this.getTotal());
    }
}