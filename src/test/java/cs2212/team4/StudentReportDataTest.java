package cs2212.team4;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentReportDataTest {
	
	Student stud1, stud2;
	Course course1,course2;
	StudentReportData srd1, srd2;
	
	@Before
	public void createStudentReportData() {
		stud1 = new Student("Ted", "Mosby", "250565432", "tedmosby@uwo.ca");
		//stud2 = new Student ("Barney", "Stinson", "987654321", "barneystin@uwo.ca");
		course1 = new Course ( "Wheels 101", "B", "1567");
		//course2 = new Course ( "Advanced Quantum Physics", "E", "4444");
		course1.addStudent("Ted", "Mosby", "250565432", "tedmosby@uwo.ca");
		course1.addStudent("Barney", "Stinson", "987654321", "barneystin@uwo.ca");
		course1.addDeliverable("Project", "Other", 54);
		course1.getStudent(0).addGrade(0, 97, "Other", 54);
		course1.getStudent(1).addGrade(0, 95, "Other", 54);
		srd1 = new StudentReportData ( stud1, course1, -1);
		srd2 = new StudentReportData (stud1, course1, 1);
		
	}

	@Test
	public void testGetCourseTitle() {
		// if i is not greater than -1, should return title 
		Assert.assertSame( "Wheels 101", srd1.getCourseTitle() );
		// if i is greater than -1, should return null
		Assert.assertSame( null, srd2.getCourseTitle() );
	}

	@Test
	public void testGetCourseTerm() {
	// if i is not greater than -1, should return title 
	Assert.assertSame( "B", srd1.getCourseTerm() );
	// if i is greater than -1, should return null
	Assert.assertSame( null, srd2.getCourseTerm() );
	}

	@Test
	public void testGetCourseCode() {
	// if i is not greater than -1, should return course code
	Assert.assertSame( "1567", srd1.getCourseCode() );
	// if i is greater than -1, should return null
	Assert.assertSame( null, srd2.getCourseCode() );
	
	}

	@Test
	public void testGetClassAvg() {
	// if i is not greater than -1, should return class average
	Assert.assertEquals( 96.0, srd1.getClassAvg() );
	// if i is greater than -1, should return null
	Assert.assertEquals( null, srd2.getClassAvg() );
	}

	@Test
	public void testGetClassAsnAvg() {
	// if i is not greater than -1, should return class assignment average
	
	// if i is greater than -1, should return null
	
	}

	@Test
	public void testGetClassExamAvg() {
	/* Test if it returns null or returns specified ClassExamAvg */
	
	}

	@Test
	public void testGetStudentFirstName() {
		
	}

	@Test
	public void testGetStudentLastName() {
		
	}

	@Test
	public void testGetStudentNumber() {
		
	}

	@Test
	public void testGetStudentEmail() {
		
	}

	@Test
	public void testGetStudentAvg() {
		
	}

	@Test
	public void testGetStudentAsnAvg() {
		
	}

	@Test
	public void testGetStudentExamAvg() {
		
	}

	@Test
	public void testGetGrade() {
		
	}

	@Test
	public void testGetWeight() {
		
	}

	@Test
	public void testGetDeliverAvg() {
		
	}

	@Test
	public void testGetDeliverName() {
		
	}

	@Test
	public void testGetDeliverType() {
		
	}

}
