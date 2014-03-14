package cs2212.team4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
	Course crs, crs0, crs1, crs2, crs3, crs4, crs5, crs6, crs7, crs8, crs9;
	
	@Before
	public void gradebook()
	{
		//Creates and adds Course objects to the Gradebook object.
		crs=new Course("Title", "Term", "Code");
		gradebook.addCourse("Computer Science", "A", "2208");
		crs0=new Course("Computer Science", "A", "2208");
		gradebook.addCourse("Computer Science", "A", "2210");
		crs1=new Course("Computer Science", "A", "2210");
		gradebook.addCourse("Computer Science", "A", "2211");
		crs2=new Course("Computer Science", "A", "2211");
		gradebook.addCourse("Computer Science", "A", "2214");
		crs3=new Course("Computer Science", "A", "2214");
		gradebook.addCourse("Statistical Sciences", "A", "2244");
		crs4=new Course("Statistical Sciences", "A", "2244");
		gradebook.addCourse("Computer Science", "B", "2209");
		crs5=new Course("Computer Science", "B", "2209");
		gradebook.addCourse("Computer Science", "B", "2212");
		crs6=new Course("Computer Science", "B", "2212");
		gradebook.addCourse("Computer Science", "B", "3340");
		crs7=new Course("Computer Science", "B", "3340");
		gradebook.addCourse("Computer Science", "B", "3342");
		crs8=new Course("Computer Science", "B", "3342");
		gradebook.addCourse("Writing", "G", "2207");
		crs9=new Course("Writing", "G", "2207");
	}

	@Test
	public void testGetCourse()
	{
		assertTrue(crs0.equals(gradebook.getCourse(0)));
		assertFalse(crs.equals(gradebook.getCourse(0)));
		
		assertTrue(crs1.equals(gradebook.getCourse(1)));
		assertFalse(crs.equals(gradebook.getCourse(1)));
		
		assertTrue(crs2.equals(gradebook.getCourse(2)));
		assertFalse(crs.equals(gradebook.getCourse(2)));
		
		assertTrue(crs3.equals(gradebook.getCourse(3)));
		assertFalse(crs.equals(gradebook.getCourse(3)));
		
		assertTrue(crs4.equals(gradebook.getCourse(4)));
		assertFalse(crs.equals(gradebook.getCourse(4)));
		
		assertTrue(crs5.equals(gradebook.getCourse(5)));
		assertFalse(crs.equals(gradebook.getCourse(5)));
		
		assertTrue(crs6.equals(gradebook.getCourse(6)));
		assertFalse(crs.equals(gradebook.getCourse(6)));
		
		assertTrue(crs7.equals(gradebook.getCourse(7)));
		assertFalse(crs.equals(gradebook.getCourse(7)));
		
		assertTrue(crs8.equals(gradebook.getCourse(8)));
		assertFalse(crs.equals(gradebook.getCourse(8)));
		
		assertTrue(crs9.equals(gradebook.getCourse(9)));
		assertFalse(crs.equals(gradebook.getCourse(9)));
		
		assertTrue(gradebook.getCourse(10)==null);
	}

	@Test
	public void testGetPath()
	{
		assertTrue(gradebook.getPath().equals(""));
	}

	@Test
	public void testSetPath()
	{
		gradebook.setPath("New Path");
		assertTrue(gradebook.getPath().equals("New Path"));
	}

	@Test
	public void testStore()
	{
		assertTrue(gradebook.store());
		assertTrue(gradebook.store());
	}
	
	@Test
	public void testLoad()
	{
		gradebook.store();
		Gradebook gradebook2=new Gradebook();
		
		assertTrue(crs0.equals(gradebook2.getCourse(0)));
		assertFalse(crs.equals(gradebook2.getCourse(0)));
		
		assertTrue(crs1.equals(gradebook2.getCourse(1)));
		assertFalse(crs.equals(gradebook2.getCourse(1)));
		
		assertTrue(crs2.equals(gradebook2.getCourse(2)));
		assertFalse(crs.equals(gradebook2.getCourse(2)));
		
		assertTrue(crs3.equals(gradebook2.getCourse(3)));
		assertFalse(crs.equals(gradebook2.getCourse(3)));
		
		assertTrue(crs4.equals(gradebook2.getCourse(4)));
		assertFalse(crs.equals(gradebook2.getCourse(4)));
		
		assertTrue(crs5.equals(gradebook2.getCourse(5)));
		assertFalse(crs.equals(gradebook2.getCourse(5)));
		
		assertTrue(crs6.equals(gradebook2.getCourse(6)));
		assertFalse(crs.equals(gradebook2.getCourse(6)));
		
		assertTrue(crs7.equals(gradebook2.getCourse(7)));
		assertFalse(crs.equals(gradebook2.getCourse(7)));
		
		assertTrue(crs8.equals(gradebook2.getCourse(8)));
		assertFalse(crs.equals(gradebook2.getCourse(8)));
		
		assertTrue(crs9.equals(gradebook2.getCourse(9)));
		assertFalse(crs.equals(gradebook2.getCourse(9)));
		
		assertTrue(gradebook2.getCourse(10)==null);
	}

	@Test
	public void testAddCourse()
	{
		//Add none-existent Course objects to the Gradebook object.
		assertTrue(gradebook.addCourse("Title0", "Term0", "Code0"));
		assertTrue(gradebook.addCourse("Title1", "Term1", "Code1"));
		assertTrue(gradebook.addCourse("Title2", "Term2", "Code2"));
		assertTrue(gradebook.addCourse("Title3", "Term3", "Code3"));
		assertTrue(gradebook.addCourse("Title4", "Term4", "Code4"));
		//Add existent Course objects to the Gradebook object.
		assertFalse(gradebook.addCourse("Computer Science", "B", "2209"));
		assertFalse(gradebook.addCourse("Computer Science", "B", "2212"));
		assertFalse(gradebook.addCourse("Computer Science", "B", "3340"));
		assertFalse(gradebook.addCourse("Computer Science", "B", "3342"));
		assertFalse(gradebook.addCourse("Writing", "G", "2207"));
	}

	@Test
	public void testRemoveCourse()
	{
		//Remove existent Course objects to the Gradebook object.
		assertTrue(gradebook.removeCourse(crs0));
		assertTrue(gradebook.removeCourse(crs1));
		assertTrue(gradebook.removeCourse(crs2));
		assertTrue(gradebook.removeCourse(crs3));
		assertTrue(gradebook.removeCourse(crs4));
		//Remove none-existent Course objects to the Gradebook object.
		assertFalse(gradebook.removeCourse(new Course ("Title0", "Term0", "Code0")));
		assertFalse(gradebook.removeCourse(new Course ("Title1", "Term1", "Code1")));
		assertFalse(gradebook.removeCourse(new Course ("Title2", "Term2", "Code2")));
		assertFalse(gradebook.removeCourse(new Course ("Title3", "Term3", "Code3")));
		assertFalse(gradebook.removeCourse(new Course ("Title4", "Term4", "Code4")));
	}
}
