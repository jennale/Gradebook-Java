package cs2212.team4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*
* StudentTest tests the Student class methods.
*
* @author Zaid Albirawi
* @version 2.0 3/1/2014
*/

public class StudentTest
{
	
	Student stud, stud0, stud1, stud2, stud3, stud4;
	
	@Before
	public void testStudent()
	{
		stud=new Student("Zaid", "Albirawi", "000000000", "zalbiraw0@uwo.ca");
		stud0=new Student("Zaid0", "Albirawi0", "250626000", "zalbiraw0@uwo.ca");
		stud1=new Student("Zaid1", "Albirawi1", "250626001", "zalbiraw1@uwo.ca");
		stud2=new Student("Zaid2", "Albirawi2", "250626002", "zalbiraw2@uwo.ca");
		stud3=new Student("Zaid3", "Albirawi3", "250626003", "zalbiraw3@uwo.ca");
		stud4=new Student("Zaid4", "Albirawi4", "250626004", "zalbiraw4@uwo.ca");
		
		stud.addGrade(0, 100, "Assignment", 0.5);
		stud.addGrade(1, 50, "Exam", 0.5);
	}

	@Test
	public void testGetNameFirst()
	{
		assertTrue(stud0.getNameFirst().equals("Zaid0"));
		assertTrue(stud1.getNameFirst().equals("Zaid1"));
		assertTrue(stud2.getNameFirst().equals("Zaid2"));
		assertTrue(stud3.getNameFirst().equals("Zaid3"));
		assertTrue(stud4.getNameFirst().equals("Zaid4"));
		
		assertFalse(stud0.getNameFirst().equals("Zaid"));
		assertFalse(stud1.getNameFirst().equals("Zaid"));
		assertFalse(stud2.getNameFirst().equals("Zaid"));
		assertFalse(stud3.getNameFirst().equals("Zaid"));
		assertFalse(stud4.getNameFirst().equals("Zaid"));		
	}

	@Test
	public void testGetNameLast()
	{
		assertTrue(stud0.getNameLast().equals("Albirawi0"));
		assertTrue(stud1.getNameLast().equals("Albirawi1"));
		assertTrue(stud2.getNameLast().equals("Albirawi2"));
		assertTrue(stud3.getNameLast().equals("Albirawi3"));
		assertTrue(stud4.getNameLast().equals("Albirawi4"));
		
		assertFalse(stud0.getNameLast().equals("Albirawi"));
		assertFalse(stud1.getNameLast().equals("Albirawi"));
		assertFalse(stud2.getNameLast().equals("Albirawi"));
		assertFalse(stud3.getNameLast().equals("Albirawi"));
		assertFalse(stud4.getNameLast().equals("Albirawi"));
	}

	@Test
	public void testGetNumber()
	{
		assertTrue(stud0.getNumber().equals("250626000"));
		assertTrue(stud1.getNumber().equals("250626001"));
		assertTrue(stud2.getNumber().equals("250626002"));
		assertTrue(stud3.getNumber().equals("250626003"));
		assertTrue(stud4.getNumber().equals("250626004"));
		
		assertFalse(stud0.getNumber().equals("25062600"));
		assertFalse(stud1.getNumber().equals("25062600"));
		assertFalse(stud2.getNumber().equals("25062600"));
		assertFalse(stud3.getNumber().equals("25062600"));
		assertFalse(stud4.getNumber().equals("25062600"));
	}

	@Test
	public void testGetEmail() 
	{
		assertTrue(stud0.getEmail().equals("zalbiraw0@uwo.ca"));
		assertTrue(stud1.getEmail().equals("zalbiraw1@uwo.ca"));
		assertTrue(stud2.getEmail().equals("zalbiraw2@uwo.ca"));
		assertTrue(stud3.getEmail().equals("zalbiraw3@uwo.ca"));
		assertTrue(stud4.getEmail().equals("zalbiraw4@uwo.ca"));
		
		assertFalse(stud0.getEmail().equals("zalbiraw@uwo.ca"));
		assertFalse(stud1.getEmail().equals("zalbiraw@uwo.ca"));
		assertFalse(stud2.getEmail().equals("zalbiraw@uwo.ca"));
		assertFalse(stud3.getEmail().equals("zalbiraw@uwo.ca"));
		assertFalse(stud4.getEmail().equals("zalbiraw@uwo.ca"));
	}

