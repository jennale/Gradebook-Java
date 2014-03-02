package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
*
* DeliverableTest tests the Deliverable class methods.
*
* @author Zaid Albirawi
* @version 2.0 3/1/2014
*/

public class DeliverableTest
{
	
	Deliverable deliver0, deliver1, deliver2, deliver3, deliver4;
	
	@Before
	public void testDeliverable()
	{
		deliver0=new Deliverable("Quiz", "Other", 0.01, 0);
		deliver1=new Deliverable("Assignment 1", "Assignment", 0.14, 1);
		deliver2=new Deliverable("Assignment 2", "Assignment", 0.15, 2);
		deliver3=new Deliverable("Assignment 3", "Assignment", 0.30, 3);
		deliver4=new Deliverable("Final Exam", "Exam", 0.40, 4);
	}

	@Test
	public void testGetName()
	{
		Assert.assertTrue(deliver0.getName().equals("Quiz"));
		Assert.assertTrue(deliver1.getName().equals("Assignment 1"));
		Assert.assertTrue(deliver2.getName().equals("Assignment 2"));
		Assert.assertTrue(deliver3.getName().equals("Assignment 3"));
		Assert.assertTrue(deliver4.getName().equals("Final Exam"));
		
		Assert.assertFalse(deliver0.getName().equals("Other"));
		Assert.assertFalse(deliver1.getName().equals("Other"));
		Assert.assertFalse(deliver2.getName().equals("Other"));
		Assert.assertFalse(deliver3.getName().equals("Other"));
		Assert.assertFalse(deliver4.getName().equals("Other"));
	}

	@Test
	public void testGetType()
	{
		Assert.assertTrue(deliver0.getType().equals("Other"));
		Assert.assertTrue(deliver1.getType().equals("Assignment"));
		Assert.assertTrue(deliver2.getType().equals("Assignment"));
		Assert.assertTrue(deliver3.getType().equals("Assignment"));
		Assert.assertTrue(deliver4.getType().equals("Exam"));
		
		Assert.assertFalse(deliver0.getType().equals(""));
		Assert.assertFalse(deliver1.getType().equals(""));
		Assert.assertFalse(deliver2.getType().equals(""));
		Assert.assertFalse(deliver3.getType().equals(""));
		Assert.assertFalse(deliver4.getType().equals(""));
	}

	@Test
	public void testGetWeight()
	{
		Assert.assertTrue(deliver0.getWeight()==0.01);
		Assert.assertTrue(deliver1.getWeight()==0.14);
		Assert.assertTrue(deliver2.getWeight()==0.15);
		Assert.assertTrue(deliver3.getWeight()==0.30);
		Assert.assertTrue(deliver4.getWeight()==0.40);
		
		Assert.assertFalse(deliver0.getWeight()==0);
		Assert.assertFalse(deliver1.getWeight()==0);
		Assert.assertFalse(deliver2.getWeight()==0);
		Assert.assertFalse(deliver3.getWeight()==0);
		Assert.assertFalse(deliver4.getWeight()==0);
	}

	@Test
	public void testGetObjId()
	{
		Assert.assertTrue(deliver0.getObjId()==0);
		Assert.assertTrue(deliver1.getObjId()==1);
		Assert.assertTrue(deliver2.getObjId()==2);
		Assert.assertTrue(deliver3.getObjId()==3);
		Assert.assertTrue(deliver4.getObjId()==4);
		
		Assert.assertFalse(deliver0.getObjId()==-1);
		Assert.assertFalse(deliver1.getObjId()==-1);
		Assert.assertFalse(deliver2.getObjId()==-1);
		Assert.assertFalse(deliver3.getObjId()==-1);
		Assert.assertFalse(deliver4.getObjId()==-1);
	}

	@Test
	public void testSetName()
	{
		deliver0.setName("Class Assement");
		deliver1.setName("Assignment");
		deliver2.setName("Midterm");
		deliver3.setName("Group Project");
		deliver4.setName("Final");
		
		Assert.assertTrue(deliver0.getName().equals("Class Assement"));
		Assert.assertTrue(deliver1.getName().equals("Assignment"));
		Assert.assertTrue(deliver2.getName().equals("Midterm"));
		Assert.assertTrue(deliver3.getName().equals("Group Project"));
		Assert.assertTrue(deliver4.getName().equals("Final"));
		
		Assert.assertFalse(deliver0.getName().equals("Other"));
		Assert.assertFalse(deliver1.getName().equals("Other"));
		Assert.assertFalse(deliver2.getName().equals("Other"));
		Assert.assertFalse(deliver3.getName().equals("Other"));
		Assert.assertFalse(deliver4.getName().equals("Other"));
	}

