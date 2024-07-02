import java.util.ArrayList;
import java.util.Collections;

public class BookingOffice {
    private ArrayList<Reservation> allReservations;


    private static BookingOffice instance = new BookingOffice();


    private BookingOffice() {
        allReservations = new ArrayList<Reservation>();
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
}
