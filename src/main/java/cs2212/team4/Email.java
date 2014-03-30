package cs2212.team4;

import java.io.*;
import java.net.URL;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Email {

	static String msgSubject;
	static Properties properties;
	static String msg;
	static Student student;
	static Course course;
	static boolean boolReport;

	public Email(Course course, Student student, String msgSubject, String msg,
			boolean boolReport) {
		Email.msgSubject = msgSubject;
		Email.msg = msg;
		Email.student = student;
		Email.course = course;
		Email.boolReport = boolReport;
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

	private static String loadProperties() {
		Properties properties = new Properties();
		try {
			InputStream stream = GradebookGUI.class.getClassLoader()
					.getResourceAsStream("cs2212/team4/mail.properties");
			if (stream == null)
				return "Fail to import mail.properties";
			properties.load(stream);
		} catch (IOException e) {
			return "Fail to import mail.properties";
		}
		Email.properties = properties;
		return "";
	}

	private static String sendMessage(Session session, Properties properties,
			String studentEmail) {
		try {
			String returnMsg;

			Message msg = new MimeMessage(session);
			String senderName = properties.getProperty("sender.name");
			String senderEmail = properties.getProperty("sender.email");

			Address sender;
			sender = new InternetAddress(senderEmail, senderName);

			msg.setFrom(sender);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					studentEmail));
			msg.setSubject(msgSubject);

			Multipart multiPart = new MimeMultipart();

			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(Email.msg);
			multiPart.addBodyPart(textPart);
			
			if (Email.boolReport){
				returnMsg = generateReport();
				
				if (!returnMsg.equals(""))
					return returnMsg;

				MimeBodyPart fileAttachmentPart = new MimeBodyPart();
				URL attachmentUrl = GradebookGUI.class.getClassLoader()
						.getResource("cs2212/team4/report.pdf");
				if (attachmentUrl == null)
					return "Failed a generate an attachment url";
				DataSource source = new URLDataSource(attachmentUrl);
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

	public String sendEmail() {
		String returnMsg;
		Properties properties;

		if (!(returnMsg = loadProperties()).equals(""))
			return returnMsg;
		properties = Email.properties;
		Session session = getSession(properties);
		if (!(returnMsg = sendMessage(session, properties, student.getEmail()))
				.equals(""))
			return returnMsg;
		return "";
	}
}
