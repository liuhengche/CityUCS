public class CmdSuggestTable implements Command{
    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length < 3) {
                throw new ExInsufficientCommand();
            }
            BookingOffice bo = BookingOffice.getInstance();
            int k = Integer.parseInt(cmdParts[2]);
            Reservation r = bo.findReservation(cmdParts[1], k);
            if (r == null) {
                throw new ExBookingNotFound();
            }
            bo.suggestTable(cmdParts[1], k); 
        } catch (ExInsufficientCommand e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            ExWrongNumberFormat ex = new ExWrongNumberFormat();
            System.out.println(ex.getMessage());
        } catch (ExBookingNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
