import java.util.*;

public class MainQ08containNonDecreasingDigits
{
	
	// Determine whether integer x contains non-decreasing digits (eg. 1234, 14789, 224466)
	//i.e., whether the sequence of digits is "sorted" in ascending order.
	static boolean containNonDecreasingDigits(int x)
	{	
		//todo
        if (x<10)
            return true;
        int temp = x%10;
        int newX = x/10;
        if (temp < newX%10)
            return false;
        return containNonDecreasingDigits(newX);
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			if (containNonDecreasingDigits(x)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}

// boolean nonDD(int x) { // 14789 => True
// 	if (x < 10) {
// 		return true;
// 	}
// 	else {
// 		boolean m1 = nonDD(x/10); // 1478 => True // first just trust that the function would do the job
// 		int r1 = x % 10;
// 		int r2 = (x/10) % 10;
// 		return m1 && r2 < r1; // 1478 is already true based on the trust of the function, we only need to check 8 and 9 which are not checked yet;
// 	}

// } 