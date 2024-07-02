import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookingOffice {
    private ArrayList<Reservation> allReservations;
    private ArrayList<Table> allTables;

    private static BookingOffice instance = new BookingOffice();


    private BookingOffice() {
        allReservations = new ArrayList<Reservation>();
        allTables = new ArrayList<Table>();
        for (int i = 1; i < 10; i++) {
            allTables.add(new Table("T0" + i, 2));
        }
        allTables.add(new Table("T10", 2));
        for (int i = 1; i <= 6; i++) {
            allTables.add(new Table("F0" + i, 4));
        }
        for (int i = 1; i <= 3; i++) {
            allTables.add(new Table("H0" + i, 8));
        }
    }

    private void tableAvailabilityChange(Table t, String date, Boolean isAvailable) {
        //something
        t.setAvailability(date, false);
    } 

    public static BookingOffice getInstance() {
        return instance;
    }

    public void listReservations() {
        Reservation.list(allReservations);
    }

    public Reservation addReservation(String guestName, String phoneNumber, int totPersons, String sDateDine) {
        Reservation r = new Reservation(guestName, phoneNumber, totPersons, sDateDine);
        allReservations.add(r);
        Collections.sort(allReservations);
        return r;
    }

    public void removeReservation(Reservation r) {
        allReservations.remove(r);
    }

    public void addReservation(Reservation r) {
        allReservations.add(r);
        Collections.sort(allReservations);
    }

    public Reservation findReservation(String date, int ticket) {
        for ( Reservation r : allReservations) {
            if (r.getTicketCode() == ticket && r.getDateDine().toString().equals(date)) {
                return r;
            }
        }
        return null;
    }

    public void assignTable(String date, int ticket, ArrayList<Table> tables) {
        //reservation status change, and table availability change
        Reservation r = findReservation(date, ticket);
        r.assignTable(tables);
        for (Table t : tables) {
            tableAvailabilityChange(t, date, false);
            t.assignReservation(date, r);
        }
    }

    public Table findTable(String tableName) {
        for (Table t : allTables) {
            if (t.toString().equals(tableName)) {
                return t;
            }
        }
        return null;
    }

    public void suggestTable(String date, int ticket) {
        //something
        Reservation r = findReservation(date, ticket);
        int totalSeatsNeeded = r.getTotPersons();
        ArrayList<Table> availableTables = new ArrayList<Table>();
        ArrayList<Table> suggestedTables = new ArrayList<Table>();
        for (Table t: allTables) {
            if (t.isAvailable(date)) {
                availableTables.add(t);
            }
        }
        Collections.sort(availableTables, new Comparator<Table>() {
            public int compare(Table t1, Table t2) {
                return t2.getCapacity() - t1.getCapacity(); // Note the order for descending sort
            }
        });

        for (Table t : availableTables) {
            if (t.getCapacity() <= totalSeatsNeeded) {
                suggestedTables.add(t);
                totalSeatsNeeded -= t.getCapacity();
                if (totalSeatsNeeded <= 0) {
                    break; // Found enough seats
                }
            }
        }
         // If more seats are needed, make up with smaller tables
         if (totalSeatsNeeded > 0) {
            for (Table t : availableTables) {
                if (!suggestedTables.contains(t) && t.getCapacity() <= totalSeatsNeeded) {
                    suggestedTables.add(t);
                    totalSeatsNeeded -= t.getCapacity();
                    if (totalSeatsNeeded <= 0) {
                        break; // Found enough seats
                    }
                }
            }
        }
        System.out.printf("Suggestion for %d persons: ", r.getTotPersons());
        for (Table t : suggestedTables) {
            System.out.print(t + " ");
        }
        System.out.println();
    
    }
    
    public void listTableAllocations(String date) {
        int count = 0;
        System.out.println("Allocated tables: ");
        for (Table t : allTables) {
            if (!t.isAvailable(date)) {
                count++;
                t.listTableAllocations(date);
            }
        }
        if (count == 0) {
            System.out.println("[None]");
            System.out.println();
        }
        System.out.println("Available tables: ");
        for (Table t: allTables) {
            if (t.isAvailable(date)) {
                System.out.print(t + " ");
            }
        }
        System.out.println();
        listPending(date);
    }

    public void cancelBooking(String date, int ticket) {
        //something
        Reservation r = findReservation(date, ticket);
        allReservations.remove(r);
        for (Table t: allTables) {
            if (!t.isAvailable(date)) {
                t.cancelBooking(date);
            }
        }
    }

    public void listPending(String date) {
        int totalNumberofPendingRequests = 0;
        int totalNumberofPendingSeats = 0;
        for (Reservation r : allReservations) {
            if (r.getDateDine().toString().equals(date) && r.checkPending()) {
                totalNumberofPendingRequests++;
                totalNumberofPendingSeats += r.getTotPersons();
            }
        }
        System.out.printf("Total number of pending requests = %d (Total number of persons = %d)\n", totalNumberofPendingRequests, totalNumberofPendingSeats);
    }
}

