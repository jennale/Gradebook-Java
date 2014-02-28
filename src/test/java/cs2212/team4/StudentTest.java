package cs2212.team4;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class StudentTest
{
	ArrayList<Deliverable> deliverableList = new ArrayList<Deliverable>();
	Student stud = new Student("Zaid", "Albirawi", 111111111, "zalbiraw@uwo.ca");

	@Before
	public void addDeliverables()
	{
		deliverableList.add(new Deliverable("Exam", "Exam", 40.0, 20));
		deliverableList.add(new Deliverable("Assignment 1", "Assignment", 20.0, 20));
		deliverableList.add(new Deliverable("Assignment 2", "Assignment", 20.0, 20));
		deliverableList.add(new Deliverable("Participation", "Other", 20.0, 20));
	}

	@Test
	public void testGetNameFirst() 
	{
		Assert.assertEquals("Zaid", stud.getNameFirst());
		Assert.assertNotEquals("name", stud.getNameFirst());
	}

	@Test
	public void testGetNameLast() 
	{
		Assert.assertEquals("Albirawi", stud.getNameLast());
		Assert.assertNotEquals("name", stud.getNameLast());
	}

	@Test
	public void testGetNumber()
	{
		Assert.assertEquals(111111111, stud.getNumber());
		Assert.assertNotEquals(000000000, stud.getNumber());
	}

	@Test
	public void testGetEmail()
	{
		Assert.assertEquals("zalbiraw@uwo.ca", stud.getEmail());
		Assert.assertNotEquals("", stud.getEmail());
	}

	@Test
	public void testGetGrade()
	{
		stud.addGrade(0, 75.0, "type1", 5.0);
		Assert.assertTrue(stude.getGrade(0));
	}

	@Test
	public void testGetAvg()
	{
		Assert.assertTrue(0.8==stud.getAvg());
		Assert.assertFalse(0==stud.getAvg());
	}

	@Test
	public void testGetAsnAvg()
	{
		Assert.assertTrue(1==stud.getAsnAvg());
		Assert.assertFalse(0==stud.getAsnAvg());
	}

	@Test
	public void testGetExmAvg() 
	{
		Assert.assertTrue(0.5==stud.getExmAvg());
		Assert.assertFalse(0==stud.getExmAvg());
	}

	@Test
	public void testSetNameFirst()
	{
		stud.setNameFirst("newZaid");
		Assert.assertEquals ("newZaid", stud.getNameFirst());
		Assert.assertNotEquals ("Zaid", stud.getNameFirst());
	}

	@Test
	public void testSetNameLast()
	{
		stud.setNameLast("newAlbirawi");
		Assert.assertEquals ("newAlbirawi", stud.getNameLast());
		Assert.assertNotEquals ("Albirawi", stud.getNameLast());
	}

	@Test
	public void testSetNumber()
	{
		stud.setNumber(000000000);
		Assert.assertEquals (000000000, stud.getNumber());
		Assert.assertNotEquals (111111111, stud.getNumber());
	}

	@Test
	public void testSetEmail() 
	{
		stud.setEmail("zalbiraw@csd.ca");
		Assert.assertEquals ("zalbiraw@csd.ca", stud.getEmail());
		Assert.assertNotEquals ("zalbiraw@uwo.ca", stud.getEmail());
	}

	@Test
	public void testSetAvg()
	{
		stud.setAvg(90);
		Assert.assertTrue((90==stud.getAvg()));
		Assert.assertFalse((80==stud.getAvg()));
	}

	@Test
	public void testSetAsnAvg()
	{
		stud.setAsnAvg(90);
		Assert.assertTrue((90==stud.getAsnAvg()));
		Assert.assertFalse((100==stud.getAsnAvg()));
	}

	@Test
	public void testSetExmAvg() 
	{
		stud.setExmAvg(70);
		Assert.assertTrue((70==stud.getExmAvg()));
		Assert.assertFalse((100==stud.getExmAvg()));
	}

	@Test
	public void testAddGrade() 
	{
		Assert.assertTrue(stud.addGrade(0, 75.0, "type1", 5.0));
		Assert.assertFalse(stud.addGrade(1, 75.0, 5.0, "type1"));
	}

	@Test
	public void testRemoveGrade() 
	{
		Assert.assertTrue(stud.addGrade(1, 80.0, "type2", 5.0));
		Assert.assertTrue(stud.removeGrade(1, "type2"));
		Asert.assertFalse(stud.removeGrade(3, "type3"));
	}

	@Test
	public void testToString() 
	{
		String str="\"Albirawi\", \"Zaid\", \"111111111\", \"zalbiraw@uwo.ca\"\n";
		Assert.assertEquals(str, stud.toString());
	}

}
