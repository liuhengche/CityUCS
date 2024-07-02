public class ExTableCodeNotFound extends Exception{
    public ExTableCodeNotFound(String tableCode){
        super("Table code "+ tableCode +" not found!");
    }
}
