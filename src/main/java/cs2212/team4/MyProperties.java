package cs2212.team4;

import java.util.Properties;

public class MyProperties {

	private Properties properties;

	public MyProperties(String username, String password, String provider) {
		properties = new Properties();
		
		switch (provider){
		case "gmail":
			properties.put("mail.smtp.host", "smtp.gmail.com");
			break;
		case "yahoo":
			properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
			break;
		case "hotmail":
			properties.put("mail.smtp.host", "smtp.live.com");
			break;
		}
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("smtp.username", username);
		properties.put("smtp.password", password);
	}
	
	public MyProperties(String mailHost, String socketPort, String port,
			String username, String password) {
		properties = new Properties();

		properties.put("mail.smtp.host", mailHost);
		properties.put("mail.smtp.socketFactory.port", socketPort);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.port", port);
		properties.put("smtp.username", username);
		properties.put("smtp.password", password);
	}

	public Properties getProperties() {
		return properties;
	}
}
