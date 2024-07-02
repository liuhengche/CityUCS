import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> allEmployees;

    private Company() {
        allEmployees = new ArrayList<Employee>();
    }

    public void listEmployees() {
        for (Employee e : allEmployees) {
            System.out.println(e);
        }
    }

    public Employee findEmployee(String name) {
        for (Employee e : allEmployees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public void addEmployee(Employee e) {
        allEmployees.add(e);
    }

    private static Company instance = new Company();
    public static Company getInstance() {
        return instance;
    }

    public void removeEmployee(Employee e) {
        allEmployees.remove(e);
    }
}
