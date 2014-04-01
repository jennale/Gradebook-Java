package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class CourseTest
{
	Course crs1, crs2;
	Student stud;
	Deliverable deliver;
	
	@Before
	public void testCourse()
	{
		Color color = new Color(20, 150, 250);
		crs1=new Course("English", "B", "2121");
		crs2=new Course("Computer Science", "A", "2208");
		
		crs1.setDescription("A course in English");
		crs2.setDescription("A course in Computer Science");
		
		crs1.addStudent("Zaid", "Albirawi", "250626000", "zalbiraw");
		stud=new Student("Zaid", "Albirawi", "250626000", "zalbiraw");
		
		crs1.addDeliverable("Project", "Other", 54);
		deliver=new Deliverable("Project", "Other", 54, 0);
		
		crs1.getStudent(0).addGrade(0, 100, "Other", 54);
	}

	@Test
	public void testGetTitle()
	{
		Assert.assertTrue(crs1.getTitle().equals("English"));
		Assert.assertFalse(crs1.getTitle().equals(crs2.getTitle()));
	}

	@Test
	public void testGetTerm()
	{
		Assert.assertTrue(crs1.getTerm().equals("B"));
		Assert.assertFalse(crs1.getTerm().equals(crs2.getTerm()));
	}

	@Test
	public void testGetCode()
	{
		Assert.assertTrue(crs1.getCode().equals("2121"));
		Assert.assertFalse(crs1.getCode().equals(crs2.getCode()));
	}

	@Test
	public void testGetColor()
	{
		Assert.assertTrue(crs1.getColor().equals(new Color(20,150,250)));
		Assert.assertFalse(crs1.getColor().equals(new Color(0,0,0)));
	}

	@Test
	public void testGetDescription() 
	{
		Assert.assertTrue(crs1.getDescription().equals("A course in English"));
		Assert.assertFalse(crs1.getDescription().equals(crs2.getDescription()));
	}

	@Test
	public void testGetStudent()
	{
		Assert.assertTrue(crs1.getStudent(1)==null);
		Assert.assertTrue(crs1.getStudent(-1)==null);
		Assert.assertTrue(crs1.getStudent(0).equals(stud));
	}

	@Test
	public void testGetDeliverable()
	{
		 
	}

	@Test
	public void testGetGrade() 
	{
		 
	}

	@Test
	public void testGetRunningTotal()
	{
		
	}

	@Test
	public void testCalcRunningTotal()
	{
		 
	}

	@Test
	public void testUpdateRunningTotDouble()
	{
		 
	}

	@Test
	public void testUpdateRunningTotDoubleDouble()
	{
		 
	}

	@Test
	public void testGetClassAvg()
	{
		 
	}

	@Test
	public void testGetClassAsnAvg()
	{
		 
	}

	@Test
	public void testGetClassExamAvg()
	{
		 
	}

	@Test
	public void testGetClassDeliverableAvg()
	{
		 
	}

	@Test
	public void testGetDeliverableListSize()
	{
		 
	}

	@Test
	public void testGetStudentListSize()
	{
		 
	}

	@Test
	public void testGetStudents()
	{
		 
	}

	@Test
	public void testGetDeliverables()
	{
		 
	}

	@Test
	public void testSetTitle()
	{
		 
	}

	@Test
	public void testSetTerm()
	{
		 
	}

	@Test
	public void testSetCode()
	{
		 
	}

	@Test
	public void testSetColor()
	{
		 
	}

	@Test
	public void testSetDescription()
	{
		 
	}

	@Test
	public void testEditStudentNumber()
	{
		 
	}

	@Test
	public void testEditStudentEmail()
	{
		 
	}

	@Test
	public void testFindStudent()
	{
		 
	}

	@Test
	public void testAddStudent()
	{
		 
	}

	@Test
	public void testRemoveStudent()
	{
		 
	}

	@Test
	public void testFindDeliverable()
	{
		 
	}

	@Test
	public void testAddDeliverable()
	{
		 
	}

	@Test
	public void testRemoveDeliverable()
	{
		 
	}

	@Test
	public void testAddGrade()
	{
		 
	}

	@Test
	public void testRemoveGrade()
	{
		 
	}

	@Test
	public void testEqualsCourse()
	{
		 
	}

	@Test
	public void testToString()
	{
		 
	}

}
