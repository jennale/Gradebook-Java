package cs2212.team4;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class StudentGradesTest {
	
	StudentGrades stug1, stug2;
	ArrayList<Grade> gradesList;
	Grade grade1, grade2, grade3;
	
	@Before
	public void testStudentGrades() {
		stug1 = new StudentGrades();
		stug1.add( 0, 85, "assignment", 20);
		stug1.add( 1, 76, "assignment", 20);
		stug1.add( 3, 55, "exam", 30);
		
		stug2 = new StudentGrades();
		stug2.add(0, 55, "assignment", 10);
		stug2.add(1, 68, "assignment", 10);
		stug2.add(2, 70, "assignment", 20);

		//gradeList = new ArrayList<Grade>();
		//gradesList.set( 0, stug1.getGrade( 0 ) );
		//gradesList.set( 1, stug1.getGrade( 1 ) );
		//gradesList.set( 3, stug1.getGrade( 3 ) ); 
		
	}

	@Test
	public void testGetAvg() {
		Assert.assertEquals( 69.57142857142857, stug1.getAvg() );
	}

	@Test
	public void testGetAsnAvg() {
		Assert.assertEquals( 80.5, stug1.getAsnAvg() );
	}

	@Test
	public void testGetExmAvg() {
		Assert.assertEquals ( 55.0, stug1.getExmAvg() );
	}

	@Test
	public void testGetGrade() {
	// if grade is greater or equal to grades size, return -1
		Assert.assertEquals ( -1.0, stug1.getGrade(4) );
	// if grade is null, return -1
		Assert.assertEquals ( -1.0, stug1.getGrade(2) );
	// otherwise get grade
		Assert.assertEquals ( 85.0, stug1.getGrade(0) );
		Assert.assertEquals ( 76.0, stug1.getGrade(1) );
		Assert.assertEquals ( 55.0, stug1.getGrade(3) );
	}

	@Test
	public void testGetGradeList() {
		// should return grade list
		//Assert.assertArrayEquals ( gradesList, stug1.getGradeList() );
	}

	@Test
	public void testSetAvg() {
		stug1.setAvg(88);
		Assert.assertEquals ( 88.0, stug1.getAvg() );
	}

	@Test
	public void testSetAsnAvg() {
		stug1.setAsnAvg(78);
		Assert.assertEquals ( 78.0, stug1.getAsnAvg() );
	}

	@Test
	public void testSetExmAvg() {
		stug1.setExmAvg(64);
		Assert.assertEquals (64.0, stug1.getExmAvg() );
	}

	@Test
	public void testAdd() {
		// add a student grade where the deliverable number is greater than the size of grades array
		stug2.add( 5, 80, "exam", 25);
		Assert.assertEquals( 6, stug2.getGradeList().size() );
		// add a student grade where type is "exam"
		
		// add a student grade where type is "assignment"
		
		// add a student grade where type is neither
		

	}

	@Test
	public void testRemove() {
		
	}

}
