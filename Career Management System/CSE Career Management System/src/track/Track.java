package track;

import java.util.ArrayList;

import track.requirement.Detail_Graduation;

public class Track 
{	
	public void print_detailed_graduation_requirement(account.Account a, String filename)
	{
		Detail_Graduation d = new Detail_Graduation();
		d.open_detailed_graduation_requirement(filename);
		d.print_detailed_graduation_requirement(filename);
	}
	
	public void print_gradution_requirement(String filename)
	{
		
	}
	
	public void print_curriculum(account.Account a, String filename)
	{
		ArrayList <Subject> array = new ArrayList <Subject>();
		Curriculum c = new Curriculum();
		c.store_user(a);
		c.getRequiredCourses(filename);
		array = c.getCourse();
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i));
		}
	}
}
