import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
{
	//Read input file pathname
	Scanner in = new Scanner(System.in); 
	System.out.print("Please enter the filename: ");
	String filepathname = in.next();

	//Grab the StatisticsSystem ss and add counters 
	StatisticsSystem ss = StatisticsSystem.getInstance();  
	
	ss.addCounter(new Counter());

	// /*Now removed*/ ss.addCounter(new AreaCounter("YuenLong")); 
	// /*Now removed*/ ss.addCounter(new AreaCounter("KwunTong")); 

	in.nextLine(); // There is now a '\n' in the input stream, skip it: in.nextLine(); 
	System.out.print("\nEnter the area names (e.g. TaiPo YuenLong WongTaiSin KwunTong): ");
	String line = in.nextLine(); //Read a line: in.nextLine(); 
	Scanner scannerLine = new Scanner(line); //Create the scanner for input from the string: new Scanner(line);
	while (scannerLine.hasNext()) //Still have contents or not: hasNext()
		ss.addCounter(new AreaCounter(scannerLine.next())); //Area name is grabbed from the string: scannerLine.next()
	scannerLine.close(); //Close the scanner: close();

	int a1, a2;

    do {
        System.out.print("\nEnter the age groups ('-1 -1' to end): ");
        a1 = in.nextInt();
        a2 = in.nextInt();
        if (a1 != -1 && a2 != -1) {
            ss.addCounter(new AgeGroupCounter(a1, a2));
        }
        
    } while(a1 != -1 && a2 != -1);

	//The ss will load file data and tell its counters to count 
	ss.countData(filepathname);		
	
	//The ss will tell its counters to report
	ss.report();
	
	in.close();
}
}