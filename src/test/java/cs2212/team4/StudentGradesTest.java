package cs2212.team4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*
* StudentGradesTest tests the StudentGrades class methods.
*
* @author Zaid Albirawi
* @version 1.0 3/1/2014
*/

public class StudentGradesTest
{
	StudentGrades grades;
	
	@Before
	public void testStudentGrades()
	{
		grades=new StudentGrades();
		
		grades.add(0, 91, "Other", 0.01);
		grades.add(1, 91, "Assignment", 0.14);
		grades.add(2, 50, "Assignment", 0.15);
		grades.add(3, 90, "Project", 0.40);
		grades.add(4, 80, "Exam", 0.30);
	}

	@Test
	public void testGetAvg()
	{
		assertTrue(grades.getAvg()==(0.01*91+0.14*91+0.15*50+0.40*90+0.30*80));
	}

	@Test
	public void testGetAsnAvg()
	{
		assertTrue(grades.getAsnAvg()==((0.14*91+0.15*50)/(0.14+0.15)));
	}

	@Test
	public void testGetExmAvg()
	{
		assertTrue(grades.getExmAvg()==(0.30*80)/(0.30));
	}

	@Test
	public void testGetGrade()
	{
		assertTrue(grades.getGrade(0)==91);
		assertTrue(grades.getGrade(1)==91);
		assertTrue(grades.getGrade(2)==50);
		assertTrue(grades.getGrade(3)==90);
		assertTrue(grades.getGrade(4)==80);
	}

	@Test
	public void testSetAvg()
	{
		grades.setAvg(100);
		assertFalse(grades.getAvg()==(0.01*91+0.14*91+0.15*50+0.40*90+0.30*80));
		assertTrue(grades.getAvg()==100);
	}

	@Test
	public void testSetAsnAvg()
	{
		grades.setAsnAvg(100);
		assertFalse(grades.getAsnAvg()==((0.14*91+0.15*50)/(0.14+0.15)));
		assertTrue(grades.getAsnAvg()==100);
	}

	@Test
	public void testSetExmAvg()
	{
		grades.setExmAvg(100);
		assertFalse(grades.getExmAvg()==(0.30*80)/(0.30));
		assertTrue(grades.getExmAvg()==100);
	}

	@Test
	public void testAdd()
	{
		grades.add(5, 100, "Assignment", 0.3);
		grades.add(6, 100, "Exam", 0.5);
		assertTrue(grades.getAsnAvg()==((0.14*91+0.15*50+0.3*100)/(0.14+0.15+0.3)));
		assertTrue(grades.getExmAvg()==(0.30*80+100*0.5)/(0.30+0.5));
		assertTrue(grades.getAvg()==(0.01*91+0.14*91+0.15*50+0.40*90+0.30*80+100*0.3+100*0.5)/(0.01+0.14+0.15+0.4+0.3+0.3+0.5));
	}

	@Test
	public void testRemove()
	{
		grades.remove(2, "Assignment");
		assertTrue(grades.getAsnAvg()==((0.14*91)/(0.14)));
		grades.remove(4, "Exam");
		assertTrue(grades.getExmAvg()==-1);
		assertTrue(grades.getAvg()==(0.01*91+0.14*91+0.40*90)/(0.01+0.14+0.4));
		
		assertFalse(grades.remove(2, "Assignment"));
		assertFalse(grades.remove(4, "Exam"));
	}
}
