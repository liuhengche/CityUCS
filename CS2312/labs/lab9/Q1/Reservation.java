import java.util.ArrayList;

public class Reservation implements Comparable<Reservation>{
    private String guestName;
    private String phoneNumber;
    private int totPersons;
    private Day dateDine;
    private Day dateRequest;

    public Reservation(String guestName, String phoneNumber, int totPersons, String sDateDine) {
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.totPersons = totPersons;
        this.dateDine = new Day(sDateDine);
        this.dateRequest = SystemDate.getInstance().clone();

    }


    public static void list(ArrayList<Reservation> reservations) {
        
        //Learn: "-" means left-aligned
        System.out.printf("%-13s%-11s%-14s%-14s%s\n", "Guest Name", "Phone", "Request Date", "Dining Date", "#Persons");
        for (Reservation r: reservations) {
            System.out.printf("%-13s%-11s%-14s%-14s%5d\n", 
            r.guestName, r.phoneNumber, r.dateRequest, r.dateDine, r.totPersons);
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
}

