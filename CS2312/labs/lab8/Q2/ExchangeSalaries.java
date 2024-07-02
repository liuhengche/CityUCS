public class ExchangeSalaries extends RecordedCommand{
    private Employee e1;
    private Employee e2;
    private int salary1;
    private int salary2;

    @Override
    public void execute(String [] cmdParts) {
        Company company = Company.getInstance();
        e1 = company.findEmployee(cmdParts[1]);
        e2 = company.findEmployee(cmdParts[2]);

        salary1 = e1.getSalary();
        salary2 = e2.getSalary();

        e1.setSalary(salary2);
        e2.setSalary(salary1);

        addUndoCommand(this);
        clearRedoList();

        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        e1.setSalary(salary1);
        e2.setSalary(salary2);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        e1.setSalary(salary2);
        e2.setSalary(salary1);
        addUndoCommand(this);
    }
}
