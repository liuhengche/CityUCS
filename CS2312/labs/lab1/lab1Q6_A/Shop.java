public class Shop {
    private int totalProfit;

    public void earn(Customer c, int m) {
        c.pay(m);
        this.totalProfit += m;
    }

    public int getProfit() {
        return this.totalProfit;
    }
}
