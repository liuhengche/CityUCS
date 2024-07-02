import java.util.*;

public class MainQ10areOpposite
{
	
	// todo: Add required methods below
    static int tail(int x)
	{	
		//todo
        if (x < 10)
            return 0;
        int remainDigs = tail(x/10);
        return remainDigs * 10 + x %10;
	}

    static int leftMostDigit(int x)
	{	
		//todo		
        int res;
        if (x < 10) {
            return x;
        }
        else {
            res = leftMostDigit(x/10);
        }
        return res;
	}

	//	
	// Determine whether the sequences of digits in 2 integers (without the 0 digit) are opposite to one another (eg. 123 and 321)
	static boolean areOpposite(int x1, int x2)
	{	
		//todo
        if (x1 < 10 && x2 < 10 && x1 == x2) 
            return true;
        if (leftMostDigit(x1) == x2 % 10) {
            return areOpposite(tail(x1), x2/10);
        }
        return false;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x1,x2;
		System.out.print("input 2 integers, separated by a space (\"-1 -1\" to end) : "); 
		x1=s.nextInt();x2=s.nextInt();

		while (x1!=-1)
		{
			if (areOpposite(x1,x2)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input 2 integers, separated by a space (\"-1 -1\" to end) : "); 
			x1=s.nextInt();x2=s.nextInt();
		}

		s.close();
	}
}


// boolean areOpposite(int x1, int x2) { // 1234, 4321 => True
// 	if (x1 < 10 || x2 < 10) {
// 		return x1 == x2;
// 	}
// 	else {
// 		boolean m1 = areOpposite(x1/10, tail(x2)); // 123, 321 => True
// 		return m1 && (x1%10 == leftMostDigit(x2)); // trust that the 123 and 321 will return true; in such case we only need to check the first digit of x1 and the leftMost one of x2
// 	}

// }