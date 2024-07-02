import java.util.List;

public class DropController {
	
	private List<Course> courseList;

	public DropController(List<Course> list) {
		courseList = list;
	}

	public void printCourses() {
		System.out.print("Course List: ");
		for(Course c : courseList) {
			System.out.printf("[%s] ",c);
		}
		System.out.println();
	}
	
	public void process(Course c) throws ExPrerequisiteForAnother, ExCourseNotFound{
		/* PLACE YOUR CODE HERE */
        if (!courseList.contains(c)) {
            throw new ExCourseNotFound("Cannot drop " + c + " (Course doesn't exist in the list)");
        }
        for (Course p : courseList) {
            if (p.getPreRequisites().contains(c)) {
                throw new ExPrerequisiteForAnother("Cannot drop " + c + " (Required for " + p + ")");
            }
        }
        courseList.remove(c);
	}


}