package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		Assert.assertTrue(crs0.equals(gradebook.getCourse(0)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(0)));
		
		Assert.assertTrue(crs1.equals(gradebook.getCourse(1)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(1)));
		
		Assert.assertTrue(crs2.equals(gradebook.getCourse(2)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(2)));
		
		Assert.assertTrue(crs3.equals(gradebook.getCourse(3)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(3)));
		
		Assert.assertTrue(crs4.equals(gradebook.getCourse(4)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(4)));
		
		Assert.assertTrue(crs5.equals(gradebook.getCourse(5)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(5)));
		
		Assert.assertTrue(crs6.equals(gradebook.getCourse(6)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(6)));
		
		Assert.assertTrue(crs7.equals(gradebook.getCourse(7)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(7)));
		
		Assert.assertTrue(crs8.equals(gradebook.getCourse(8)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(8)));
		
		Assert.assertTrue(crs9.equals(gradebook.getCourse(9)));
		Assert.assertFalse(crs.equals(gradebook.getCourse(9)));
		
		Assert.assertTrue(gradebook.getCourse(10)==null);
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
		Assert.assertTrue(gradebook.store());
		Assert.assertTrue(gradebook.store());
	}
	
	@Test
	public void testLoad()
	{
		gradebook.store();
		Gradebook gradebook2=new Gradebook();
		
		Assert.assertTrue(crs0.equals(gradebook2.getCourse(0)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(0)));
		
		Assert.assertTrue(crs1.equals(gradebook2.getCourse(1)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(1)));
		
		Assert.assertTrue(crs2.equals(gradebook2.getCourse(2)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(2)));
		
		Assert.assertTrue(crs3.equals(gradebook2.getCourse(3)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(3)));
		
		Assert.assertTrue(crs4.equals(gradebook2.getCourse(4)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(4)));
		
		Assert.assertTrue(crs5.equals(gradebook2.getCourse(5)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(5)));
		
		Assert.assertTrue(crs6.equals(gradebook2.getCourse(6)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(6)));
		
		Assert.assertTrue(crs7.equals(gradebook2.getCourse(7)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(7)));
		
		Assert.assertTrue(crs8.equals(gradebook2.getCourse(8)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(8)));
		
		Assert.assertTrue(crs9.equals(gradebook2.getCourse(9)));
		Assert.assertFalse(crs.equals(gradebook2.getCourse(9)));
		
		Assert.assertTrue(gradebook2.getCourse(10)==null);
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
		Assert.assertFalse(gradebook.addCourse("Computer Science", "B", "2209"));
		Assert.assertFalse(gradebook.addCourse("Computer Science", "B", "2212"));
		Assert.assertFalse(gradebook.addCourse("Computer Science", "B", "3340"));
		Assert.assertFalse(gradebook.addCourse("Computer Science", "B", "3342"));
		Assert.assertFalse(gradebook.addCourse("Writing", "G", "2207"));
	}

	@Test
	public void testRemoveCourse()
	{
		//Remove existent Course objects to the Gradebook object.
		Assert.assertTrue(gradebook.removeCourse(crs0));
		Assert.assertTrue(gradebook.removeCourse(crs1));
		Assert.assertTrue(gradebook.removeCourse(crs2));
		Assert.assertTrue(gradebook.removeCourse(crs3));
		Assert.assertTrue(gradebook.removeCourse(crs4));
		//Remove none-existent Course objects to the Gradebook object.
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title0", "Term0", "Code0")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title1", "Term1", "Code1")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title2", "Term2", "Code2")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title3", "Term3", "Code3")));
		Assert.assertFalse(gradebook.removeCourse(new Course ("Title4", "Term4", "Code4")));
	}
}
