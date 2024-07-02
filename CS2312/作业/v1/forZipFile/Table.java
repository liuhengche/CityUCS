import java.util.*;

public class Table implements Comparable<Table>{
    private String tableName;
    private int capacity;
    private Map<String, Boolean> availability = new HashMap<>();
    private Map<String, Reservation> reservations = new HashMap<>();

    public Table(String tableName, int capacity) {
        this.tableName = tableName;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Table another) {
        return tableName.compareTo(another.tableName);
        // something
    }

    public static void list(ArrayList<Table> tables) {
        // some implementation here.
    }


    @Override
    public String toString() {
        return tableName;
    }

    public void setAvailability(String date, boolean isAvailable) {
        availability.put(date, isAvailable);
    }

    public void assignReservation(String date, Reservation r) {
        reservations.put(date, r);
    }

    public boolean isAvailable(String date) {
        if (availability.containsKey(date)) {
            return availability.get(date);
        }
        else {
            return true;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void listTableAllocations(String date) {
        System.out.printf("%s (Ticket %d)\n", this, reservations.get(date).getTicketCode());
    }

    public void cancelBooking(String date) {
        reservations.remove(date);
        availability.put(date, true);
    }

    
}
