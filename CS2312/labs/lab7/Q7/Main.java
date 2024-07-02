import java.util.*;
import java.io.*;

public class Main{
	
	//Add the method called findAccount
	private static Account findAccount(ArrayList<Account> acs, String ano)
    {
        for (Account a : acs)
        {
            if (a.getAccountNumber().equals(ano))
                return a;
        }
        return null;
    }
	
	
	
	
	
	public static void main(String [] args) throws FileNotFoundException
	{	
		
        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();

        ArrayList<Account> acs = new ArrayList<>();

        Scanner infile = new Scanner(new File(filepathname));
		
        while(infile.hasNextLine()) {
            String line = infile.nextLine();
            String[] data = line.split(" ");
            if (data.length == 2)  // could also use that (...) <= '5' since the ascii code could be evaluated 
                acs.add(new SavingsAccount(data[0], Double.parseDouble(data[1])));
            else if (data.length == 3 && data[0].charAt(0) != '9')  
                acs.add(new CreditCardAccount(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2])));
            else if (data.length == 3 && data[0].charAt(0) == '9')
                acs.add(new PowerAdvantageAccount(data[0], (SavingsAccount) findAccount(acs,data[1] ), (CreditCardAccount) findAccount(acs,data[2])));
                // explicityly downcasting is needed since the findAccount method returns an Account type
                // having all these different data types is to make our system robust.
        }
		
		
		
		
		
		
		infile.close();
		System.out.print("\nInput an account number to search: ");
		
		String ano = in.next();


		if (findAccount(acs, ano)!=null)
			System.out.println("\n[Result]\n"+findAccount(acs, ano).toString());
		else
			System.out.println("\n[Result]\nThe account is not found.");
			
		in.close();
	}
}