	@Test
	public void testGetGrade()
	{
		assertTrue(stud.getGrade(0)==100);
		assertTrue(stud.getGrade(1)==50);
		
		assertFalse(stud.getGrade(0)==0);
		assertFalse(stud.getGrade(1)==0);
	}

	@Test
	public void testGetAvg() 
	{
		assertTrue(stud.getAvg()==75);
		assertFalse(stud.getAvg()==0);
	}

	@Test
	public void testGetAsnAvg()
	{
		assertTrue(stud.getAsnAvg()==100);
		assertFalse(stud.getAsnAvg()==0);
	}

	@Test
	public void testGetExmAvg()
	{
		assertTrue(stud.getExmAvg()==50);
		assertFalse(stud.getExmAvg()==0);
	}

	@Test
	public void testSetNameFirst()
	{
		stud0.setNameFirst("Zaid");
		stud1.setNameFirst("Zaid");
		stud2.setNameFirst("Zaid");
		stud3.setNameFirst("Zaid");
		stud4.setNameFirst("Zaid");
		
		assertTrue(stud0.getNameFirst().equals("Zaid"));
		assertTrue(stud1.getNameFirst().equals("Zaid"));
		assertTrue(stud2.getNameFirst().equals("Zaid"));
		assertTrue(stud3.getNameFirst().equals("Zaid"));
		assertTrue(stud4.getNameFirst().equals("Zaid"));
		
		assertFalse(stud0.getNameFirst().equals("Zaid0"));
		assertFalse(stud1.getNameFirst().equals("Zaid1"));
		assertFalse(stud2.getNameFirst().equals("Zaid2"));
		assertFalse(stud3.getNameFirst().equals("Zaid3"));
		assertFalse(stud4.getNameFirst().equals("Zaid4"));
	}

	@Test
	public void testSetNameLast()
	{
		stud0.setNameLast("Albirawi");
		stud1.setNameLast("Albirawi");
		stud2.setNameLast("Albirawi");
		stud3.setNameLast("Albirawi");
		stud4.setNameLast("Albirawi");
		
		assertTrue(stud0.getNameLast().equals("Albirawi"));
		assertTrue(stud1.getNameLast().equals("Albirawi"));
		assertTrue(stud2.getNameLast().equals("Albirawi"));
		assertTrue(stud3.getNameLast().equals("Albirawi"));
		assertTrue(stud4.getNameLast().equals("Albirawi"));
		
		assertFalse(stud0.getNameLast().equals("Albirawi0"));
		assertFalse(stud1.getNameLast().equals("Albirawi1"));
		assertFalse(stud2.getNameLast().equals("Albirawi2"));
		assertFalse(stud3.getNameLast().equals("Albirawi3"));
		assertFalse(stud4.getNameLast().equals("Albirawi4"));
	}

	@Test
	public void testSetNumber()
	{
		stud0.setNumber("000000000");
		stud1.setNumber("111111111");
		stud2.setNumber("222222222");
		stud3.setNumber("333333333");
		stud4.setNumber("444444444");
		
		assertTrue(stud0.getNumber().equals("000000000"));
		assertTrue(stud1.getNumber().equals("111111111"));
		assertTrue(stud2.getNumber().equals("222222222"));
		assertTrue(stud3.getNumber().equals("333333333"));
		assertTrue(stud4.getNumber().equals("444444444"));
		
		assertFalse(stud0.getNumber().equals("25062600"));
		assertFalse(stud1.getNumber().equals("25062600"));
		assertFalse(stud2.getNumber().equals("25062600"));
		assertFalse(stud3.getNumber().equals("25062600"));
		assertFalse(stud4.getNumber().equals("25062600"));
	}

	@Test
	public void testSetEmail()
	{
		stud0.setEmail("zalbiraw@uwo.ca");
		stud1.setEmail("zalbiraw@uwo.ca");
		stud2.setEmail("zalbiraw@uwo.ca");
		stud3.setEmail("zalbiraw@uwo.ca");
		stud4.setEmail("zalbiraw@uwo.ca");
		
		assertTrue(stud0.getEmail().equals("zalbiraw@uwo.ca"));
		assertTrue(stud1.getEmail().equals("zalbiraw@uwo.ca"));
		assertTrue(stud2.getEmail().equals("zalbiraw@uwo.ca"));
		assertTrue(stud3.getEmail().equals("zalbiraw@uwo.ca"));
		assertTrue(stud4.getEmail().equals("zalbiraw@uwo.ca"));
		
		assertFalse(stud0.getEmail().equals("zalbiraw0@uwo.ca"));
		assertFalse(stud1.getEmail().equals("zalbiraw1@uwo.ca"));
		assertFalse(stud2.getEmail().equals("zalbiraw2@uwo.ca"));
		assertFalse(stud3.getEmail().equals("zalbiraw3@uwo.ca"));
		assertFalse(stud4.getEmail().equals("zalbiraw4@uwo.ca"));
	}

