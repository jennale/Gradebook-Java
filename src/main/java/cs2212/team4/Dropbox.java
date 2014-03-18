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
		this.config = new DbxRequestConfig("gradebook-team4", Locale
				.getDefault().toString());
		this.webAuth = new DbxWebAuthNoRedirect(config, appInfo);
	}

	public String getAuthorizeUrl() {
		return this.authorizeUrl;
	}

	public boolean authenticate(String code) {
		DbxAuthFinish authFinish;
		this.authorizeUrl = webAuth.start();
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
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
					dataFile));
			DbxEntry.File uploadedFile = client.uploadFile(
					"/gradebook/data.dat", DbxWriteMode.add(),
					dataFile.length(), OIS);
			if (uploadedFile != null) {
				OIS.close();
				return true;
			} else {
				OIS.close();
				return false;
			}
		} catch (DbxException e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean download() {
		try {
			ObjectOutputStream OUS = new ObjectOutputStream(
					new FileOutputStream("data.dat"));
			DbxEntry.File downloadedFile = client.getFile(
					"/gradebook/data.dat", null, OUS);
			if (downloadedFile != null) {
				OUS.close();
				return true;
			}
			else {
				OUS.close();
				return false;
			}
		} catch (DbxException e){
			return false;
		} catch (IOException e) {
			return false;
		}
	}
}
