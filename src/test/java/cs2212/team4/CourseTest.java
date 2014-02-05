package cs2212.team4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CourseTest 
{
	private Course crs;
	
	@Before
	public void createCourse(){crs=new Course("title", "term", "code");}
	
	@Before
	public void addStudent()
	{
		crs.addStudent("Zaid", "Albirawi", 250626065, "zalbiraw1@uwo.ca");
		crs.addStudent("Zaid", "Albirawi", 250626066, "zalbiraw2@uwo.ca");
		crs.addStudent("Zaid", "Albirawi", 250626067, "zalbiraw3@uwo.ca");
		crs.addStudent("Zaid", "Albirawi", 250626068, "zalbiraw4@uwo.ca");
		crs.addStudent("Zaid", "Albirawi", 250626069, "zalbiraw5@uwo.ca");
	}
	
	@Before
	public void addDeliverable()
	{
		crs.addDeliverable("name1", "type1", 0.0);
		crs.addDeliverable("name2", "type2", 0.0);
		crs.addDeliverable("name3", "type3", 0.0);
		crs.addDeliverable("name4", "type4", 0.0);
		crs.addDeliverable("name5", "type5", 0.0);
	}

	@Test
	public void testGetTitle() {Assert.assertEquals ("title", crs.getTitle());}

	@Test
	public void testGetTerm() {Assert.assertEquals ("term", crs.getTerm());}

	@Test
	public void testGetCode() {Assert.assertEquals ("code", crs.getCode());}
	
	@Test
	public void testGetStudent() 
	{
		Assert.assertEquals (250626065, crs.getStudent(0).getNumber());
		Assert.assertEquals (250626066, crs.getStudent(1).getNumber());
		Assert.assertEquals (250626067, crs.getStudent(2).getNumber());
		Assert.assertEquals (250626068, crs.getStudent(3).getNumber());
		Assert.assertEquals (250626069, crs.getStudent(4).getNumber());
	}

	@Test
	public void testSetTitle() 
	{
		crs.setTitle("newTitle");
		Assert.assertEquals ("newTitle", crs.getTitle());
	}

	@Test
	public void testSetTerm()
	{
		crs.setTerm("newTerm");
		Assert.assertEquals ("newTerm", crs.getTerm());
	}

	@Test
	public void testSetCode() 
	{
		crs.setCode("newCode");
		Assert.assertEquals ("newCode", crs.getCode());
	}

	@Test
	public void testEditStudentNumber()
	{	
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(250626065)), 000000000));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(250626066)), 111111111));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(250626067)), 222222222));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(250626068)), 333333333));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(250626069)), 444444444));
		
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(000000000)), 000000000));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(111111111)), 111111111));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(222222222)), 222222222));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(333333333)), 333333333));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(444444444)), 444444444));
		
		Assert.assertEquals (false, crs.editStudentNumber(crs.getStudent(crs.findStudent(000000000)), 111111111));
		Assert.assertEquals (false, crs.editStudentNumber(crs.getStudent(crs.findStudent(111111111)), 222222222));
		Assert.assertEquals (false, crs.editStudentNumber(crs.getStudent(crs.findStudent(222222222)), 333333333));
		Assert.assertEquals (false, crs.editStudentNumber(crs.getStudent(crs.findStudent(333333333)), 444444444));
		Assert.assertEquals (false, crs.editStudentNumber(crs.getStudent(crs.findStudent(444444444)), 000000000));
		
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(000000000)), 250626065));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(111111111)), 250626066));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(222222222)), 250626067));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(333333333)), 250626068));
		Assert.assertEquals (true, crs.editStudentNumber(crs.getStudent(crs.findStudent(444444444)), 250626069));
	}

	@Test
	public void testEditStudentEmail() 
	{
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626065)), "zalbiraw1@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626066)), "zalbiraw2@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626067)), "zalbiraw3@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626068)), "zalbiraw4@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626069)), "zalbiraw5@uwo.ca"));
		
		Assert.assertEquals (false, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626065)), "zalbiraw2@uwo.ca"));
		Assert.assertEquals (false, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626066)), "zalbiraw3@uwo.ca"));
		Assert.assertEquals (false, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626067)), "zalbiraw4@uwo.ca"));
		Assert.assertEquals (false, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626068)), "zalbiraw5@uwo.ca"));
		Assert.assertEquals (false, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626069)), "zalbiraw1@uwo.ca"));
		
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626065)), "albiraw1@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626066)), "albiraw2@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626067)), "albiraw3@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626068)), "albiraw4@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626069)), "albiraw5@uwo.ca"));
		
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626065)), "zalbiraw1@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626066)), "zalbiraw2@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626067)), "zalbiraw3@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626068)), "zalbiraw4@uwo.ca"));
		Assert.assertEquals (true, crs.editStudentEmail(crs.getStudent(crs.findStudent(250626069)), "zalbiraw5@uwo.ca"));
	}

	@Test
	public void testFindStudent() 
	{
		Assert.assertEquals (0, crs.findStudent(250626065));
		Assert.assertEquals (1, crs.findStudent(250626066));
		Assert.assertEquals (2, crs.findStudent(250626067));
		Assert.assertEquals (3, crs.findStudent(250626068));
		Assert.assertEquals (4, crs.findStudent(250626069));
		
		Assert.assertNotEquals (10, crs.findStudent(250626065));
		Assert.assertNotEquals (11, crs.findStudent(250626066));
		Assert.assertNotEquals (12, crs.findStudent(250626067));
		Assert.assertNotEquals (13, crs.findStudent(250626068));
		Assert.assertNotEquals (14, crs.findStudent(250626069));
	}

	@Test
	public void testAddStudent() 
	{
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 250626065, "zalbiraw1@csd.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 250626066, "zalbiraw2@csd.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 250626067, "zalbiraw3@csd.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 250626068, "zalbiraw4@csd.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 250626069, "zalbiraw5@csd.ca"));
		
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 000000000, "zalbiraw1@uwo.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 111111111, "zalbiraw2@uwo.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 222222222, "zalbiraw3@uwo.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 333333333, "zalbiraw4@uwo.ca"));
		Assert.assertEquals (false, crs.addStudent("Zaid", "Albirawi", 444444444, "zalbiraw5@uwo.ca"));
		
		Assert.assertEquals (true, crs.addStudent("Zaid", "Albirawi", 000000000, "zalbiraw1@csd.ca"));
		Assert.assertEquals (true, crs.addStudent("Zaid", "Albirawi", 111111111, "zalbiraw2@csd.ca"));
		Assert.assertEquals (true, crs.addStudent("Zaid", "Albirawi", 222222222, "zalbiraw3@csd.ca"));
		Assert.assertEquals (true, crs.addStudent("Zaid", "Albirawi", 333333333, "zalbiraw4@csd.ca"));
		Assert.assertEquals (true, crs.addStudent("Zaid", "Albirawi", 444444444, "zalbiraw5@csd.ca"));
	}

	@Test
	public void testRemoveStudent()
	{
		Assert.assertEquals (true, crs.removeStudent(250626065));
		Assert.assertEquals (true, crs.removeStudent(250626066));
		Assert.assertEquals (true, crs.removeStudent(250626067));
		Assert.assertEquals (true, crs.removeStudent(250626068));
		Assert.assertEquals (true, crs.removeStudent(250626069));
		
		Assert.assertEquals (false, crs.removeStudent(250626065));
		Assert.assertEquals (false, crs.removeStudent(250626066));
		Assert.assertEquals (false, crs.removeStudent(250626067));
		Assert.assertEquals (false, crs.removeStudent(250626068));
		Assert.assertEquals (false, crs.removeStudent(250626069));
	}

	@Test
	public void testImportStudents() 
	{
		Assert.assertEquals (true, true);
	}

	@Test
	public void testExportStudents() {
		Assert.assertEquals (true, true);
	}

	@Test
	public void testFindDeliverable()
	{
		Assert.assertEquals (0, crs.findDeliverable("name1", "type1"));
		Assert.assertEquals (1, crs.findDeliverable("name2", "type2"));
		Assert.assertEquals (2, crs.findDeliverable("name3", "type3"));
		Assert.assertEquals (3, crs.findDeliverable("name4", "type4"));
		Assert.assertEquals (4, crs.findDeliverable("name5", "type5"));
		
		Assert.assertNotEquals (10, crs.findDeliverable("name1", "type1"));
		Assert.assertNotEquals (11, crs.findDeliverable("name2", "type2"));
		Assert.assertNotEquals (12, crs.findDeliverable("name3", "type3"));
		Assert.assertNotEquals (13, crs.findDeliverable("name4", "type4"));
		Assert.assertNotEquals (14, crs.findDeliverable("name5", "type5"));
	}

	@Test
	public void testAddDeliverable()
	{
		Assert.assertEquals (false, crs.addDeliverable("name1", "type1", 0.0));
		Assert.assertEquals (false, crs.addDeliverable("name2", "type2", 0.0));
		Assert.assertEquals (false, crs.addDeliverable("name3", "type3", 0.0));
		Assert.assertEquals (false, crs.addDeliverable("name4", "type4", 0.0));
		Assert.assertEquals (false, crs.addDeliverable("name5", "type5", 0.0));
		
		Assert.assertEquals (true, crs.addDeliverable("name11", "type11", 0.0));
		Assert.assertEquals (true, crs.addDeliverable("name12", "type12", 0.0));
		Assert.assertEquals (true, crs.addDeliverable("name13", "type13", 0.0));
		Assert.assertEquals (true, crs.addDeliverable("name14", "type14", 0.0));
		Assert.assertEquals (true, crs.addDeliverable("name15", "type15", 0.0));
	}

	@Test
	public void testRemoveDeliverable() 
	{
		Assert.assertEquals (true, crs.removeDeliverable("name1", "type1"));
		Assert.assertEquals (true, crs.removeDeliverable("name2", "type2"));
		Assert.assertEquals (true, crs.removeDeliverable("name3", "type3"));
		Assert.assertEquals (true, crs.removeDeliverable("name4", "type4"));
		Assert.assertEquals (true, crs.removeDeliverable("name5", "type5"));
		
		Assert.assertEquals (false, crs.removeDeliverable("name1", "type1"));
		Assert.assertEquals (false, crs.removeDeliverable("name2", "type2"));
		Assert.assertEquals (false, crs.removeDeliverable("name3", "type3"));
		Assert.assertEquals (false, crs.removeDeliverable("name4", "type4"));
		Assert.assertEquals (false, crs.removeDeliverable("name5", "type5"));
	}

	@Test
	public void testImportDeliverables() 
	{
		Assert.assertEquals (true, true);
	}

	@Test
	public void testExportDeliverables() 
	{
		Assert.assertEquals (true, true);
	}

	@Test
	public void testImportGrades() 
	{
		Assert.assertEquals (true, true);
	}

	@Test
	public void testExportGrades() 
	{
		Assert.assertEquals (true, true);
	}

}
