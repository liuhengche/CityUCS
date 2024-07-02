import java.util.ArrayList;

public class CmdRequest extends RecordedCommand {
    private Reservation r;
    private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    @Override
    public void execute(String[] cmdParts) {
        try {
            BookingOffice bo = BookingOffice.getInstance();
            if (cmdParts.length < 5) {
                throw new ExInsufficientCommand();
            }
            if (bo.findReservationByPho(cmdParts[2], cmdParts[4])) {
                throw new ExBookingAlreadyExists();
            }
            if (bo.checkValidDate(cmdParts[4])) {
                throw new ExDayAlreadyPassed();
            }
            boolean found = false;
            int k = Integer.parseInt(cmdParts[3]);
            for (Reservation re: reservations) {
                if (re.checkEqual(cmdParts)) {
                    found = true;
                    r = re;
                    break;
                }
            }
            if (found) {
                bo.changeRequestDate(r);
                bo.addReservation(r);
            }
            if (!found) {
                r = bo.addReservation(cmdParts[1], cmdParts[2], k, cmdParts[4]);
                reservations.add(r);
            }
            addUndoCommand(this);
            clearRedoList();
            System.out.printf("Done. Ticket code for %s: %d\n", cmdParts[4], r.getTicketCode());
        } catch (ExInsufficientCommand e) {
            System.out.println(e.getMessage());
        } catch (ExBookingAlreadyExists e) {
            System.out.println(e.getMessage());
        } catch (ExDayAlreadyPassed e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            ExWrongNumberFormat ex = new ExWrongNumberFormat();
            System.out.println(ex.getMessage());
        }
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
