import java.util.*;

public class MainQ07leftMostDigit
{
	// Return the left-most digit in integer x 	
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


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(leftMostDigit(x));
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}

// int leftMostDigit(int x) { // 8769 => 8
// 	if (x < 10) {
// 		return x;
// 	}
// 	else {
// 		int m1 = leftMostDigit(x/10); // 876 => 8
// 		return m1; // use examples to write recurrsion functions instead of going into the functions
// 	}
// }