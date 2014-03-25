package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
*
* GradebookTest tests the Gradebook class methods.
*
* @author Zaid Albirawi
* @version 2.0 3/1/2014
*/

public class GradebookTest 
{	
	Gradebook gradebook = new Gradebook();
	Course course1, course2, course3, course4;
	
	@Before
	public void gradebook()
	{
		//Creates and adds Course objects to the Gradebook object.
		course1=new Course("Different Title", "Different Term", "Different Code");
		
		gradebook.addCourse("Computer Science", "B", "2212");
		course2=new Course("Computer Science", "B", "2212");
		
		gradebook.addCourse("Computer Science", "B", "2209");
		course3=new Course("Computer Science", "B", "2209");
		
		gradebook.addCourse("Philosophy", "A", "2411");
		course4=new Course("Philosophy", "A", "2411");
	}

	@Test
	public void testGetCourse()
	{
		Assert.assertTrue(course2.equals(gradebook.getCourse(0)));
		Assert.assertFalse(course1.equals(gradebook.getCourse(0)));
		
		Assert.assertTrue(course3.equals(gradebook.getCourse(1)));
		Assert.assertFalse(course1.equals(gradebook.getCourse(1)));
		
		Assert.assertTrue(course4.equals(gradebook.getCourse(2)));
		Assert.assertFalse(course1.equals(gradebook.getCourse(2)));
		
		Assert.assertTrue(gradebook.getCourse(3)==null);
	}
	
	@Test
	public void testGetPath()
	{
		Assert.assertTrue(gradebook.getPath().equals(""));
	}
	
	@Test
	public void testSetPath()
	{
		gradebook.setPath("New Path");
		Assert.assertTrue(gradebook.getPath().equals("New Path"));
	}
	
	@Test
	public void testStore()
	{
		Assert.assertTrue(gradebook.store()==true);
		Assert.assertTrue(gradebook.store()==true);
	}
	
	@Test
	public void testLoad()
	{
		gradebook.store();
		Gradebook gradebook2=new Gradebook();
		
		Assert.assertTrue(course2.equals(gradebook2.getCourse(0)));
		Assert.assertFalse(course1.equals(gradebook2.getCourse(0)));
		
		Assert.assertTrue(course3.equals(gradebook2.getCourse(1)));
		Assert.assertFalse(course1.equals(gradebook2.getCourse(1)));
		
		Assert.assertTrue(course4.equals(gradebook2.getCourse(2)));
		Assert.assertFalse(course1.equals(gradebook2.getCourse(2)));
		
		Assert.assertTrue(gradebook.getCourse(3)==null);
	}
	
	@Test
	public void testAddCourse()
	{
		//Add none-existent Course objects to the Gradebook object.
		Assert.assertTrue(gradebook.addCourse("Title0", "Term0", "Code0"));
		Assert.assertTrue(gradebook.addCourse("Title1", "Term1", "Code1"));
		Assert.assertTrue(gradebook.addCourse("Title2", "Term2", "Code2"));
		Assert.assertTrue(gradebook.addCourse("Title3", "Term3", "Code3"));
		Assert.assertTrue(gradebook.addCourse("Title4", "Term4", "Code4"));
		//Add existent Course objects to the Gradebook object.
		Assert.assertFalse(gradebook.addCourse("Computer Science", "B", "2212"));
		Assert.assertFalse(gradebook.addCourse("Computer Science", "B", "2209"));
		Assert.assertFalse(gradebook.addCourse("Philosophy", "A", "2411"));
	}
	
	@Test
	public void testRemoveCourse()
	{
		//Remove existent Course objects to the Gradebook object.
		Assert.assertTrue(gradebook.removeCourse(course2));
		Assert.assertTrue(gradebook.removeCourse(course3));
		Assert.assertTrue(gradebook.removeCourse(course4));
		//Remove none-existent Course objects to the Gradebook object.
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title0", "Term0", "Code0")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title1", "Term1", "Code1")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title2", "Term2", "Code2")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title3", "Term3", "Code3")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title4", "Term4", "Code4")));
	}
}
