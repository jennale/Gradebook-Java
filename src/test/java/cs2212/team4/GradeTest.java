package cs2212.team4;

import org.junit.Assert;
import org.junit.Test;

public class GradeTest
{
	Grade grade1 = new Grade(50.0, 10.0);
	Grade grade2 = new Grade(60.0, 15.0);
	Grade grade3 = new Grade(70.0, 20.0);
	Grade grade4 = new Grade(80.0, 25.0);
	Grade grade5 = new Grade(90.0, 30.0);

	
	@Test
	public void testGetGrade()
	{
		Assert.assertNotEquals(0.0, grade1.getGrade());
		Assert.assertNotEquals(0.0, grade2.getGrade());
		Assert.assertNotEquals(0.0, grade3.getGrade());
		Assert.assertNotEquals(0.0, grade4.getGrade());
		Assert.assertNotEquals(0.0, grade5.getGrade());

		Assert.assertEquals(50.0, grade1.getGrade());
		Assert.assertEquals(60.0, grade2.getGrade());
		Assert.assertEquals(70.0, grade3.getGrade());
		Assert.assertEquals(80.0, grade4.getGrade());
		Assert.assertEquals(90.0, grade5.getGrade());
	}
	
	@Test
	public void testGetWeight()
	{
		Assert.assertNotEquals(0.0, grade1.getWeight());
		Assert.assertNotEquals(0.0, grade2.getWeight());
		Assert.assertNotEquals(0.0, grade3.getWeight());
		Assert.assertNotEquals(0.0, grade4.getWeight());
		Assert.assertNotEquals(0.0, grade5.getWeight());

		Assert.assertEquals(10.0, grade1.getWeight());
		Assert.assertEquals(15.0, grade2.getWeight());
		Assert.assertEquals(20.0, grade3.getWeight());
		Assert.assertEquals(25.0, grade4.getWeight());
		Assert.assertEquals(30.0, grade5.getWeight());

	}
	
	@Test
	public void testSetGrade()
	{
		grade1.setGrade(100.0);
		Assert.assertEquals (100.0, grade1.getGrade());
		Assert.assertNotEquals (0.0, grade1.getGrade());
		
		grade2.setGrade(90.0);
		Assert.assertEquals (90.0, grade2.getGrade());
		Assert.assertNotEquals (0.0, grade2.getGrade());
		
		grade3.setGrade(80.0);
		Assert.assertEquals (80.0, grade3.getGrade());
		Assert.assertNotEquals (0.0, grade3.getGrade());
		
		grade4.setGrade(70.0);
		Assert.assertEquals (70.0, grade4.getGrade());
		Assert.assertNotEquals (0.0, grade4.getGrade());
		
		grade5.setGrade(60.0);
		Assert.assertEquals (60.0, grade5.getGrade());
		Assert.assertNotEquals (0.0, grade5.getGrade());
	}
	
	@Test
	public void testSetWeight()
	{
		grade1.setWeight(40.0);
		Assert.assertEquals (40.0, grade1.getWeight());
		Assert.assertNotEquals (0.0, grade1.getWeight());
		
		grade2.setWeight(50.0);
		Assert.assertEquals (50.0, grade2.getWeight());
		Assert.assertNotEquals (0.0, grade2.getWeight());
		
		grade3.setWeight(5.0);
		Assert.assertEquals (5.0, grade3.getWeight());
		Assert.assertNotEquals (0.0, grade3.getWeight());
		
		grade4.setWeight(10.0);
		Assert.assertEquals (10.0, grade4.getWeight());
		Assert.assertNotEquals (0.0, grade4.getWeight());
		
		grade5.setWeight(25.0);
		Assert.assertEquals (25.0, grade5.getWeight());
		Assert.assertNotEquals (0.0, grade5.getWeight());
	}
}