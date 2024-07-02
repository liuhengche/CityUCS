import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{

		Scanner in = new Scanner(System.in);
        System.out.print("Please enter the filename: ");
        String filepathname = in.next();
        
        //PersonnelOffice po = PersonnelOffice.getInstance();
        PersonnelOffice.getInstance().loadEmployeeData(filepathname);

        System.out.println("\nTotal count: " + PersonnelOffice.getInstance().getTotal() + " records.");

        PersonnelOffice.getInstance().report();

        System.out.println("Enter percentage for raising salary: ");

        PersonnelOffice.getInstance().doubleSalary(in.nextDouble());

        PersonnelOffice.getInstance().report();

        in.close();
	}
}