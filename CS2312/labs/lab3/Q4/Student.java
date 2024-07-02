import java.io.*;
import java.util.Scanner;

public class Student {

	//Instance fields
	private String name; //A reference to the student name: String name;
	private static int count;
	private static int num;
	
	//Constructor
	public Student(String name) //One input parameter: String name
	{
		this.name = name;
	}
	
	//Return the String representation 
	public String toString()
	{
		return this.name;//Return the student name: return name;
	}
	
	//Static method for reading a list of students from the file and return an array of student objects
	public static Student[] createStudentListFromFile(String filepathname, Scanner in) throws FileNotFoundException
	{
		
		
		Scanner inFile = new Scanner(new File(filepathname));

		count=inFile.nextInt(); //read the count
		inFile.nextLine(); //skip line break (otherwise the first .nextLine in the following loop will read an empty line)

		System.out.println("Total number of students: " + count);
		System.out.println("Enter the number of teams: ");

		num = in.nextInt();

		if (count%num != 0) {
			Student[] result = new Student[0];
			inFile.close();
			System.out.println("Wrong input - It is not a factor of " + count + ".");
			return result;
		}

		//Prepare the array of student object references
		Student[] result; //An array of students: Student[] result;
		result = new Student[count]; //Create the students array: new Student[count];		

		for (int i=0;i<count;i++)
		{
			String name = inFile.nextLine(); //Read a line of student name: inFile.nextLine();
			result[i] = new Student(name); //Create a student object for result[i]: new Student(name);
		}
		
		inFile.close();//Close the file: inFile.close();
		return result;//Return the result: return result;
	}

	public static int getTeamNum() {
		return num;
	}

	public static int getNumPerTeam() {
		return count/num;
	}
	
}