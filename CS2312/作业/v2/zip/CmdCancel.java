import java.util.ArrayList;

public class CmdCancel extends RecordedCommand{
    Reservation reservation;
    ArrayList<Table> tables = new ArrayList<Table>();
    @Override
    public void execute(String[] cmdParts) {
        BookingOffice bo = BookingOffice.getInstance();
        try {
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
        } catch (ExInsufficientCommand e) {
            System.out.println(e.getMessage());
        } catch (ExDayAlreadyPassed e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            ExWrongNumberFormat ex = new ExWrongNumberFormat();
            System.out.println(ex.getMessage());
        } catch (ExBookingNotFound e) {
            System.out.println(e.getMessage());
        }
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
