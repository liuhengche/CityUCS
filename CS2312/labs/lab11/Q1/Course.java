import java.util.ArrayList;
import java.util.LinkedHashMap;




public class Course {
    private String courseCode;
    private ArrayList<String> offerings;
    private LinkedHashMap<String, Student> students = new LinkedHashMap<String, Student>();

    public Course(String courseCode) {
        this.courseCode = courseCode;
    }

    public void addOffering(String offering) {
        if (this.offerings == null) {
            this.offerings = new ArrayList<String>();
        }
        this.offerings.add(offering);
    }
    
    public boolean hasOffering(String offering) {
        return this.offerings.contains(offering);
    }
    
    public String getCourseCode() {
        return this.courseCode;
    }

    public void listStudents() {
        for (String o: offerings) {
            System.out.print(o + ": ");
            ArrayList<String> container = new ArrayList<>();
            for (String s: students.keySet()) {
                if (students.get(s).courses.containsKey(this)) {
                    if (students.get(s).courses.get(this).offerings.contains(o)) {
                        container.add(s);
                    }
                }
            }
            
            for (String s: container) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public void addStudent(Student s, String offering) {
        if (students.containsKey(s.id)) {
            if (s.courses.containsKey(this)) {
                s.courses.get(this).offerings.add(offering);
            } else {
                offerings o = new offerings();
                o.offerings.add(offering);
                s.courses.put(this, o);
            }
        } else {
            offerings o = new offerings();
            o.offerings.add(offering);
            s.courses.put(this, o);
            students.put(s.id, s);
        }
    }
}
