import java.util.HashMap;

public class Student {
    public String id;  
    public HashMap<Course, offerings> courses = new HashMap<>();
    

    public Student(String id) {
        this.id = id;
    }

    public boolean hasBeenClassmateOf(Student other) {
        if (courses != null && other.courses != null) {
            for (Course c : courses.keySet()) {
                if (other.courses.containsKey(c)) {
                    for (String s : courses.get(c).offerings) {
                        if (other.courses.get(c).offerings.contains(s)) {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    public void takeCourse(Course course, String offering) {
        if (courses.containsKey(course)) {
            courses.get(course).offerings.add(offering);
        } else {
            offerings o = new offerings();
            o.offerings.add(offering);
            courses.put(course, o);
        }
        course.addStudent(this, offering);
    }
        

}
