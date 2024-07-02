import java.io.*;
import java.util.Scanner;

public class Day {
	
	private int year;
	private int month;
	private int day;

    public int getYear()  {return this.year;}
    public int getMonth() {return this.month;}
    public int getDay()   {return this.day;}
	
	//Constructor
	public Day(int y, int m, int d) {
		this.year=y;
		this.month=m;
		this.day=d;		
	}
	
	// check if a given year is a leap year
	static public boolean isLeapYear(int y)
	{
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}
	
	// check if y,m,d valid
	static public boolean valid(int y, int m, int d)
	{
		if (m<1 || m>12 || d<1) return false;
		switch(m){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					 return d<=31; 
			case 4: case 6: case 9: case 11:
					 return d<=30; 
			case 2:
					 if (isLeapYear(y))
						 return d<=29; 
					 else
						 return d<=28; 
		}
		return false;
	}

	// Return a string for the day like dd MMM yyyy
	public String toString() {
		
		final String[] MonthNames = {
				"Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec"};
		
		return day+" "+ MonthNames[month-1] + " "+ year;
	}

    public static Day[] createDayListFromFile(String filepathname) throws FileNotFoundException { //throws filenotfoundexception is needed, declare that there could be the situation that the file could not be found
		//throws FileNotFoundException
        //Create a scanner object for reading file
        Scanner inFile = new Scanner(new File(filepathname)); //replace the blank with: new File(filepathname)

        int count=inFile.nextInt(); //Read the count of entries: inFile.nextInt()

        Day[] result; // set up an array of Day objects for returning the result
        result = new Day[count]; //Create an array of Day object references: new Day[count]
		// will not run the default constructor, there are no objects in it yet, so the values are all null
		// we need to create the day objects in the Day[count] ourselves
            
        for (int i = 0; i < count; i++) //Loop a number of times based on the count
        {
            int y, m, d;
            d=inFile.nextInt();//Read one integer from the file: inFile.nextInt()
            m=inFile.nextInt();
            y=inFile.nextInt();

            result[i] = new Day(y,m,d);//Create a new day object: new Day(y,m,d)
        }
            
        inFile.close();//Close the file: inFile.close();
        return result;//Return the data as an array of Day objects: return result;
    }

    public boolean valid() {
        return Day.valid(this.year, this.month, this.day); // valid is a static method, so that we need Day.valid();
		// no naming conflict, so we do not need to use this.;
    }
}