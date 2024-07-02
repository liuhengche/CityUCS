class Employee {
    private String name;
    private int salary;
    private int annualLeaves;

    public Employee(String name, int salary, int annualLeaves) {
        this.name = name;
        this.salary = salary;
        this.annualLeaves = annualLeaves;
    }

    public String getName() {
        return name;
    }

    public void addSalary(int increase) {
        salary += increase;
    }

    @Override
    public String toString() {
        return this.name + " ($"+this.salary+", "+this.annualLeaves+" days)";
     }
}