public class Main
{
	public static void main(String[] args) 
	{
		Person person = new Person();
		
		String[] playables = {"Football", "Piano", "Piano", "Football", "Chess"};
		
		for (int i=0;i<playables.length;i++)
		{
			person.getPlay(playables[i]).play();
		}
	}
}