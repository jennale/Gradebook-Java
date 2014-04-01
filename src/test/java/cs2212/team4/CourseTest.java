package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class CourseTest
{
	Course crs1, crs2, crs3;
	Student stud, stud2;
	Deliverable deliver, deliver2;
	
	@Before
	public void testCourse()
	{
		Color color = new Color(20, 150, 250);
		stud=new Student("Marry", "Poppins", "250555000", "mpoppins");
		deliver=new Deliverable("Project", "Other", 54, 0);
		stud2=new Student("John", "Johnson", "250222444", "jjohn22");
		deliver2=new Deliverable("Midterm", "Exm", 25, 0);
		
		//A course with students, grades, description, deliverable
		crs1=new Course("English", "B", "2121");
		crs1.setDescription("A course in English");
		crs1.addStudent("Marry", "Poppins", "250555000", "mpoppins");
		crs1.addStudent("John", "Johnson", "250222444", "jjohn22");
		crs1.addDeliverable("Project", "Other", 54);
		crs1.getStudent(0).addGrade(0, 97, "Other", 54);
		crs1.getStudent(1).addGrade(0, 95, "Other", 54);
		
		//A course with only a description
		crs2=new Course("Computer Science", "A", "2208");
		crs2.setDescription("A course in Computer Science");
		
		//A course with a student with no assigned grade, description, deliverable
		crs3=new Course("Philosophy", "B", "1022");
		crs3.setDescription("A course in Philosophy");
		crs3.addStudent("John", "Johnson", "250222444", "jjohn22");
		crs3.addDeliverable("Midterm", "Exm", 25);
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
		Assert.assertTrue(crs1.getStudent(2)==null);
		Assert.assertTrue(crs1.getStudent(-1)==null);
		Assert.assertTrue(crs1.getStudent(0).equals(stud));
		Assert.assertFalse(crs1.getStudent(0).equals(crs3.getStudent(0)));
	}

	@Test
	public void testGetDeliverable()
	{
		Assert.assertTrue(crs1.getDeliverable(1)==null);
		Assert.assertTrue(crs1.getDeliverable(-1)==null);
		Assert.assertTrue(crs1.getDeliverable(0).equals(deliver));
		Assert.assertFalse(crs1.getDeliverable(0).equals(crs3.getDeliverable(0)));
	}

	@Test
	public void testGetGrade() 
	{
		Assert.assertTrue(crs1.getGrade(stud,1)==-1);
		Assert.assertTrue(crs1.getGrade(stud,-1)==-1);
		Assert.assertTrue(crs1.getGrade(crs1.getStudent(0),0)==97);
	}

	@Test
	public void testGetClassAvg()
	{
		//Average for a course with deliverables, students, and grades
		Assert.assertTrue(crs1.getClassAvg()==96);
		//Average for a course with no students or deliverables
		Assert.assertTrue(crs2.getClassAvg()==-1);
		//Average for a course with deliverables and students, but no grades
		Assert.assertTrue(crs3.getClassAvg()==0);
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
