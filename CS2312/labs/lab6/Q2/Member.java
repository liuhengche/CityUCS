public class Member 
{
	//Instance fields
	private String name;
    private Role role;
	
	//Constructor
	public Member(String _name, Role aRole) {
        this.name = _name;
        this.role = aRole;
    }
	
	//Assessor method
    public String getName() {
        return this.name;
    }

    public String getNameAndRole() {
        return this.role.getNameAndRole(this);
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role aRole) {
        this.role = aRole;
    }
}
