import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Reservation implements Comparable<Reservation>{
    private String guestName;
    private String phoneNumber;
    private int totPersons;
    private Day dateDine;
    private Day dateRequest;
    private int ticketCode;
    private RState status;

    public Reservation(String guestName, String phoneNumber, int totPersons, String sDateDine) {
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.totPersons = totPersons;
        this.dateDine = new Day(sDateDine);
        this.dateRequest = SystemDate.getInstance().clone();
        this.ticketCode = BookingTicketController.takeTicket(this.dateDine);
        this.status = new RStatePending();
    }


    public static void list(ArrayList<Reservation> reservations) {
        
        //Learn: "-" means left-aligned
        System.out.printf("%-13s%-11s%-14s%-25s%-11s%s", "Guest Name", "Phone", "Request Date", "Dining Date and Ticket", "#Persons", "Status\n");
        
        Collections.sort(reservations, new Comparator<Reservation>() {
            @Override
            public int compare(Reservation r1, Reservation r2) {
                int nameCompare = r1.guestName.compareTo(r2.guestName);
                if (nameCompare != 0) return nameCompare;

                int phoneCompare = r1.phoneNumber.compareTo(r2.phoneNumber);
                if (phoneCompare != 0) return phoneCompare;

                return r1.dateDine.compareTo(r2.dateDine);
            }
        });
       
        for (Reservation r: reservations) {
            System.out.printf("%-13s%-11s%-14s%-25s%4d       %s\n", 
            r.guestName, r.phoneNumber, r.dateRequest, r.dateDine+String.format(" (Ticket %d)", r.ticketCode), r.totPersons, r.status);
        }
    }

    @Override
    public int compareTo(Reservation another) {
        //return dateDine.toString().compareTo(r.dateDine.toString());
        if (this.guestName.equals(another.guestName)) {
            return 0;
        }
        else if (this.guestName.compareTo(another.guestName) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    
    
    }

    public int getTicketCode() {
        return ticketCode;
    }

    public Day getDateDine() {
        return dateDine;
    }

    public int getTotPersons() {
        return totPersons;
    }

    public void assignTable(ArrayList<Table> tables) {
        status = new RStateTableAllocated(tables);
    }

    public boolean checkPending() {
        return status instanceof RStatePending;
    }

    public boolean checkPho(String pho) {
        return phoneNumber.equals(pho);
    }

    public void undoAssignTable() {
        status = new RStatePending();
    }

    public boolean checkEqual(String[] cmdParts) {
        if (this.guestName.equals(cmdParts[1]) && this.phoneNumber.equals(cmdParts[2]) && this.totPersons == Integer.parseInt(cmdParts[3]) && this.dateDine.toString().equals(cmdParts[4])){
            return true;
        }
        return false;
    }

    public void changeRequestDate() {
        dateRequest = SystemDate.getInstance().clone();
    }
}

