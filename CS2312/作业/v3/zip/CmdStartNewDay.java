public class CmdStartNewDay extends RecordedCommand{
    Day newDay;
    Day oldDay = SystemDate.getInstance().clone();
    

    @Override
    public void execute(String[] cmdParts) throws ExInsufficientCommand{
        if (SystemDate.getInstance() == null) {
            newDay = new Day(cmdParts[1]);
            SystemDate.createTheInstance(cmdParts[1]);
        } else {
            if (cmdParts.length < 2) {
                throw new ExInsufficientCommand();
            }
            newDay = new Day(cmdParts[1]);
            SystemDate.getInstance().set(cmdParts[1]);
            addUndoCommand(this);
            clearRedoList();
            System.out.println("Done.");
        }
    }


    @Override
    public void undoMe() {
        SystemDate.getInstance().set(oldDay.toString());
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        SystemDate.getInstance().set(newDay.toString());
        addUndoCommand(this);
    }

   
}
