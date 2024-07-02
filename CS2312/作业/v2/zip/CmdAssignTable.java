import java.util.*;

public class CmdAssignTable extends RecordedCommand{
    Reservation reservation;
    ArrayList<Table> tables = new ArrayList<Table>();

    @Override
    public void execute(String[] cmdParts) {
        BookingOffice bo = BookingOffice.getInstance();
        try {
            if (cmdParts.length < 4) {
                throw new ExInsufficientCommand();
            }
            if (bo.checkValidDate(cmdParts[1])) {
                throw new ExDayAlreadyPassed();
            }
            int k = Integer.parseInt(cmdParts[2]);
            Reservation r = bo.findReservation(cmdParts[1], k);
            if ( r == null) {
                throw new ExBookingNotFound();
            }
            reservation = bo.findReservation(cmdParts[1], k);
            ArrayList<Table> tablesToBeAssigned = new ArrayList<Table>();   
            int countSeats = 0;
            for (int i = 3; i < cmdParts.length; i++) {
                if (bo.findTable(cmdParts[i]) == null) {
                    throw new ExTableCodeNotFound(cmdParts[i]);
                }
                Table t = bo.findTable(cmdParts[i]);
                if (!r.checkPending()) {
                    throw new ExTableAlreadyAssignedToThis();
                }
                if (t.ExTableAlreadyAssignedToAnother(cmdParts[1], r)) {
                    throw new ExTableAlreadyAssignedToAnother(t.toString());
                }
                tablesToBeAssigned.add(bo.findTable(cmdParts[i]));
                countSeats += bo.findTable(cmdParts[i]).getCapacity();
            }
            if (countSeats < r.getTotPersons()) {
                throw new ExNotEnoughSeats();
            }
            for (Table t: tablesToBeAssigned) {
                tables.add(t);
            }
            bo.assignTable(cmdParts[1], k, tablesToBeAssigned);
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
        } catch (ExTableCodeNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExBookingNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExNotEnoughSeats e) {
            System.out.println(e.getMessage());
        } catch (ExTableAlreadyAssignedToThis e)  {
            System.out.println(e.getMessage());
        } catch (ExTableAlreadyAssignedToAnother e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        bo.undoAssignTable(reservation, tables);
        //bo.unassignTable(cmdParts[1]);
        addRedoCommand(this);
    }

    @Override
    public void redoMe() {
        BookingOffice bo = BookingOffice.getInstance();
        bo.assignTable(reservation.getDateDine().toString(), reservation.getTicketCode(), tables);
        addUndoCommand(this);
    }
}
