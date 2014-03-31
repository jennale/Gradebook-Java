package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class CourseTest 
{
	Course course1, course2, course3, course4, course5;
	Student stud, stud2;
	Deliverable deliver, deliver2;
	
	@Before
	public void testCourse()
	{
		course1=new Course("Different Title", "Different term", "Different code");
		course2=new Course("Computer Science", "B", "2212");
		course3=new Course("Computer Science", "B", "2209");
		course4=new Course("Philosophy", "A", "2411");
		
		course5=new Course("Computer Science", "B", "2212");
		
		course1.addStudent("Marry", "Poppins", "2509990505", "mpoppin9");
		course4.addStudent("Marry", "Poppins", "2509990505", "mpoppin9");
		stud=new Student("Marry", "Poppins", "2509990505", "mpoppin9");
		
		course1.addStudent("Ricky", "Martin", "0123456789", "rmartin");
		stud2=new Student("Ricky", "Martin", "0123456789", "rmartin");
		
		course1.addDeliverable("Project", "Other", 54);
		deliver=new Deliverable("Project", "Other", 54, 0);
		deliver2=new Deliverable("Test", "Other", 30, 1);
		
		course1.getStudent(0).addGrade(0, 100, "Other", 54);
		course1.getStudent(1).addGrade(0, 68, "Exam", 20);
		course4.addGrade(stud, deliver, 44);
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
		Assert.assertTrue(course1.getStudent(2)==null);
		Assert.assertTrue(course1.getStudent(0).equals(stud));
		Assert.assertTrue(course1.getStudent(1).equals(stud2));
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
		
		Assert.assertTrue(course1.getGrade(course1.getStudent(1), 1)==-1);
		Assert.assertTrue(course1.getGrade(course1.getStudent(1), 0)==68);
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
	
	@Test
	public void testEditStudentNumber()
	{
		Assert.assertTrue(course1.editStudentNumber(stud,"4"));
		
		//Try setting a number already belonging to a student
		Assert.assertFalse(course1.editStudentNumber(stud,"0123456789"));
	}

	@Test
	public void testEditStudentEmail()
	{
		//Try setting an email already belonging to a student
		Assert.assertFalse(course1.editStudentEmail(stud,"rmartin"));
				
		Assert.assertTrue(course1.editStudentNumber(stud,"mpoppin7"));
	}
	
	@Test
	public void testFindStudent()
	{
		Assert.assertTrue(course1.findStudent("0123456789")==1);
		Assert.assertTrue(course1.findStudent("2509990505")==0);
		
		//Find a non existing student
		Assert.assertTrue(course1.findStudent("0909090909")==-1);
	}
	
	@Test
	public void testAddStudent()
	{
		Assert.assertTrue(course1.addStudent("Jimmy", "Falucci", "9876543210", "jfalucci"));
		
		//Add a student with an existing email
		Assert.assertFalse(course1.addStudent("new", "student", "555", "jfalucci"));
		
		//Add a student with an existing number
		Assert.assertFalse(course1.addStudent("new", "student", "0123456789", "email"));
	}
	
	@Test
	public void testRemoveStudent()
	{
		Assert.assertTrue(course1.removeStudent(1));
		
		//Try removing a student from an index that is out of bounds
		Assert.assertFalse(course1.removeStudent(3));
	}
	
	@Test
	public void testFindDeliverable()
	{
		Assert.assertTrue(course1.findDeliverable(deliver)==0);
		
		//Find a non existing deliverable
		Assert.assertTrue(course1.findDeliverable(deliver2)==-1);
	}
	
	@Test
	public void testAddDeliverable()
	{
		Assert.assertTrue(course1.addDeliverable("midterm", "Exam", 25));
		
		//Add existing deliverable
		Assert.assertFalse(course1.addDeliverable("Project", "Other", 54));
	}
	
	@Test
	public void testRemoveDeliverable()
	{
		Assert.assertTrue(course1.removeDeliverable(0));
		
		//Try to remove a deliverable outside index
		Assert.assertFalse(course1.removeDeliverable(1));
	}
	
	@Test
	public void testAddGrade()
	{
		Assert.assertTrue(course1.addGrade(stud, deliver2, 44));
	}
	
	@Test
	public void testRemoveGrade()
	{
		Assert.assertTrue(course4.removeGrade(stud, deliver));
		Assert.assertFalse(course4.removeGrade(stud, deliver2));
	}
	
	@Test
	public void testImportStudents()
	{

	}

	@Test
	public void testExportStudents()
	{

	}

	@Test
	public void testImportDeliverables() 
	{

	}

	@Test
	public void testExportDeliverables()
	{

	}

	@Test
	public void testImportGrades() 
	{

	}

	@Test
	public void testExportGrades()
	{

	}

	@Test
	public void testEqualsCourse()
	{
		Assert.assertTrue(course2.equals(course5));
		Assert.assertFalse(course1.equals(course5));
	}

	@Test
	public void testToString()
	{
		Assert.assertTrue(course4.toString().equals("\"Philosophy\", \"A\", \"2411\"\n"));
		Assert.assertTrue(course1.toString().equals("\"Different Title\", \"Different term\", \"Different code\"\n"));
		Assert.assertTrue(course2.toString().equals("\"Computer Science\", \"B\", \"2212\"\n"));
		Assert.assertTrue(course3.toString().equals("\"Computer Science\", \"B\", \"2209\"\n"));
		
		Assert.assertFalse(course4.toString().equals("\"Geography\", \"A\", \"2411\"\n"));
	}
	
}
