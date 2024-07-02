import java.io.FileNotFoundException; //We will learn exceptions later
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException //We will learn exceptions later
	{
		System.out.print("Please input the file pathname: ");

		Scanner scannerObj = new Scanner(System.in);
		String filePathName = scannerObj.nextLine();
		
		//Your tasks: 
		//  Create a new Table2dMxSumRowCol object and assign it to a variable of Table2dMxSumRowCol 
		//      Call its constructor with the filePathName as argument 
		//  Then apply the .print(), .getRowSumMax() and 
		//      .getColSumMax() methods to finish the work.
		//

        Table2dMxSumRowCol tb = new Table2dMxSumRowCol(filePathName);

        tb.print();

        int rmx = tb.getRowSumMax();

        int cmx = tb.getColSumMax();
		
		System.out.println("Maximum row sum: ");
		System.out.println(rmx);
		System.out.println("Maximum col sum: ");
        System.out.println(cmx);

		scannerObj.close();
	}
	
}