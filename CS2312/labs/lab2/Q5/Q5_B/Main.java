import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Attendance at = new Attendance();
		
		at.listAbsentees();
		at.listWalkIn();

	}

}
