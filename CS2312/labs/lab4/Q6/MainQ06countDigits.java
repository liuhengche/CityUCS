import java.util.*;

public class MainQ06countDigits
{
	// Return the number of digits in integer x. 	
	static int countDigits(int x)
	{	
		//todo		
        if (x < 10) {
            return 1;
        }
        else {
            return countDigits(x/10) + 1;
        }
        
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(countDigits(x));
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}


// int countDigit(int x) { // 12348 => 5
// 	if (x < 10) {
// 		return 1;
// 	}
// 	else {
// 		int m1 = countDigit(x/10);  // now 1234 => 4
// 		return m1 + 1;
// 	}

// }