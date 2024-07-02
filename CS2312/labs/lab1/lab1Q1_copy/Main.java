import java.util.*;

public class Main
{
   public static void main(String[] args)
   {
	   
	   System.out.print("Please enter the date (eg. \"2013 12 31\"): ");
	   
	   Scanner scannerObj = new Scanner(System.in);
	   int y, m, d;
	   y=scannerObj.nextInt();
	   m=scannerObj.nextInt();
	   d=scannerObj.nextInt();
	   
	   if (Day.valid(y, m, d)==false) //check whether the input is valid
	   {
		   System.out.println("Wrong input.  Program stopped.");
	   }
	   else
	   {
		   Day dayObj = new Day(y,m,d); //create a Day object for the input
		   
		   System.out.println("\nYou have entered " + dayObj.toString());
		   
		   if (Day.isLeapYear(y))
			   System.out.println("It is a Leap Year.");
		   else
			   System.out.println("It is NOT a Leap Year.");
	   }
	   scannerObj.close();
   }
}