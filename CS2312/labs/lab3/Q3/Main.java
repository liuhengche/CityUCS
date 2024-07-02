import java.util.*;
import java.io.*;

public class Main{
	
	//Your task:
	//Todo(1) the main() method --- see Main_GivenCode.txt
    public static void main(String [] args) throws FileNotFoundException
	{	
		System.out.print("Please input the file pathname: ");
		Scanner in = new Scanner(System.in);
		String filepathname = in.nextLine();

		Student[] students; //Define an array of students: Student[] students;
		students = Student.createStudentListFromFile(filepathname, in); //Call the given static method in the Student class for reading from file: Student.createStudentListFromFile(filepathname, in);

		Team[] teams; //Define an array of teams: Team [] 
		teams = Main.createTeams(students);//Call the private method (one of the 3 methods in Main.java) to create the teams for students: createTeams(students);

		//Print the grouping result:
		System.out.println("\nGrouping result: ");				
		System.out.println(teams[0].toString());
		System.out.println(teams[1].toString());
		System.out.println(teams[2].toString());
		System.out.println(teams[3].toString());
		System.out.println(teams[4].toString());
		
		//Create the assignments
		Assignment[] assignments; //Define an array of assignments: Assignment[] assignments 
		assignments = Main.decideTasks(teams, in);//Call the private method (one of the 3 methods in Main.java) to input the tasks for each team: decideTasks(teams, in); 
		
		//Display sorted listing by tasks:
		System.out.println("\nSorted listing by tasks: ");
		Assignment.printTaskTeam("Lab05", assignments);
		Assignment.printTaskTeam("Lab06", assignments);
		Assignment.printTaskTeam("Lab07", assignments);
		Assignment.printTaskTeam("Lab08", assignments);
		Assignment.printTaskTeam("Lab09", assignments);
		
		in.close();
	}
	//Todo(2) the createTeams() method --- see Main_GivenCode.txt
    //Create the teams from the students array: students[0..5] go to team A, students[6..11] go to team B, etc..
	private static Team[] createTeams(Student[] students) 
	{
		Team[] result; //Define an array of teams to store the result: Team[] result;
		result = new Team[5]; //Create the array: new Team[5];
		
		//Create the 5 teams
		//Hint: "Arrays.copyOfRange(students, 0,6);" means to copy from position 0 inclusive to position 6 EXCLUSIVE
		result[0]=new Team("Team A", Arrays.copyOfRange(students, 0, 6)); //give team name and array of 6 students: "Team A", Arrays.copyOfRange(students, 0,6)
		result[1]=new Team("Team B", Arrays.copyOfRange(students,6,12)); //Create the second team : new Team("Team B", Arrays.copyOfRange(students, 6,12));
		result[2]=new Team("Team C", Arrays.copyOfRange(students,12,18)); //Create the third team : new Team("Team C", Arrays.copyOfRange(students, 12,18));
		result[3]=new Team("Team D", Arrays.copyOfRange(students,18,24)); //Create the fourth team : new Team("Team D", Arrays.copyOfRange(students, 18,24)
		result[4]=new Team("Team E", Arrays.copyOfRange(students,24,30)); //Create the fifth team : new Team("Team E", Arrays.copyOfRange(students, 24,30)
		return result; //Return the result: return result;
	}
	//Todo(3) the decideTasks() method --- see Main_GivenCode.txt
    //assignment of lab tasks to teams based on user input
	private static Assignment[] decideTasks(Team[] teams, Scanner in)
	{
		Assignment[] assignments; //Define an array of assignments to store the result: Assignment[] assignments;
		assignments = new Assignment[5]; //Create the array: new Assignment[5];

		// String at = in.next();
		// System.out.println(at);
				
		System.out.println("\nEnter tasks for the teams (Lab05,Lab06,Lab07,Lab08,Lab09): ");
		for (int i=0; i<5; i++)
		{
			System.out.print(teams[i].getName()+ ": "); //Prompt for a team: teams[i].getName()
			String taskName = in.next(); //Get user input of the task name from keyboard: in.next();
			assignments[i] = new Assignment(teams[i], new Task(taskName)); //Create the assignment for:  teams[i], new Task(taskName)
		}
		return assignments; //Return the result: return assignments;
	}
}