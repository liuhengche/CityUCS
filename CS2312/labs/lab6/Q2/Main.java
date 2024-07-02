import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException
	{	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname of each team: ");

		// something i don't get;
		String filepathnames = in.nextLine();
		Scanner infnames = new Scanner(filepathnames);
		ArrayList<Team> teams = new ArrayList<Team>();
		while(infnames.hasNext() ){
			teams.add(new Team(infnames.next()));
		}
		 

		// ArrayList<Team> teams = new ArrayList<Team>();
		// String Filenames;
		// Filenames = in.nextLine();
		// String Filename[] = Filenames.split(" ");
		// for (int i = 0; i < Filename.length; i++) {
		// 	teams.add(new Team(Filename[i]));
		// } // how to solve this problem? why can't i use in.hasNext()? why does it stops running???
		

		System.out.println("Listing of teams: ");
		for (int i = 0; i < teams.size(); i++) {
			System.out.printf("[Team %d] %d members: %s\n", i+1, teams.get(i).getMemberCount(), teams.get(i).getStringOfAllMembers());
		}
		System.out.println("Enter a name for searching:");
		String name = in.next();
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).isMember(name)) {
				System.out.printf("Result: %s is %s in Team %d\n", name, teams.get(i).getRole(name), i+1);
				break;
			}
			else if (i == teams.size()-1) {
				System.out.println("Result: Not found");
			}
			
		}






		// String filepathname = in.nextLine();
		
		// Team t = new Team(filepathname); //create the team: new ______________________;
		
		// System.out.printf(
		// 	"\nThere are %d members in the team: %s\n\n", 
		// 	t.getMemberCount(), t.getStringOfAllMembers()); //call Team methods to get the results: getMemberCount, getStringOfAllMembers
		
		// System.out.println("Enter new leader: ");
		// String newLeader = in.nextLine();
		// t.changeLeader(newLeader); //call setLeader(newLeader);
		// System.out.printf("Result: %s\n\n", t.getStringOfAllMembers());
		in.close();
		infnames.close(); // why do we need two scanners? why can't we use the same scanner?
	}
}