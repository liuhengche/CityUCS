import java.util.ArrayList;

public class Course {
    private String code;
    private ArrayList<Offering> offerings = new ArrayList<Offering>();

    public Course(String string) {
        //TODO Auto-generated constructor stub
        this.code = code;
    }

    public void addOffering(String semID) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'addOffering'");
        this.offerings.add(new Offering(semID));
    }

    public Offering getOffering(String semID) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getOffering'");
        return Offering.getOffering(offerings, semID);
    }
}
