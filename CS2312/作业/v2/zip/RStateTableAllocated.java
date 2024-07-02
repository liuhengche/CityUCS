import java.util.ArrayList;

public class RStateTableAllocated implements RState{

    private ArrayList<Table> tables = new ArrayList<Table>();

    public RStateTableAllocated(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        String returnString = "Table assigned: ";
        for (Table table : tables) {
            returnString += table + " ";
        }
        return returnString;
    }
}
