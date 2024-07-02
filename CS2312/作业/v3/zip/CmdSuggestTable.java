public class CmdSuggestTable implements Command{
    @Override
    public void execute(String[] cmdParts) throws ExInsufficientCommand, ExBookingNotFound, ExTableAlreadyAssignedToThis, ExNotEnoughTableForSuggestion{
        if (cmdParts.length < 3) {
            throw new ExInsufficientCommand();
        }
        BookingOffice bo = BookingOffice.getInstance();
        int k = Integer.parseInt(cmdParts[2]);
        Reservation r = bo.findReservation(cmdParts[1], k);
        if (r == null) {
            throw new ExBookingNotFound();
        }
        if (!r.checkPending()) {
            throw new ExTableAlreadyAssignedToThis();
        }
        bo.suggestTable(cmdParts[1], k); 
    }
}
