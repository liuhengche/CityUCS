import java.util.ArrayList;

public class Student {
    private String id;

    private ArrayList<Offering> studies = new ArrayList<Offering>();
    public Student(String string) {
        //TODO Auto-generated constructor stub
        this.id = id;
    }

    public void takeCourse(Course course, String semID) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'takeCourse'");
        Offering o  = course.getOffering(semID);    
        this.studies.add(o);
    }

    public boolean hasBeenClassmateOf(Student s2) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'hasBeenClassmateOf'");
        for (Offering o1:studies) {
            if (s2.hasTaken(o1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTaken(Offering Oquery) {
        for (Offering o:studies) {
            if (o.equals(Oquery)) {
                return true;
            }

        }
        return false;
    }

}
