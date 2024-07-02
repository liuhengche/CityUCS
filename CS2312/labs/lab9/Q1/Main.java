public class Main {

	public static void main(String [] args) 
	{	
		SystemDate.createTheInstance("17-Mar-2024");
		
		BookingOffice bo = BookingOffice.getInstance();
		
		//Ms CHAN (Tel: 90123456) totally 4 persons, want to come for buffet on Mar 22.
		bo.addReservation("CHAN, Ms","90123456", 4, "22-Mar-2024"); 
		
		//Mr WONG (Tel: 90555123) totally 6 persons, want to come for buffet on Mar 20.
		bo.addReservation("WONG, Mr","90555123", 6, "20-Mar-2024"); 

		//Advance the system date from 17-Mar to 18-Mar
		SystemDate.getInstance().set("18-Mar-2024"); 
		
		//Mr LEE (Tel: 90888000) totally 10 persons, want to come for buffet on Mar 18.
		bo.addReservation("LEE, Mr","90888000", 10, "18-Mar-2024"); 

		bo.listReservations();
	}
}