	@Test
	public void testSetType()
	{
		deliver0.setType("Other");
		deliver1.setType("Assignment");
		deliver2.setType("Exam");
		deliver3.setType("Project");
		deliver4.setType("Final");
		
		Assert.assertTrue(deliver0.getType().equals("Other"));
		Assert.assertTrue(deliver1.getType().equals("Assignment"));
		Assert.assertTrue(deliver2.getType().equals("Exam"));
		Assert.assertTrue(deliver3.getType().equals("Project"));
		Assert.assertTrue(deliver4.getType().equals("Final"));
		
		Assert.assertFalse(deliver0.getType().equals(""));
		Assert.assertFalse(deliver1.getType().equals(""));
		Assert.assertFalse(deliver2.getType().equals(""));
		Assert.assertFalse(deliver3.getType().equals(""));
		Assert.assertFalse(deliver4.getType().equals(""));
	}

	@Test
	public void testSetWeight()
	{
		deliver0.setWeight(0.01);
		deliver1.setWeight(0.09);
		deliver2.setWeight(0.20);
		deliver3.setWeight(0.40);
		deliver4.setWeight(0.30);
		
		Assert.assertTrue(deliver0.getWeight()==0.01);
		Assert.assertTrue(deliver1.getWeight()==0.09);
		Assert.assertTrue(deliver2.getWeight()==0.20);
		Assert.assertTrue(deliver3.getWeight()==0.40);
		Assert.assertTrue(deliver4.getWeight()==0.30);
		
		Assert.assertFalse(deliver0.getWeight()==0);
		Assert.assertFalse(deliver1.getWeight()==0);
		Assert.assertFalse(deliver2.getWeight()==0);
		Assert.assertFalse(deliver3.getWeight()==0);
		Assert.assertFalse(deliver4.getWeight()==0);
	}

	@Test
	public void testEqualsDeliverable()
	{
		Assert.assertTrue(deliver0.equals(new Deliverable("Quiz","Other",0.01, 0)));
		Assert.assertTrue(deliver1.equals(new Deliverable("Assignment 1","Assignment",0.14, 0)));
		Assert.assertTrue(deliver2.equals(new Deliverable("Assignment 2","Assignment",0.15, 0)));
		Assert.assertTrue(deliver3.equals(new Deliverable("Assignment 3","Assignment",0.30, 0)));
		Assert.assertTrue(deliver4.equals(new Deliverable("Final Exam","Exam",0.40, 0)));
		
		Assert.assertFalse(deliver0.equals(new Deliverable("Name","Type",0, 0)));
		Assert.assertFalse(deliver1.equals(new Deliverable("Name","Type",0, 0)));
		Assert.assertFalse(deliver2.equals(new Deliverable("Name","Type",0, 0)));
		Assert.assertFalse(deliver3.equals(new Deliverable("Name","Type",0, 0)));
		Assert.assertFalse(deliver4.equals(new Deliverable("Name","Type",0, 0)));
	}

	@Test
	public void testToString()
	{
		Assert.assertTrue(deliver0.toString().equals("\"Quiz\", \"Other\", \"0.01\"\n"));
		Assert.assertTrue(deliver1.toString().equals("\"Assignment 1\", \"Assignment\", \"0.14\"\n"));
		Assert.assertTrue(deliver2.toString().equals("\"Assignment 2\", \"Assignment\", \"0.15\"\n"));
		Assert.assertTrue(deliver3.toString().equals("\"Assignment 3\", \"Assignment\", \"0.3\"\n"));
		Assert.assertTrue(deliver4.toString().equals("\"Final Exam\", \"Exam\", \"0.4\"\n"));
		
		Assert.assertFalse(deliver0.toString().equals("\"Name\", \"Type\", \"0\""));
		Assert.assertFalse(deliver1.toString().equals("\"Name\", \"Type\", \"0\""));
		Assert.assertFalse(deliver2.toString().equals("\"Name\", \"Type\", \"0\""));
		Assert.assertFalse(deliver3.toString().equals("\"Name\", \"Type\", \"0\""));
		Assert.assertFalse(deliver4.toString().equals("\"Name\", \"Type\", \"0\""));
	}
}
