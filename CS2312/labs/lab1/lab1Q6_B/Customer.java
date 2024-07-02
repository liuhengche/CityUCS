public class Customer {
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

    public void pay(double m) {
        this.totalMoney -= m;
    }

    public void set(int m) {
        this.totalMoney = m;
    }

}
