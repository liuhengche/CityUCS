import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private List<Course> preRequisites;

	public Course(String cName) {
		name = cName;
		preRequisites = new ArrayList<Course>();
	}

	@Override
	public String toString() {return name;}

	public void addPreReq(Course p) {
		if (!preRequisites.contains(p))
			preRequisites.add(p);
	}

	public List<Course> getPreRequisites() {
		return this.preRequisites;
	}
}