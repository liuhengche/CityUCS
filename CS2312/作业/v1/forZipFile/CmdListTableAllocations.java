public class CmdListTableAllocations implements Command{
    public void execute(String[] cmdParts) {
        BookingOffice bo = BookingOffice.getInstance();
        bo.listTableAllocations(cmdParts[1]);
    }
}
