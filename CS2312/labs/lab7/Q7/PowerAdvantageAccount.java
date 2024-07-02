public class PowerAdvantageAccount extends Account {
    private SavingsAccount savingsAC;
    private CreditCardAccount creditAC;
    

    public PowerAdvantageAccount(String ano, SavingsAccount sa, CreditCardAccount cr) {
        super(ano);
        this.savingsAC = sa;
        this.creditAC = cr;
    }

    @Override
    public double getTotal() {
        return savingsAC.getTotal() - creditAC.getTotal();
    }

    @Override
    public String toString() {
        return "Power Advantage A/C Number: "+this.getAccountNumber()+" Balance: $"+String.format("%.2f",this.getTotal())+
				"\n 1."+this.savingsAC.toString()+
				"\n 2."+this.creditAC.toString();
    }

}