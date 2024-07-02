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

    public void setAnnualLeaves(int newLeaves) {
        annualLeaves = newLeaves;
    }

    public int getAnnualLeaves() {
        return annualLeaves;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int newSalary) {
        salary = newSalary;
    }
    @Override
    public String toString() {
        return this.name + " ($"+this.salary+", "+this.annualLeaves+" days)";
     }
}