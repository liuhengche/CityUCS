public class CmdListTableAllocations implements Command{
    public void execute(String[] cmdParts) throws ExInsufficientCommand{
        if (cmdParts.length < 2) {
            throw new ExInsufficientCommand();
        }
        BookingOffice bo = BookingOffice.getInstance();
        bo.listTableAllocations(cmdParts[1]);
        
    }
}
