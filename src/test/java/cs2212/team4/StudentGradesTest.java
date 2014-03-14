package cs2212.team4;

import org.junit.Assert;
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
		Assert.assertTrue(grades.getAvg()==(0.01*91+0.14*91+0.15*50+0.40*90+0.30*80));
	}

	@Test
	public void testGetAsnAvg()
	{
		Assert.assertTrue(grades.getAsnAvg()==((0.14*91+0.15*50)/(0.14+0.15)));
	}

	@Test
	public void testGetExmAvg()
	{
		Assert.assertTrue(grades.getExmAvg()==(0.30*80)/(0.30));
	}

	@Test
	public void testGetGrade()
	{
		Assert.assertTrue(grades.getGrade(0)==91);
		Assert.assertTrue(grades.getGrade(1)==91);
		Assert.assertTrue(grades.getGrade(2)==50);
		Assert.assertTrue(grades.getGrade(3)==90);
		Assert.assertTrue(grades.getGrade(4)==80);
	}

	@Test
	public void testSetAvg()
	{
		grades.setAvg(100);
		Assert.assertFalse(grades.getAvg()==(0.01*91+0.14*91+0.15*50+0.40*90+0.30*80));
		Assert.assertTrue(grades.getAvg()==100);
	}

	@Test
	public void testSetAsnAvg()
	{
		grades.setAsnAvg(100);
		Assert.assertFalse(grades.getAsnAvg()==((0.14*91+0.15*50)/(0.14+0.15)));
		Assert.assertTrue(grades.getAsnAvg()==100);
	}

	@Test
	public void testSetExmAvg()
	{
		grades.setExmAvg(100);
		Assert.assertFalse(grades.getExmAvg()==(0.30*80)/(0.30));
		Assert.assertTrue(grades.getExmAvg()==100);
	}

	@Test
	public void testAdd()
	{
		grades.add(5, 100, "Assignment", 0.3);
		grades.add(6, 100, "Exam", 0.5);
		Assert.assertTrue(grades.getAsnAvg()==((0.14*91+0.15*50+0.3*100)/(0.14+0.15+0.3)));
		Assert.assertTrue(grades.getExmAvg()==(0.30*80+100*0.5)/(0.30+0.5));
		Assert.assertTrue(grades.getAvg()==(0.01*91+0.14*91+0.15*50+0.40*90+0.30*80+100*0.3+100*0.5)/(0.01+0.14+0.15+0.4+0.3+0.3+0.5));
	}

	@Test
	public void testRemove()
	{
		grades.remove(2, "Assignment");
		Assert.assertTrue(grades.getAsnAvg()==((0.14*91)/(0.14)));
		grades.remove(4, "Exam");
		Assert.assertTrue(grades.getExmAvg()==-1);
		Assert.assertTrue(grades.getAvg()==(0.01*91+0.14*91+0.40*90)/(0.01+0.14+0.4));
		
		Assert.assertFalse(grades.remove(2, "Assignment"));
		Assert.assertFalse(grades.remove(4, "Exam"));
	}
}
