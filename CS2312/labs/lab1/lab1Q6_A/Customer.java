public class Customer { // public is needed if the files are in different packages;
    private int totalMoney;


    public Customer(int m) {
        this.totalMoney = m;
    }

    public int getAmount() {
        return this.totalMoney;
    }

    public void pay(int m) {
        this.totalMoney -= m;
    }

    public void set(int m) {
        this.totalMoney = m;
    }

}
