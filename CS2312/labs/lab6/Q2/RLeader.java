public class RLeader implements Role//It should be: public class RLeader implements Role 
{
	//Generate team contact message for the member
	public String genTeamContactMsg(Team team)
	{
		String teammates = team.getStringofNormalMembers();//Call team.getStringOfNormalMembers();
		return "Please contact your members: "+teammates; 
	}
	
	//Return name[+role] strings
	public String getNameAndRole(Member member)
	{
		return member.getName() + "[Leader]"; // member.getName()+"[Leader]";
	}	

	public String getRoleName() {
		return "the leader";
	}
}
