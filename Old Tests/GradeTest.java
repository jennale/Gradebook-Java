package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
*
* GradeTest tests the Grade class methods.
*
* @author Zaid Albirawi
* @version 1.0 3/1/2014
*/

public class GradeTest
{
	Grade grd0, grd1, grd2, grd3, grd4;
	@Before
	public void testGrade()
	{
		grd0=new Grade(91, 0.01);
		grd1=new Grade(91, 0.07);
		grd2=new Grade(50, 0.07);
		grd3=new Grade(100, 0.50);
		grd4=new Grade(95, 0.35);
	}

	@Test
	public void testGetGrade() 
	{
		Assert.assertTrue(grd0.getGrade()==91);
		Assert.assertTrue(grd1.getGrade()==91);
		Assert.assertTrue(grd2.getGrade()==50);
		Assert.assertTrue(grd3.getGrade()==100);
		Assert.assertTrue(grd4.getGrade()==95);
		
		Assert.assertFalse(grd0.getGrade()==0);
		Assert.assertFalse(grd1.getGrade()==0);
		Assert.assertFalse(grd2.getGrade()==0);
		Assert.assertFalse(grd3.getGrade()==0);
		Assert.assertFalse(grd4.getGrade()==0);
	}

	@Test
	public void testGetWeight()
	{
		Assert.assertTrue(grd0.getWeight()==0.01);
		Assert.assertTrue(grd1.getWeight()==0.07);
		Assert.assertTrue(grd2.getWeight()==0.07);
		Assert.assertTrue(grd3.getWeight()==0.50);
		Assert.assertTrue(grd4.getWeight()==0.35);
		
		Assert.assertFalse(grd0.getWeight()==0);
		Assert.assertFalse(grd1.getWeight()==0);
		Assert.assertFalse(grd2.getWeight()==0);
		Assert.assertFalse(grd3.getWeight()==0);
		Assert.assertFalse(grd4.getWeight()==0);
	}

	@Test
	public void testSetGrade()
	{
		grd0.setGrade(91);
		grd1.setGrade(94);
		grd2.setGrade(50);
		grd3.setGrade(90);
		grd4.setGrade(85);
		
		Assert.assertTrue(grd0.getGrade()==91);
		Assert.assertTrue(grd1.getGrade()==94);
		Assert.assertTrue(grd2.getGrade()==50);
		Assert.assertTrue(grd3.getGrade()==90);
		Assert.assertTrue(grd4.getGrade()==85);
		
		Assert.assertFalse(grd0.getGrade()==0);
		Assert.assertFalse(grd1.getGrade()==0);
		Assert.assertFalse(grd2.getGrade()==0);
		Assert.assertFalse(grd3.getGrade()==0);
		Assert.assertFalse(grd4.getGrade()==0);
	}

	@Test
	public void testSetWeight()
	{
		grd0.setWeight(0.05);
		grd1.setWeight(0.10);
		grd2.setWeight(0.10);
		grd3.setWeight(0.45);
		grd4.setWeight(0.30);
		
		Assert.assertTrue(grd0.getWeight()==0.05);
		Assert.assertTrue(grd1.getWeight()==0.10);
		Assert.assertTrue(grd2.getWeight()==0.10);
		Assert.assertTrue(grd3.getWeight()==0.45);
		Assert.assertTrue(grd4.getWeight()==0.30);
		
		Assert.assertFalse(grd0.getWeight()==0);
		Assert.assertFalse(grd1.getWeight()==0);
		Assert.assertFalse(grd2.getWeight()==0);
		Assert.assertFalse(grd3.getWeight()==0);
		Assert.assertFalse(grd4.getWeight()==0);
	}
}