public class Fire extends RecordedCommand{
    private Employee e;

    @Override
    public void execute(String [] cmdParts) {
        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        company.removeEmployee(e);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        Company company = Company.getInstance();
        company.addEmployee(e);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        Company company = Company.getInstance();
        company.removeEmployee(e);
        addUndoCommand(this);
    }
}
