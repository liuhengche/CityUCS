public class ExTableAlreadyAssignedToAnother extends Exception{
    public ExTableAlreadyAssignedToAnother(String tableName){
        super(String.format("Table %s is already reserved by another booking!",tableName));
    }
}
