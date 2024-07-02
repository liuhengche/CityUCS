import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String [] args) throws FileNotFoundException
    {	
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();
        Scanner inFile = new Scanner(new File(filepathname));
        int total = inFile.nextInt();
        Company company = Company.getInstance();    
        for (int i = 0; i < total; i++) {
            String name = inFile.next();
            int salary = inFile.nextInt();
            int annualLeaves = inFile.nextInt();
            Employee e = new Employee(name, salary, annualLeaves);
            company.addEmployee(e);
        }

        while(inFile.hasNext()) {
            String cmdLine = inFile.nextLine();

            if (cmdLine.equals("")) continue;
            System.out.println("\n> " + cmdLine);
            String [] cmdParts = cmdLine.split(" ");    
            if (cmdParts[0].equals("addSalary")) {
                (new AddSalary()).execute(cmdParts);
            }
            if (cmdParts[0].equals("list")) {
                (new ListAllRecords()).execute(cmdParts);
            }
            if (cmdParts[0].equals("changeAnnualLeaves")) 
                (new ChangeAnnualLeaves()).execute(cmdParts);
            if (cmdParts[0].equals("undo"))
				RecordedCommand.undoOneCommand();
            if (cmdParts[0].equals("exchangeSalaries")) 
                (new ExchangeSalaries()).execute(cmdParts);
            if (cmdParts[0].equals("fire")) 
                (new Fire()).execute(cmdParts);
			if (cmdParts[0].equals("redo"))
				RecordedCommand.redoOneCommand();
            
        }

        inFile.close();
        in.close();
    }
}
