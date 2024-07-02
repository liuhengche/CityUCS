public class CmdSuggestTable implements Command{
    @Override
    public void execute(String[] cmdParts) {
        BookingOffice bo = BookingOffice.getInstance();
        // something
        bo.suggestTable(cmdParts[1], Integer.parseInt(cmdParts[2]));
    }
}