	@Test
	public void testSetAvg()
	{
		stud.setAvg(100);
		assertTrue(stud.getAvg()==100);
		assertFalse(stud.getAvg()==75);
	}

	@Test
	public void testSetAsnAvg()
	{
		stud.setAsnAvg(75);
		assertTrue(stud.getAsnAvg()==75);
		assertFalse(stud.getAsnAvg()==100);
	}

	@Test
	public void testSetExmAvg()
	{
		stud.setExmAvg(75);
		assertTrue(stud.getExmAvg()==75);
		assertFalse(stud.getExmAvg()==50);
	}

	@Test
	public void testAddGrade()
	{
		assertTrue(stud.addGrade(0, 100, "Other", 1));
	}

	@Test
	public void testRemoveGrade()
	{
		assertTrue(stud.removeGrade(0, "Assignment"));
		assertTrue(stud.removeGrade(1, "Exam"));
		
		assertFalse(stud.removeGrade(0, "Exam"));
		assertFalse(stud.removeGrade(1, "Assignment"));
	}

	@Test
	public void testEqualsStudent()
	{
		assertTrue(stud0.equals(new Student("Zaid0", "Albirawi0", "250626000", "zalbiraw0@uwo.ca")));
		assertTrue(stud1.equals(new Student("Zaid1", "Albirawi1", "250626001", "zalbiraw1@uwo.ca")));
		assertTrue(stud2.equals(new Student("Zaid2", "Albirawi2", "250626002", "zalbiraw2@uwo.ca")));
		assertTrue(stud3.equals(new Student("Zaid3", "Albirawi3", "250626003", "zalbiraw3@uwo.ca")));
		assertTrue(stud4.equals(new Student("Zaid4", "Albirawi4", "250626004", "zalbiraw4@uwo.ca")));
		
		assertFalse(stud0.equals(new Student("Zaid", "Albirawi", "25062600", "zalbiraw@uwo.ca")));
		assertFalse(stud1.equals(new Student("Zaid", "Albirawi", "25062600", "zalbiraw@uwo.ca")));
		assertFalse(stud2.equals(new Student("Zaid", "Albirawi", "25062600", "zalbiraw@uwo.ca")));
		assertFalse(stud3.equals(new Student("Zaid", "Albirawi", "25062600", "zalbiraw@uwo.ca")));
		assertFalse(stud4.equals(new Student("Zaid", "Albirawi", "25062600", "zalbiraw@uwo.ca")));
	}

	@Test
	public void testToString()
	{
		assertTrue(stud0.toString().equals("\"Albirawi0\", \"Zaid0\", \"250626000\", \"zalbiraw0@uwo.ca\"\n"));
		assertTrue(stud1.toString().equals("\"Albirawi1\", \"Zaid1\", \"250626001\", \"zalbiraw1@uwo.ca\"\n"));
		assertTrue(stud2.toString().equals("\"Albirawi2\", \"Zaid2\", \"250626002\", \"zalbiraw2@uwo.ca\"\n"));
		assertTrue(stud3.toString().equals("\"Albirawi3\", \"Zaid3\", \"250626003\", \"zalbiraw3@uwo.ca\"\n"));
		assertTrue(stud4.toString().equals("\"Albirawi4\", \"Zaid4\", \"250626004\", \"zalbiraw4@uwo.ca\"\n"));
		
		assertFalse(stud0.toString().equals("\"Albirawi\", \"Zaid\", \"25062600\", \"zalbiraw@uwo.ca\"\n"));
		assertFalse(stud1.toString().equals("\"Albirawi\", \"Zaid\", \"25062600\", \"zalbiraw@uwo.ca\"\n"));
		assertFalse(stud2.toString().equals("\"Albirawi\", \"Zaid\", \"25062600\", \"zalbiraw@uwo.ca\"\n"));
		assertFalse(stud3.toString().equals("\"Albirawi\", \"Zaid\", \"25062600\", \"zalbiraw@uwo.ca\"\n"));
		assertFalse(stud4.toString().equals("\"Albirawi\", \"Zaid\", \"25062600\", \"zalbiraw@uwo.ca\"\n"));
	}
}
