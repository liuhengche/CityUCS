public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("John", 123, "Sales", "Manager", 75000);
        System.out.println(manager);
        Employee a = new Employee("John", 123, "Sales", "Manager", 75000);
        Employee b = new Manager(null, 0, null, null, 0);
        Manager c = (Manager) new Employee(null, 0, null, null, 0);
        // this is wrong because you can't assign a superclass to a subclass, but you can assign a subclass to a superclass
        // upcasting: subclass to superclass; upcasting is allowed
        // downcasting: superclass to subclass; downcasting is not alloweds
        // after adding (Manager) the statement is allowed; because it is a cast;
    }
}
