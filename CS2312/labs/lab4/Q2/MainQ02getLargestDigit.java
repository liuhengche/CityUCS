import java.util.*;

public class MainQ02getLargestDigit
{
	//Return the largest digit in an integer n.
	static int getLargestDigit(int n)
	{
		if (n<10)
		{
			return n;
		}
		else
		{	
			int curr;
			curr = getLargestDigit(n/10);
			if (curr > n%10) {
				return curr;
			}
			else {
				return n%10;
			}

		}
	}

	public static void main(String[] args)
	{
		System.out.print("Input n: ");
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		
		System.out.println(getLargestDigit(n));

		s.close();
	}
}