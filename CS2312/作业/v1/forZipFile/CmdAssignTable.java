import java.util.*;

public class CmdAssignTable extends RecordedCommand{
    @Override
    public void execute(String[] cmdParts) {
        BookingOffice bo = BookingOffice.getInstance();
        ArrayList<Table> tablesToBeAssigned = new ArrayList<Table>();   
        for (int i = 3; i < cmdParts.length; i++) {
            tablesToBeAssigned.add(bo.findTable(cmdParts[i]));
        }
        bo.assignTable(cmdParts[1], Integer.parseInt(cmdParts[2]), tablesToBeAssigned);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        //bo.unassignTable(cmdParts[1]);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        //bo.assignTable(cmdParts[1], Integer.parseInt(cmdParts[2]));
        addUndoCommand(this);
    }
}
