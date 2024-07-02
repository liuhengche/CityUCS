public class Shop {
    private int totalProfit;

    public void earn(Customer c, int m) {
        c.pay(m);
        this.totalProfit += m;
    }

    public int getProfit() {
        return this.totalProfit;
    }

    public void earn(Group g, int m){
        double share = (double) m / g.size();
        for (int i = 0; i < g.size(); i++) {
            g.get(i).pay(share);
        }
        this.totalProfit += m;
    }
}
