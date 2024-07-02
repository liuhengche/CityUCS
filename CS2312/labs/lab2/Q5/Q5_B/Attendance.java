import java.io.*;
import java.util.Scanner;

public class Attendance {

	private int[] students;
	private int[] attendees;

	public Attendance() throws FileNotFoundException {
		students = new int[20];
		attendees = new int[20];
		Scanner sStudents = new Scanner(new File("StudentList.txt"));
		Scanner sAttendees = new Scanner(new File("AttendanceLog.txt"));
		for(int i = 0; i < 20; i++) {
            students[i] = sStudents.nextInt();
        }
        for(int i = 0; i < 20; i++) {
            attendees[i] = sAttendees.nextInt();
        }
        





		sStudents.close();
		sAttendees.close();
	}

	public boolean isPresent(int id) {
		if(this.belongToClass(id) == true){
			for(int i: this.attendees) {
				if(i == id) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean belongToClass(int id) {
		for (int i: this.students) {
			if(i == id) {
				return true;
			}
		}
		return false;

	}

	public void listAbsentees() {
        int count = 0;
		System.out.println("List of absentees:");
        for(int s: students) {
            if(!this.isPresent(s)) {
                System.out.println(s);
                count++;
            }
            
        }
        System.out.printf("Total count: %d", count);
        System.out.println();

	}

	public void listWalkIn() {
		System.out.println("List of walk-in students:");
        for (int a: attendees) {
            if(!this.belongToClass(a) && a!= 0) {
                System.out.println(a);
            }
        }
	}

}