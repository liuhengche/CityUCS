import java.util.*;

public class MainQ09tail
{
	
	// Given an input integer x, return y which contains all digits in x except the left-most one.
	//  e.g., 123=>23, 1234=>234. Assume x>10.
	static int tail(int x)
	{	
		//todo
        if (x < 10)
            return 0;
        int remainDigs = tail(x/10);
        return remainDigs * 10 + x %10;
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(tail(x));
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}

// no need to figure out the process before we write the function

// boolean int tail(int x) { // 1234 => 234
// 	if ( x < 10) {
// 		return x%10;
// 	}
// 	else { 
// 		int m1 = tail(x/10); // 123 => 23 we would get 23 if the function works, then we assume the function works and then we figure out how to get the real result based on the current result we have from the recurrsive function
// 		return m1*10 + (x%10);
// 	}
// }