class Employee {
    private String name;
    private int id;
    private String department;
    private String position;
    private double salary;

    public Employee(String name, int id, String department, String position, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nDepartment: " + department + "\nPosition: " + position + "\nSalary: " + salary;
    }
}