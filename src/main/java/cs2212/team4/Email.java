package cs2212.team4;

import java.io.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

public class Email {

	private static String msgSubject="", msg="";
	private static Properties properties;
	private static Student student;
	private static Course course;
	private static boolean boolReport=false;

	public Email(Properties properties){
		Email.properties = properties;
	}
	
	public Email(Course course, Student student, String msgSubject, String msg,
			boolean boolReport, Properties properties) {
		Email.msgSubject = msgSubject;
		Email.msg = msg;
		Email.student = student;
		Email.course = course;
		Email.boolReport = boolReport;
		Email.properties = properties;
	}

	public String sendEmail() {
		String returnMsg;

		Session session = getSession(properties);
		if (!(returnMsg = sendMessage(session, properties, student.getEmail()))
				.equals(""))
			return returnMsg;
		File reportFile = new File("gradebook-files/report.pdf");
		if (reportFile.exists())
			if (!reportFile.delete())
				return "Error, temprary file cannot be removed";
		return "";
	}

	public String authenUser() {
		Email.msgSubject = "Gradebook has authenticated your email";
		Email.msg = "Gradebook has authenticated your email address, and you are now ready to go!";
		Email.boolReport = false;
		String returnMsg;

		Session session = getSession(properties);
		if (!(returnMsg = sendMessage(session, properties, properties.getProperty("smtp.username")))
				.equals(""))
			return returnMsg;
		return "";
	}

	private static Session getSession(final Properties properties) {
		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						String username = properties
								.getProperty("smtp.username");
						String password = properties
								.getProperty("smtp.password");
						return new PasswordAuthentication(username, password);
					}
				});
		return session;
	}

	private static String sendMessage(Session session, Properties properties,
			String studentEmail) {
		try {
			String returnMsg;

			Message msg = new MimeMessage(session);
			String username = properties.getProperty("smtp.username");
			Address sender = new InternetAddress(username, username);

			msg.setFrom(sender);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					studentEmail));
			msg.setSubject(msgSubject);

			Multipart multiPart = new MimeMultipart();

			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(Email.msg);
			multiPart.addBodyPart(textPart);

			if (Email.boolReport) {
				returnMsg = generateReport();

				if (!returnMsg.equals(""))
					return returnMsg;

				MimeBodyPart fileAttachmentPart = new MimeBodyPart();
				File attachmentFile = new File(
						"gradebook-files/testFiles/report.pdf");
				if (!attachmentFile.exists())
					return "Not able to find the generated report";
				DataSource source = new FileDataSource(attachmentFile);
				fileAttachmentPart.setDataHandler(new DataHandler(source));
				fileAttachmentPart.setFileName("report.pdf");

				multiPart.addBodyPart(fileAttachmentPart);
			}
			msg.setContent(multiPart);
			Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
			return "Failed to create a new sender internet address";
		} catch (MessagingException e) {
			return "Failed to create a message";
		}
		return "";
	}

	private static String generateReport() {
		String returnMsg;
		Report report = new Report(course, student);
		if (!(returnMsg = report.generateReport()).equals(""))
			return returnMsg;
		return "";
	}
}
