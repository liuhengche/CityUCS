public class Group {
    private Customer[] customers;
    private int size;

    public Group() {
        this.customers = new Customer[10];
        this.size = 0;
    }

    public void add(Customer c) {
        this.customers[this.size] = c;
        this.size++;
    }

    public Customer get(int i) {
        return this.customers[i];
    }

    public int size() {
        return this.size;
    }
    
}
