import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String [] args)
    {	
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File(filepathname));
            int tot = inFile.nextInt();
            Company company = Company.getInstance();
            for (int i = 0; i < tot; i++) {
                company.addEmployee(new Employee(inFile.next(), inFile.nextInt(), inFile.nextInt()));
            }
            while (inFile.hasNext()) {
                String cmdLine = inFile.nextLine();
                if (cmdLine.equals("")) continue;
                System.out.println("\n> " + cmdLine);
                String [] cmdParts = cmdLine.split(" ");
                if (cmdParts[0].equals("addSalary")) {
                    (new AddSalary()).execute(cmdParts);
                }
                else if (cmdParts[0].equals("list"))  {
                    (new ListAllRecords()).execute(cmdParts);
                }
                else if (cmdParts[0].equals("undo"))  {
                    RecordedCommand.undoOneCommand();
                }
                else if (cmdParts[0].equals("redo"))  {
                    RecordedCommand.redoOneCommand();
                }
                else {
                    throw new ExWrongCommand();
                } 
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (InputMismatchException e) {
            System.out.println("File content problem. Program terminated.");
        } catch (ExWrongCommand e) {
            System.out.println("Unknown command - ignored.");
        } finally {
            if (inFile != null) inFile.close();
            in.close();
        }

        
    }
}



// inFile = new Scanner(new File(filepathname));
//         int total = inFile.nextInt();
//         Company company = Company.getInstance();    
//         for (int i = 0; i < total; i++) {
//             String name = inFile.next();
//             int salary = inFile.nextInt();
//             int annualLeaves = inFile.nextInt();
//             Employee e = new Employee(name, salary, annualLeaves);
//             company.addEmployee(e);
//         }

//         
            
//         }