public class ExBookingAlreadyExists extends Exception{
    public ExBookingAlreadyExists(){
        super("Booking by the same person for the dining date already exists!");
    }
}
