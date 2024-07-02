import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class PersonnelOffice
{

	// instance fields
	private ArrayList<Employee> allEmployees; //Encapsulated array list of employee/manager objects: private ArrayList<Employee> allEmployees;
	
	
	private static PersonnelOffice thePO = new PersonnelOffice();//Singleton
	// singleton ensures that only one universal object by a static field in the class is created;
	// static because singleton does not belong to a every object created, but the class itself;
	// private because we don't want outsiders modify it;
	// the original constructor could be deleted now or set to private; so that in main you could not create a new PersonnelOffice object;


	// Methods
	public static PersonnelOffice getInstance() {return thePO;};
	// return the singleton object;

	//Return the total count of employees
	public int getTotal() 
	{
		return allEmployees.size(); //Total count of employees/managers: allEmployees.size();
	}
	
	//Display a report of all salaries
	public void report()
	{
		double totalM = 0;
		for (int i=0; i < allEmployees.size(); i++) { 
			System.out.println(allEmployees.get(i).toStringSalaryDetails()); //Call the toStringSalaryDetails methods of employees/managers: allEmployees.get(i).toStringSalaryDetails()
			totalM += allEmployees.get(i).getSalary(); // why can the getSalaray() output the bonus as well? // Known as the dynamic binding!
		}//Iterate through the array list based on allEmployees.size() 
			
		System.out.println("==============================");
		System.out.printf("Total salary expense: %.2f\n", totalM);
	}
	
	//Constructor
	public PersonnelOffice()
	{
		allEmployees = new ArrayList<Employee> ();//Create the array list of employees/managers: new ArrayList<Employee>();
	}

	//Read employee data from the given file, store in the allEmployees array
	public void loadEmployeeData(String filepathname) throws FileNotFoundException 
	{
		allEmployees.clear(); //remove any existing employees: allEmployees.clear();

		Scanner inFile = new Scanner(new File(filepathname));

		while (inFile.hasNext())
		{
			String id=inFile.next(); //Read the ID: inFile.next();
			
			if (id.charAt(0)=='9') //should be manager
			{
				String name=inFile.next(); //Read a name: inFile.next();
				double salary = inFile.nextDouble();
				double bonus = inFile.nextDouble();
				Manager m;  
				m = new Manager(id, name, salary, bonus); //pass to the constructor: id, name, salary, bonus
				allEmployees.add(m); //Add the manager object: m
			}
			else
			{
				String name=inFile.next();
				double salary = inFile.nextDouble();
				Employee e; 
				e = new Employee(id, name, salary);
				allEmployees.add(e);
			}
		}

		inFile.close();
	}

	public void doubleSalary(double percent) {
		for (int i=0; i < allEmployees.size(); i++) {
			allEmployees.get(i).raiseSalary(percent);
		}
	}
}
