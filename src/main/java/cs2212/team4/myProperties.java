package cs2212.team4;

import java.util.Properties;

public class myProperties {

	private Properties properties;

	public myProperties(String username, String password, int provider) {
		String mailHost="", socketPort="", port="";
		properties = new Properties();
		
		switch (provider){
		case 1:
			mailHost="";
			socketPort="";
			port="";
			break;
		case 2:
			mailHost="";
			socketPort="";
			port="";
			break;
		case 3:
			mailHost="";
			socketPort="";
			port="";
			break;
		case 4:
			mailHost="";
			socketPort="";
			port="";
			break;
		}
		properties.put("mail.smtp.host", mailHost);
		properties.put("mail.smtp.socketFactory.port", socketPort);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", port);
		properties.put("smtp.username", username);
		properties.put("smtp.password", password);
	}
	
	public myProperties(String mailHost, String socketPort, String port,
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
