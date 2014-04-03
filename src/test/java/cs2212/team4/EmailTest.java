package cs2212.team4;

import java.util.*;
import org.junit.Test;
import org.junit.Before;
import junit.framework.Assert;

public class EmailTest {
	
	
	Course course1, course2;
	Email email1, email2;
	Properties prop1, prop2;
	String username, password;

	
	@Before
	public void testEmail ()
	{
		course1 = new Course( "Classical Racism 101", "A", "2304");
		course1.addStudent("Ted", "Mosby", "250565432", "tedmosby@uwo.ca");
		username = new String("professor@prof.com");
		password = new String("professa123");
		prop1 = new Properties();
		
		
		prop1.put("mail.smtp.host", "smtp.gmail.com");
		prop1.put("mail.smtp.auth", "true");
		prop1.put("mail.smtp.starttls.enable", "true");
		prop1.put("mail.smtp.port", "587");
		prop1.put("smtp.username", username);
		prop1.put("smtp.password", password);
		
		email1 = new Email( prop1);
		email2 = new Email( course1, course1.getStudent(0), "Ted Mosby's Grades", "Here are your grades good sir", false, prop1);
		
	}
	
	@Test
	public void testSendEmail ()
	{
		//System.out.println( "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE " + email2.sendEmail() );
		//Assert.assertSame( "", email2.sendEmail() );
		// if return message is not equal to "", return message
		// 
		
		
	}
	
	@Test
	public void testAuthenUser ()
	{
		//System.out.println( "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX " + email2.authenUser() );
	}
	
	@Test
	public void testGetSession ()
	{
	
	}
	
	@Test
	public void testSendMessage ()
	{
	
	}
	
	@Test
	public void testGenerateReports ()
	{
	
	}
}