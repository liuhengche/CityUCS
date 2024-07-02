import java.util.*;

public class MainQ05containDigit
{
	// determine whether a given digit exists in an integer x.  	
	static boolean containDigit(int x, int d)
	{	
		//todo
        if ( x < 10) {
            if (x == d) {
                return true;
            } else {
                return false;
            }
        }	
        else {
            boolean result = containDigit(x/10, d);
            if (x%10 == d) {
                return true;
            } else {
                return result;

            }
        }
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x,d;
		System.out.print("input x and d, separated by a space (\"-1 -1\" to end) : "); 
		x=s.nextInt();d=s.nextInt();

		while (x!=-1)
		{
			if (containDigit(x,d)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input x and d, separated by a space (\"-1 -1\" to end) : "); 
			x=s.nextInt();d=s.nextInt();
		}

		s.close();
	}
}


// static boolean containDigit(int x, int d) { // 2312, 8 => False
// 	if (x < 10)
// 		return x == d;
// 	else {
// 		boolean m1 = containDigit(x/10, d); // 231, 8 => False
// 		//return ____ || ___; 
// 		// just trust mr. robot to do the job; trust that he would do the rest of the digits of 2312, you just need to check the last digit is d or not
// 		return m1 || (x%10) == d;
// 	} 

// }