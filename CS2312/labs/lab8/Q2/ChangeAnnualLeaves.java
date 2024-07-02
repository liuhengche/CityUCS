public class ChangeAnnualLeaves extends RecordedCommand {
    private Employee e;
    private int newLeaves;
    private int oldeLeaves;

    @Override
    public void execute(String [] cmdParts) {
        Company company = Company.getInstance();
        e = company.findEmployee(cmdParts[1]);
        newLeaves = Integer.parseInt(cmdParts[2]);

        addUndoCommand(this);
        clearRedoList();

        oldeLeaves = e.getAnnualLeaves();

        e.setAnnualLeaves(newLeaves);
        System.out.println("Done.");

    }

    @Override
    public void undoMe() {
        e.setAnnualLeaves(oldeLeaves);
        addRedoCommand(this);
    }
    

    @Override
    public void redoMe() {
        e.setAnnualLeaves(newLeaves);
        addUndoCommand(this);
    }
}
