package cs2212.team4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseTest 
{
	Course crs, crs0, crs1, crs2, crs3, crs4, crs5, crs6, crs7, crs8, crs9;
	Student stud;
	Deliverable deliver;
	
	@Before
	public void testCourse()
	{
		crs=new Course("Title", "Term", "Code");
		crs0=new Course("Computer Science", "A", "2208");
		crs1=new Course("Computer Science", "A", "2210");
		crs2=new Course("Computer Science", "A", "2211");
		crs3=new Course("Computer Science", "A", "2214");
		crs4=new Course("Statistical Sciences", "A", "2244");
		crs5=new Course("Computer Science", "B", "2209");
		crs6=new Course("Computer Science", "B", "2212");
		crs7=new Course("Computer Science", "B", "3340");
		crs8=new Course("Computer Science", "B", "3342");
		crs9=new Course("Writing", "G", "2207");
		
		crs.addStudent("Zaid", "Albirawi", "250626000", "zalbiraw");
		stud=new Student("Zaid", "Albirawi", "250626000", "zalbiraw");
		
		crs.addDeliverable("Project", "Other", 54);
		deliver=new Deliverable("Project", "Other", 54, 0);
		
		crs.getStudent(0).addGrade(0, 100, "Other", 54);
	}

	@Test
	public void testGetTitle()
	{
		Assert.assertTrue(crs0.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs1.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs2.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs3.getTitle().equals("Computer Science"));
		Assert.assertFalse(crs4.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs5.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs6.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs7.getTitle().equals("Computer Science"));
		Assert.assertTrue(crs8.getTitle().equals("Computer Science"));
		Assert.assertFalse(crs9.getTitle().equals("Computer Science"));
	}

	@Test
	public void testGetTerm()
	{
		Assert.assertTrue(crs0.getTerm().equals("A"));
		Assert.assertTrue(crs1.getTerm().equals("A"));
		Assert.assertTrue(crs2.getTerm().equals("A"));
		Assert.assertTrue(crs3.getTerm().equals("A"));
		Assert.assertTrue(crs4.getTerm().equals("A"));
		
		Assert.assertFalse(crs5.getTerm().equals("A"));
		Assert.assertFalse(crs6.getTerm().equals("A"));
		Assert.assertFalse(crs7.getTerm().equals("A"));
		Assert.assertFalse(crs8.getTerm().equals("A"));
		Assert.assertFalse(crs9.getTerm().equals("A"));
	}

	@Test
	public void testGetCode()
	{
		Assert.assertTrue(crs0.getCode().equals("2208"));
		Assert.assertTrue(crs1.getCode().equals("2210"));
		Assert.assertTrue(crs2.getCode().equals("2211"));
		Assert.assertTrue(crs3.getCode().equals("2214"));
		Assert.assertTrue(crs4.getCode().equals("2244"));
		
		Assert.assertFalse(crs5.getCode().equals("2208"));
		Assert.assertFalse(crs6.getCode().equals("2210"));
		Assert.assertFalse(crs7.getCode().equals("2211"));
		Assert.assertFalse(crs8.getCode().equals("2214"));
		Assert.assertFalse(crs9.getCode().equals("2244"));
	}

	@Test
	public void testGetStudent()
	{
		Assert.assertTrue(crs.getStudent(1)==null);
		Assert.assertTrue(crs.getStudent(0).equals(stud));
	}

	@Test
	public void testGetDeliverable()
	{
		Assert.assertTrue(crs.getDeliverable(1)==null);
		Assert.assertTrue(crs.getDeliverable(0).equals(deliver));
	}

	@Test
	public void testGetGrade()
	{
		Assert.assertTrue(crs.getGrade(crs.getStudent(0), 1)==-1);
		Assert.assertTrue(crs.getGrade(crs.getStudent(0), 0)==100);
	}

	@Test
	public void testSetTitle()
	{
		
	}

	@Test
	public void testSetTerm() {

	}

	@Test
	public void testSetCode() {

	}

	@Test
	public void testEditStudentNumber() {

	}

	@Test
	public void testEditStudentEmail() {
	
	}

	@Test
	public void testFindStudent() {
	
	}

	@Test
	public void testAddStudent() {
		
	}

	@Test
	public void testRemoveStudent() {
		
	}

	@Test
	public void testFindDeliverable() {
		
	}

	@Test
	public void testAddDeliverable() {
	
	}

	@Test
	public void testRemoveDeliverable() {
		
	}

	@Test
	public void testAddGrade() {
		
	}

	@Test
	public void testRemoveGrade() {
		
	}

	@Test
	public void testImportStudents() {
		
	}

	@Test
	public void testExportStudents() {
		
	}

	@Test
	public void testImportDeliverables() {
		
	}

	@Test
	public void testExportDeliverables() {
		
	}

	@Test
	public void testImportGrades() {
		
	}

	@Test
	public void testExportGrades() {
		
	}

	@Test
	public void testEqualsCourse() {
		
	}

	@Test
	public void testToString() {
		
	}
}
