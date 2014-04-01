package cs2212.team4;

import junit.framework.Assert;
import java.util.*;
import org.junit.Test;
import org.junit.Before;

public class EmailTest {
	
	
	Course course1, course2;
	Student stud1, stud2;
	Email email1, email2;
	Properties prop1, prop2;
	
	@Before
	public void createProperties (){
		
	}
	
	@Before
	public void testEmail ()
	{
		course1 = new Course( "Satanism 101", "A", "2304");
		stud1 = new Student( "Mel", "Gibson", "250544365", "melgibs22@uwo.ca");
		email1 = new Email( course1, stud1, "Mel Gibson's Grades", "Here are your grades good sir", true);
		
	}
	
	@Test
	public void testgetSession ()
	{
	
	}
	
	@Test
	public void testloadProperties ()
	{
	
	}
	
	@Test
	public void testsendMessage ()
	{
	
	}
	
	@Test
	public void testgenerateReport ()
	{
	
	}
	
	@Test
	public void testsendEmail ()
	{
	
	}
}