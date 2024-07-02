import java.util.*;
import java.io.*;

public class Team{
	
	//Instance data field
	private Member[] allMembers;
	
	//Constructor	
	public Team(String filepathname) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File(filepathname));
		
		int tot = inFile.nextInt(); //Read from file: nextInt();
		inFile.nextLine(); //skip line break after the count: inFile.nextLine(); 
        // if we don't put nextLine, the next() will still work, but when we want to use nextLine(), it might be wrong. lab3 is a must to use nextLine, but here it's not necessary
		
                allMembers = new Member[tot]; //Create the array: new Member[tot];

                for (int i = 0; i < tot; i++) //loop how many times?
                {
                    String name = inFile.next(); //Read from file: .next();
                    char roleType = inFile.next().charAt(0);
                    Role r;
                    if (roleType == 'l') {r = new RLeader();}
                    else if (roleType == 'd') {r = new RDisappeared();}
                    else {r = new RNormalMember();}

                    allMembers[i] = new Member(name,r); // Create a member object: new ____________;
                }
                        
                inFile.close();; //close the file
	}
	
	//Return total count of members (simply allMembers.length)
	public int getMemberCount()
	{
        return allMembers.length;
	}
	
	//Return a string of listing of all members
	public String getStringOfAllMembers()
	{
		String result="";
		for (int i = 0; i < allMembers.length; i++) //loop for each member
				result+= allMembers[i].getNameAndRole() + " ";// allMembers[i].getName()+" ";
		result=result.trim(); //.trim() is for removing leading and trailing spaces 
		return result;
	}

	//Display team contact messages
	public void printTeamContactMessages()
	{
		//String allNames=getStringOfAllMembers(); //obtains a string like: "Helena Peter Mary Paul"
		for (int i = 0; i < allMembers.length; i++) //loop for each member
		{
			String name_i=allMembers[i].getName(); //e.g. "Helena"
			System.out.print("Dear " + name_i+", ");
            String msg = allMembers[i].getRole().genTeamContactMsg(this); //call getRole().genTeamContactMsg(this);
			//String teammates = allNames.replace(name_i, ""); //e.g. "Peter Mary Paul". Use a trick: create a string based on allNames, but remove name_i: allNames.replace(name_i, "");
			System.out.println(msg); //teammates
		}
	}	

    public Member getLeader()
    {
        for (int i = 0; i < allMembers.length; i++) //loop for each member
        {
            if (allMembers[i].getRole() instanceof RLeader) //if it is a leader
                return allMembers[i]; //return the leader
        }
        return null; //no leader
    }

    public String getStringofNormalMembers () {
        String result = "";
        for (int i = 0; i < allMembers.length; i++) //loop for each member
        {
            if (allMembers[i].getRole() instanceof RNormalMember) //if it is a normal member
                result += allMembers[i].getName() + " "; //add the name to the result
        }
        return result.trim(); //return the result
    }

	public Member findMember(String newLeaderName) {
		for (int i = 0; i < allMembers.length; i++) //loop for each member
		{
			if (allMembers[i].getName().equals(newLeaderName)) //if the name is the same as newLeaderName
				return allMembers[i]; //return the member
		}
		return null; //no member
	}

	public void changeLeader(String newLeaderName) {
		Member newLeader = findMember(newLeaderName); //call findMember(newLeaderName);
		Member oldLeader = getLeader(); //call getLeader();
		oldLeader.setRole(new RNormalMember()); //call setRole(new RNormalMember());
		newLeader.setRole(new RLeader()); //call setRole(new RLeader());
	}

	public boolean isMember(String name) {
		for (int i = 0; i < allMembers.length; i++) //loop for each member
		{
			if (allMembers[i].getName().equals(name)) //if the name is the same as name
				return true; //return true
		}
		return false; //no member
	}

	public String getRole(String name) {
		for (int i = 0; i < allMembers.length; i++) //loop for each member
		{
			if (allMembers[i].getName().equals(name)) //if the name is the same as name
				return allMembers[i].getRole().getRoleName(); //return the role name
		}
		return null; //no member
	}
}
