public class AgeGroupCounter extends Counter{
    private int a1;
    private int a2;

    public AgeGroupCounter(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }
    public String toString()
    {
        return String.format("[Age %d to %d] Count = %d", a1, a2, getCount());
    }
    public void countData(Record r) {
        if (r.getAge() >= a1 && r.getAge() <= a2) {
            super.countData(r);
        }
    }
}
