package cs2212.team4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class GradebookTest 
{
	Gradebook gbook = new Gradebook();
	
	@Before
	public void addCourses()
	{
		gbook.addCourse("course1", "term1", "code1");
		gbook.addCourse("course2", "term2", "code2");
		gbook.addCourse("course3", "term3", "code3");
	}
	
	@Test
	public void testAddCourse()
	{
		Assert.assertFalse((gbook.addCourse("course1", "term1", "code1")));
		Assert.assertFalse((gbook.addCourse("course2", "term2", "code2")));
		Assert.assertFalse((gbook.addCourse("course3", "term3", "code3")));
		
		Assert.assertTrue((gbook.addCourse("course1", "term1", "code")));
		Assert.assertTrue((gbook.addCourse("course2", "term2", "code")));
		Assert.assertTrue((gbook.addCourse("course3", "term3", "code")));
		
		Assert.assertTrue((gbook.addCourse("course1", "term", "code")));
		Assert.assertTrue((gbook.addCourse("course2", "term", "code")));
		Assert.assertTrue((gbook.addCourse("course3", "term", "code")));
		
		Assert.assertTrue((gbook.addCourse("course", "term", "code")));
	}


	@Test
	public void testFindCourse() 
	{
		Assert.assertEquals(0, gbook.findCourse(new Course("course1", "term1", "code1")));
		Assert.assertNotEquals(0, gbook.findCourse(new Course("course2", "term2", "code2")));
		Assert.assertNotEquals(0, gbook.findCourse(new Course("course3", "term3", "code3")));
		
		Assert.assertNotEquals(1, gbook.findCourse(new Course("course1", "term1", "code1")));
		Assert.assertEquals(1, gbook.findCourse(new Course("course2", "term2", "code2")));
		Assert.assertNotEquals(1, gbook.findCourse(new Course("course3", "term3", "code3")));
		
		Assert.assertNotEquals(2, gbook.findCourse(new Course("course1", "term1", "code1")));
		Assert.assertNotEquals(2, gbook.findCourse(new Course("course2", "term2", "code2")));
		Assert.assertEquals(2, gbook.findCourse(new Course("course3", "term3", "code3")));
	}

	@Test
	public void testRemoveCourse() 
	{
		Assert.assertTrue(gbook.removeCourse(new Course("course1", "term1", "code1")));
		Assert.assertTrue(gbook.removeCourse(new Course("course2", "term2", "code2")));
		Assert.assertTrue(gbook.removeCourse(new Course("course3", "term3", "code3")));
		
		Assert.assertFalse(gbook.removeCourse(new Course("course3", "term3", "code3")));
		Assert.assertFalse(gbook.removeCourse(new Course("course", "term", "code")));
	}

}
