package cs2212.team4;

import java.io.*;
import javax.activation.*;
import java.net.URL;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.NumberTool;

/**
*
* Email is the class that will send emails to students containing their reports
*
* team4-gradebook application
*
* @author Justin Cheng
*/

public class Email {
	
	/**
	 * Email Constructor, no attributes
	 */
	public Email(){
		
	}
	
	/**
	 * Sends email to each student contained in studentList
	 * 
	 * @param studentList the list of students to send emails to
	 */
	public void send( Student[] studentList ) throws Exception{
		
	    Properties properties = loadProperties();
		Session session = getSession(properties);	// obtain a mail session object
		sendMessage(session, properties, studentList);		// sends message (takes a session object and array of recipient email addresses passed as arguments
	}
	
 /**
  *	getSession method helps obtain a mail session object
  *
  * @param properties contains details of the SMTP server
  */
  private static Session getSession(final Properties properties) {

    Session session = Session.getInstance(properties ,				//instantiate a new mail session, passing in the properties parameter to Session.getInstance
		new javax.mail.Authenticator() {							// instantiate and pass an Authenticator, which is used to pass a username and password to the
			protected PasswordAuthentication getPasswordAuthentication() {	// SMTP server to authenticate with it
				String username = properties.getProperty("smtp.username");
				String password = properties.getProperty("smtp.password");
				return new PasswordAuthentication(username , password);
			}
		}
	);
	return session;
  }

  /**
  * sendMessage method sends template message to specified recipients
  *
  * @param session contains details of the SMTP server so message knows how to be sent
  * 
  * @param properties contains details of sender of emails
  * 
  * @param recipients contains emails of receivers of email
  * 
  */
  private static void sendMessage(Session session, Properties properties, Student[] studentList ) throws
	Exception {
	Message msg = new MimeMessage(session);							// Instantiate mime message object, initialize with session object so
																	// that the message effectively knows exactly how it is to be sent (details of SMTP server)
	String senderName = properties.getProperty("sender.name");		// get sender name
	String senderEmail = properties.getProperty("sender.email");	// get sender email
	
	Address sender = new InternetAddress(senderEmail, senderName);	// sender object represents sender of the email
	msg.setFrom(sender);											// set "From" attribute in message as sender
	
	for ( int i = 0; i < studentList.length ; i++ ){
		msg.setRecipient( Message.RecipientType.TO, new InternetAddress(studentList[i].getEmail()) );
		
		msg.setSubject(properties.getProperty("message.subject"));						// set message's subject
		
		Multipart multiPart = new MimeMultipart();										// instantiate a new multipart object
		
		MimeBodyPart textPart = new MimeBodyPart();										// create mimebodypart object first with template plaintext version of email
		textPart.setText(loadTemplate("email.text.vm"), "utf-8");
		
		MimeBodyPart htmlPart = new MimeBodyPart();										// create another mimebodypart object with template html version of email
		htmlPart.setContent(loadTemplate("email.html.vm"), "text/html; charset=utf-8");
		
		//MimeBodyPart fileAttachmentPart = new MimeBodyPart();									// create another mimebodypart object for the attachment
		//URL attachmentUrl = Report.class.getClassLoader().getResource(studentList[i].getNameFirst()+getNameLast() + ".pdf");	// obtain the URL of the reports to attach from the JAR file
		//DataSource source = new URLDataSource(attachmentUrl);									// instantiate Datasource object from the URL
		//fileAttachmentPart.setDataHandler(new DataHandler(source));								// read the data from the logo file stored in the JAR and store in attachment body part

		//fileAttachmentPart.setFileName( studentList[i].getNameLast() + " Report.pdf");
		
		multiPart.addBodyPart(textPart);														// add text body part to multipart object
		multiPart.addBodyPart(htmlPart);														// add html body part to multipart object
		//multiPart.addBodyPart(fileAttachmentPart);												// add attachment part to multipart object
		
		msg.setContent(multiPart);																// set the content of the message to be the multiPart object
		
		Transport.send(msg);																	// send message using this method

	}
	
  }
  
  /**
  * loadProperties returns properties from properties file containing details of sender
  * 
  * @return properties object with details of sender
  */  
  private static Properties loadProperties() throws Exception {

	Properties properties = new Properties();
	InputStream stream = Report.class.getClassLoader().getResourceAsStream("mail.properties");
	properties.load(stream);
	
	return properties;
  }
  
  /**
  * Takes the name of the file in which the template is stored
  * 
  * @param filename contains template message
  * 
  */
  private static String loadTemplate(String filename) {

	VelocityEngine ve = new VelocityEngine();	// instantiate a VelocityEngine object to load and render the template.
	ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

	Template template = ve.getTemplate(filename);

	VelocityContext context = new VelocityContext();
	context.put("studentName", "A variable containing a student name");
	context.put("professor", "A variable containing the professor's name");

	StringWriter out = new StringWriter();
	template.merge(context, out);

	return out.toString();
  }

}