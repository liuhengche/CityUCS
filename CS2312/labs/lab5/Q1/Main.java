import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{

		//Start up the system
		Scanner in = new Scanner(System.in); 

		System.out.print("Please enter the filename: ");
		String filepathname = in.next(); 
				
		ArrayList<Employee> allEmployees; //Set up an arraylist variable: ArrayList<Employee>  
		allEmployees = Employee.createEmployeeListFromFile(filepathname); //Call this method to get file data into the array list: Employee.createEmployeeListFromFile(filepathname);
		
		System.out.println("\nTotal count: " + allEmployees.size() + " records."); //Show the total count: allEmployees.size()

		for (int i=0; i < allEmployees.size(); i++) //Loop through the records based on allEmployees.size()
		{
			Employee e;
			e = allEmployees.get(i);//Get an entry from the array list: allEmployees.get(i);			
			System.out.println(e.toStringSalaryDetails()); //Show the record contents as a string: e.toStringSalaryDetails()
		}

		in.close();
	}
}