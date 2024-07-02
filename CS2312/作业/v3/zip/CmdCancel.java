import java.util.ArrayList;

public class CmdCancel extends RecordedCommand{
    Reservation reservation;
    ArrayList<Table> tables = new ArrayList<Table>();
    @Override
    public void execute(String[] cmdParts) throws ExInsufficientCommand, ExDayAlreadyPassed, ExBookingNotFound, NumberFormatException{
        BookingOffice bo = BookingOffice.getInstance();
        if (cmdParts.length < 3) {
            throw new ExInsufficientCommand();
        }
        if (bo.checkValidDate(cmdParts[1])) {
            throw new ExDayAlreadyPassed();
        }
        int k = Integer.parseInt(cmdParts[2]);
        Reservation r = bo.findReservation(cmdParts[1], k);
        if (r == null) {
            throw new ExBookingNotFound();
        }
        reservation = bo.findReservation(cmdParts[1], k);
        bo.cancelBooking(cmdParts[1], k, tables);
        addUndoCommand(this);
        clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        bo.undoCancelBooking(reservation, tables);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        bo.cancelBooking(reservation.getDateDine().toString(), reservation.getTicketCode(), tables);
        addUndoCommand(this);
    }
}
