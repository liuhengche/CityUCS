import java.io.*; //For file I/O
import java.util.*;

public class Table2dMxSumRowCol 
{
	private int[][] nums;
	//(1) Add the instance field, nums, for the 2D array here
	// (Answer is in Given_Code.txt!!)

	
	//Constructor
	public Table2dMxSumRowCol(String filepathname) throws FileNotFoundException //learn exceptions later
	{
		//Part I. Create the 2D array
		nums = new int[10][10];
		// (Answer is in Given_Code.txt!!)
		
		//Part II. Perform file reading and insert values into the 2D array
		Scanner inFile;
		inFile = new Scanner(new File(filepathname)); //(3) construct the scanner object for file reading
		// (Answer is in Given_Code.txt!!)
		//  
		//
		// (4) read the file until the end and add values 
		// (Answer is in Given_Code.txt!!)
		while (inFile.hasNext()) //replace the blank with: inFile.hasNext()
		{
			int row, col, value;
			row = inFile.nextInt();
			col = inFile.nextInt(); // replace the blank with: inFile.nextInt()
			value = inFile.nextInt(); // replace the blank with: inFile.nextInt()
			nums[row][col] = value; //Note: should be [row][col], do not change the order
		}
		inFile.close();
	}
	
	//
	//Other methods 
	//  (See Given_Code.txt!!)
	//
	public void print() {

		/* For each row, we print the columns in that row.

		   Note: row and column are easily mixed up.
			To avoid careless mistake, readability is important.
			Use meaningful variable names like row,col or r,c, or y,x etc. 
			Do not use i,j. 
		*/

		for (int row=0; row<10; row++) 
		{
			for (int col=0; col<10; col++)
			{
				System.out.print("\t"+nums[row][col]); //separated by tabs
			}
			System.out.println();
		}
	}

	public void getRowSumMax(){
		//Your task: implement this method
		int rmx = 0;
		int[] arr = new int[10];
		int count = 0;
		for(int row = 0; row < 10; row++) {
			int temp = 0;
			for(int col = 0; col < 10; col++) {
				temp = temp + this.nums[row][col];
			}
			if(temp > rmx) {
				rmx = temp;
			}
		}

		for(int row = 0; row < 10; row++) {
			int temp = 0;
			for(int col = 0; col < 10; col++) {
				temp = temp + this.nums[row][col];
			}
			if(temp == rmx) {
				arr[count++] = row;
			}
		}


		//return rmx; //This is temporary!!  You may finish this method in next step.
		System.out.println(rmx);
		System.out.print("(row ");
		for(int i = 0; i <= count-1; i++) {
			System.out.print(arr[i]);
			if(i != count-1) {
				System.out.print(',');
			}
		}
		System.out.print(")");
		System.out.println();
	}
	
	public void getColSumMax(){
		//Your task: implement this method
		int cmx = 0;
		int[] arr = new int[10];
		int count = 0;
		for(int col = 0; col < 10; col++) {
			int temp = 0;
			for(int row = 0; row < 10; row++) {
				temp = temp + this.nums[row][col];
			}
			if(temp > cmx) {
				cmx = temp;
			}
		}

		for(int col = 0; col < 10; col++) {
			int temp = 0;
			for(int row = 0; row < 10; row++) {
				temp = temp + this.nums[row][col];
			}
			if(temp == cmx) {
				arr[count++] = col;
			}
		}
		//return cmx; //This is temporary!!  You may finish this method in next step.
		System.out.println(cmx);
		System.out.print("(col ");
		for(int i = 0; i <= count-1; i++) {
			System.out.print(arr[i]);
			if(i != count-1) {
				System.out.print(',');
			}
		}
		System.out.print(")");
		System.out.println();
	}
}

