public class Person 
{
	public Playable getPlay(String toyName) 
	{
		if (toyName.equals("Football"))
			return new Football();
		else if (toyName.equals("Piano"))
			return new Piano();
		else if (toyName.equals("Chess"))
			return new Chess();
		else
			return null;
	}
}