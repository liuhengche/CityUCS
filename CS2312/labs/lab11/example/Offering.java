import java.util.ArrayList;

public class Offering {
    private String semID;

    public Offering(String semID) {
        //TODO Auto-generated constructor stub
        this.semID = semID;
    }

    public static Offering getOffering (ArrayList<Offering> offerings, String semID) {
        for (Offering o: offerings) {
            if (o.semID.equals(semID)) {
                return o;
            }
        }
        return null;

    }


}
