public class CmdRequest extends RecordedCommand {
    Reservation r;
    
    @Override
    public void execute(String[] cmdParts) {
        BookingOffice bo = BookingOffice.getInstance();
        r = bo.addReservation(cmdParts[1], cmdParts[2], Integer.parseInt(cmdParts[3]), cmdParts[4]);
        addUndoCommand(this);
        clearRedoList();
        System.out.printf("Done. Ticket code for %s: %d\n", cmdParts[4], r.getTicketCode());
    }

    @Override
    public void undoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        bo.removeReservation(r);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        bo.addReservation(r);
        addUndoCommand(this);
    }
}
