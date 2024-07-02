import java.util.*;

public class MainQ11reverse
{
	
	// todo: Add required methods below
	//	

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
	
	// Return an integer that is the reversed version of the input integer x (without the 0 digit). eg. 1234=>4321 
	static int reverse(int x)
	{	
		//todo
        if ( x < 10 ){
            return x;
        }
        
        int lmost = leftMostDigit(x);
        int curr = reverse(tail(x));

        return lmost + 10 * curr;

	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(reverse(x));
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}

// int reverse(x) { // 2368 => 8632
// 	if (x < 10) {
// 		reuturn x;
// 	}
// 	else {
// 		// int m1 = reverse(x/10); // 236 => 632 not wanted
// 		int m1 = reverse(tail(x)); // 368 => 863
// 		return m1*10 + leftMostDigit(x); // just adding the missing digit would be sufficient
// 	} 

// }