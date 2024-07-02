public class ExTableAlreadyAssignedToThis extends Exception{
    public ExTableAlreadyAssignedToThis(){
        super("Table(s) already assigned for this booking!");
    }
}
