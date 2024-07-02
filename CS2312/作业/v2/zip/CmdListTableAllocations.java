public class CmdListTableAllocations implements Command{
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length < 2) {
                throw new ExInsufficientCommand();
            }
            BookingOffice bo = BookingOffice.getInstance();
            bo.listTableAllocations(cmdParts[1]);
        } catch (ExInsufficientCommand e) {
            System.out.println(e.getMessage());
        }
    }
}
