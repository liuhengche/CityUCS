import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner(System.in); //create a scanner object for keyboard input

		System.out.print("Please enter the filename: ");
		String filepathname = in.next(); //Read user input: in.next();
		
		Day[] days; //create a 1D array of Day objects
		days = Day.createDayListFromFile(filepathname); //Call this method to read data  from the file and store in the array
		
		System.out.println("\nTotally " + days.length + " entries:"); //Show the total: days.length

		for (int i=0; i < days.length; i++) //Loop through i=0,1,2...days.length-1 
			System.out.println((i+1) + ". "
			+days[i].getDay() + "/"
			+days[i].getMonth() + "/"
			+days[i].getYear()); //apply accessor methods: days[i].getYear() etc..
		
		in.close();
	}
}