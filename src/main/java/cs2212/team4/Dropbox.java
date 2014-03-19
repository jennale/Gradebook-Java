package cs2212.team4;

import com.dropbox.core.*;

import java.io.*;
import java.util.Locale;

public class Dropbox {
	private DbxClient client;
	private DbxAppInfo appInfo;
	private DbxRequestConfig config;
	private DbxWebAuthNoRedirect webAuth;
	private String authorizeUrl;

	public Dropbox() {
		final String APP_KEY = "ch7qua6ztawqz1j";
		final String APP_SECRET = "x7kd39n4ph965yh";

		appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
		config = new DbxRequestConfig("gradebook-team4", Locale.getDefault()
				.toString());
		webAuth = new DbxWebAuthNoRedirect(config, appInfo);
	}

	public String getAuthorizeUrl() {
		authorizeUrl = webAuth.start();
		return this.authorizeUrl;
	}

	public boolean authenticate(String code) {
		DbxAuthFinish authFinish;
		try {
			authFinish = webAuth.finish(code);
		} catch (DbxException e) {
			return false;
		}
		String accessToken = authFinish.accessToken;
		this.client = new DbxClient(config, accessToken);
		return true;
	}

	public boolean upload() {
		File dataFile = new File("data.dat");
		try {
			InputStream IS = new FileInputStream(dataFile);
			DbxEntry.File uploadedFile = client.uploadFile(
					"/gradebook/data.dat", DbxWriteMode.add(),
					dataFile.length(), IS);
			if (uploadedFile != null) {
				IS.close();
				return true;
			} else {
				IS.close();
				return false;
			}
		} catch (DbxException e) {
			System.out.println(e);return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean download() {
		try {
			OutputStream OS = new FileOutputStream("data.dat");
			DbxEntry.File downloadedFile = client.getFile(
					"/gradebook/data.dat", null, OS);
			if (downloadedFile != null) {
				OS.close();
				return true;
			} else {
				OS.close();
				return false;
			}
		} catch (DbxException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
}
