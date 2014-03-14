package cs2212.team4;

import static org.junit.Assert.*;
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
		assertTrue(deliver0.getName().equals("Quiz"));
		assertTrue(deliver1.getName().equals("Assignment 1"));
		assertTrue(deliver2.getName().equals("Assignment 2"));
		assertTrue(deliver3.getName().equals("Assignment 3"));
		assertTrue(deliver4.getName().equals("Final Exam"));
		
		assertFalse(deliver0.getName().equals("Other"));
		assertFalse(deliver1.getName().equals("Other"));
		assertFalse(deliver2.getName().equals("Other"));
		assertFalse(deliver3.getName().equals("Other"));
		assertFalse(deliver4.getName().equals("Other"));
	}

	@Test
	public void testGetType()
	{
		assertTrue(deliver0.getType().equals("Other"));
		assertTrue(deliver1.getType().equals("Assignment"));
		assertTrue(deliver2.getType().equals("Assignment"));
		assertTrue(deliver3.getType().equals("Assignment"));
		assertTrue(deliver4.getType().equals("Exam"));
		
		assertFalse(deliver0.getType().equals(""));
		assertFalse(deliver1.getType().equals(""));
		assertFalse(deliver2.getType().equals(""));
		assertFalse(deliver3.getType().equals(""));
		assertFalse(deliver4.getType().equals(""));
	}

	@Test
	public void testGetWeight()
	{
		assertTrue(deliver0.getWeight()==0.01);
		assertTrue(deliver1.getWeight()==0.14);
		assertTrue(deliver2.getWeight()==0.15);
		assertTrue(deliver3.getWeight()==0.30);
		assertTrue(deliver4.getWeight()==0.40);
		
		assertFalse(deliver0.getWeight()==0);
		assertFalse(deliver1.getWeight()==0);
		assertFalse(deliver2.getWeight()==0);
		assertFalse(deliver3.getWeight()==0);
		assertFalse(deliver4.getWeight()==0);
	}

	@Test
	public void testGetObjId()
	{
		assertTrue(deliver0.getObjId()==0);
		assertTrue(deliver1.getObjId()==1);
		assertTrue(deliver2.getObjId()==2);
		assertTrue(deliver3.getObjId()==3);
		assertTrue(deliver4.getObjId()==4);
		
		assertFalse(deliver0.getObjId()==-1);
		assertFalse(deliver1.getObjId()==-1);
		assertFalse(deliver2.getObjId()==-1);
		assertFalse(deliver3.getObjId()==-1);
		assertFalse(deliver4.getObjId()==-1);
	}

	@Test
	public void testSetName()
	{
		deliver0.setName("Class Assement");
		deliver1.setName("Assignment");
		deliver2.setName("Midterm");
		deliver3.setName("Group Project");
		deliver4.setName("Final");
		
		assertTrue(deliver0.getName().equals("Class Assement"));
		assertTrue(deliver1.getName().equals("Assignment"));
		assertTrue(deliver2.getName().equals("Midterm"));
		assertTrue(deliver3.getName().equals("Group Project"));
		assertTrue(deliver4.getName().equals("Final"));
		
		assertFalse(deliver0.getName().equals("Other"));
		assertFalse(deliver1.getName().equals("Other"));
		assertFalse(deliver2.getName().equals("Other"));
		assertFalse(deliver3.getName().equals("Other"));
		assertFalse(deliver4.getName().equals("Other"));
	}

	@Test
	public void testSetType()
	{
		deliver0.setType("Other");
		deliver1.setType("Assignment");
		deliver2.setType("Exam");
		deliver3.setType("Project");
		deliver4.setType("Final");
		
		assertTrue(deliver0.getType().equals("Other"));
		assertTrue(deliver1.getType().equals("Assignment"));
		assertTrue(deliver2.getType().equals("Exam"));
		assertTrue(deliver3.getType().equals("Project"));
		assertTrue(deliver4.getType().equals("Final"));
		
		assertFalse(deliver0.getType().equals(""));
		assertFalse(deliver1.getType().equals(""));
		assertFalse(deliver2.getType().equals(""));
		assertFalse(deliver3.getType().equals(""));
		assertFalse(deliver4.getType().equals(""));
	}

	@Test
	public void testSetWeight()
	{
		deliver0.setWeight(0.01);
		deliver1.setWeight(0.09);
		deliver2.setWeight(0.20);
		deliver3.setWeight(0.40);
		deliver4.setWeight(0.30);
		
		assertTrue(deliver0.getWeight()==0.01);
		assertTrue(deliver1.getWeight()==0.09);
		assertTrue(deliver2.getWeight()==0.20);
		assertTrue(deliver3.getWeight()==0.40);
		assertTrue(deliver4.getWeight()==0.30);
		
		assertFalse(deliver0.getWeight()==0);
		assertFalse(deliver1.getWeight()==0);
		assertFalse(deliver2.getWeight()==0);
		assertFalse(deliver3.getWeight()==0);
		assertFalse(deliver4.getWeight()==0);
	}

	@Test
	public void testEqualsDeliverable()
	{
		assertTrue(deliver0.equals(new Deliverable("Quiz","Other",0.01, 0)));
		assertTrue(deliver1.equals(new Deliverable("Assignment 1","Assignment",0.14, 0)));
		assertTrue(deliver2.equals(new Deliverable("Assignment 2","Assignment",0.15, 0)));
		assertTrue(deliver3.equals(new Deliverable("Assignment 3","Assignment",0.30, 0)));
		assertTrue(deliver4.equals(new Deliverable("Final Exam","Exam",0.40, 0)));
		
		assertFalse(deliver0.equals(new Deliverable("Name","Type",0, 0)));
		assertFalse(deliver1.equals(new Deliverable("Name","Type",0, 0)));
		assertFalse(deliver2.equals(new Deliverable("Name","Type",0, 0)));
		assertFalse(deliver3.equals(new Deliverable("Name","Type",0, 0)));
		assertFalse(deliver4.equals(new Deliverable("Name","Type",0, 0)));
	}

	@Test
	public void testToString()
	{
		assertTrue(deliver0.toString().equals("\"Quiz\", \"Other\", \"0.01\"\n"));
		assertTrue(deliver1.toString().equals("\"Assignment 1\", \"Assignment\", \"0.14\"\n"));
		assertTrue(deliver2.toString().equals("\"Assignment 2\", \"Assignment\", \"0.15\"\n"));
		assertTrue(deliver3.toString().equals("\"Assignment 3\", \"Assignment\", \"0.3\"\n"));
		assertTrue(deliver4.toString().equals("\"Final Exam\", \"Exam\", \"0.4\"\n"));
		
		assertFalse(deliver0.toString().equals("\"Name\", \"Type\", \"0\""));
		assertFalse(deliver1.toString().equals("\"Name\", \"Type\", \"0\""));
		assertFalse(deliver2.toString().equals("\"Name\", \"Type\", \"0\""));
		assertFalse(deliver3.toString().equals("\"Name\", \"Type\", \"0\""));
		assertFalse(deliver4.toString().equals("\"Name\", \"Type\", \"0\""));
	}
}
