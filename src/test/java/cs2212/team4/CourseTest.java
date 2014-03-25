package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseTest 
{
	Course course1, course2, course3, course4;
	Student stud;
	Deliverable deliver;
	
	@Before
	public void testCourse()
	{
		course1=new Course("Different Title", "Different term", "Different code");
		course2=new Course("Computer Science", "B", "2212");
		course3=new Course("Computer Science", "B", "2209");
		course4=new Course("Philosophy", "A", "2411");
		
		course1.addStudent("Marry", "Poppins", "2509990505", "mpoppin9");
		stud=new Student("Marry", "Poppins", "2509990505", "mpoppin9");
		
		course1.addDeliverable("Project", "Other", 54);
		deliver=new Deliverable("Project", "Other", 54, 0);
		
		course1.getStudent(0).addGrade(0, 100, "Other", 54);
	}

	@Test
	public void testGetTitle()
	{
		Assert.assertTrue(course1.getTitle().equals("Different Title"));
		Assert.assertTrue(course2.getTitle().equals("Computer Science"));
		Assert.assertTrue(course3.getTitle().equals("Computer Science"));
		Assert.assertTrue(course4.getTitle().equals("Philosophy"));
		
		Assert.assertFalse(course1.getTitle().equals("Computer Science"));
		Assert.assertFalse(course2.getTitle().equals("other title"));
		Assert.assertFalse(course3.getTitle().equals("wrong title"));
		Assert.assertFalse(course4.getTitle().equals("hue"));
	}

	@Test
	public void testGetTerm()
	{
		Assert.assertTrue(course1.getTerm().equals("Different term"));
		Assert.assertTrue(course2.getTerm().equals("B"));
		Assert.assertTrue(course3.getTerm().equals("B"));
		Assert.assertTrue(course4.getTerm().equals("A"));
		
		Assert.assertFalse(course1.getTerm().equals("C"));
		Assert.assertFalse(course2.getTerm().equals("C"));
		Assert.assertFalse(course3.getTerm().equals("C"));
		Assert.assertFalse(course4.getTerm().equals("other"));
	}

	@Test
	public void testGetCode()
	{
		Assert.assertTrue(course1.getCode().equals("Different code"));
		Assert.assertTrue(course2.getCode().equals("2212"));
		Assert.assertTrue(course3.getCode().equals("2209"));
		Assert.assertTrue(course4.getCode().equals("2411"));
		
		Assert.assertFalse(course1.getCode().equals("2208"));
		Assert.assertFalse(course2.getCode().equals("2210"));
		Assert.assertFalse(course3.getCode().equals("2211"));
		Assert.assertFalse(course4.getCode().equals("2214"));
	}

	@Test
	public void testGetStudent()
	{
		Assert.assertTrue(course1.getStudent(1)==null);
		Assert.assertTrue(course1.getStudent(0).equals(stud));
	}
	
	@Test
	public void testGetDeliverable()
	{
		Assert.assertTrue(course1.getDeliverable(1)==null);
		Assert.assertTrue(course1.getDeliverable(0).equals(deliver));
	}

	@Test
	public void testGetGrade()
	{
		Assert.assertTrue(course1.getGrade(course1.getStudent(0), 1)==-1);
		Assert.assertTrue(course1.getGrade(course1.getStudent(0), 0)==100);
	}
	
	@Test
	public void testSetTitle()
	{
		course1.setTitle("New title");
		Assert.assertTrue(course1.getTitle().equals("New title"));
	}
	
	@Test
	public void testSetTerm()
	{
		course1.setTerm("New term");
		Assert.assertTrue(course1.getTerm().equals("New term"));
	}
	
	@Test
	public void testSetCode()
	{
		course1.setCode("New code");
		Assert.assertTrue(course1.getCode().equals("New code"));
	}
	
}
