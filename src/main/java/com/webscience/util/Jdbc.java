package com.webscience.util;

import java.util.ResourceBundle;

public class Jdbc {

	private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	
	public static String getProperty(String key) {
		return bundle.getString(key);
	}

	public static String getDataname() throws Exception {
		String e_username = getProperty("jdbc.username");
		String username = DESUtil.decrypt(e_username, DESUtil.key);
		return username;
	}
	
	public static String getDatapass() throws Exception {
		String e_password = getProperty("jdbc.password");
		String password = DESUtil.decrypt(e_password, DESUtil.key);
		return password;
	}
	
	public static String getUrl() throws Exception {
		String e_url = getProperty("jdbc.url");
		String url = DESUtil.decrypt(e_url, DESUtil.key);
		return url;
	}

}
