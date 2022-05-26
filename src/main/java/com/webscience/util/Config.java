package com.webscience.util;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class Config {
	private static ResourceBundle bundle = ResourceBundle.getBundle("configs");

	public static String getProperty(String key) {
		return bundle.getString(key);
	}

	public static String getCharset() {
		return getProperty("charset");
	}

	public static int getPerPage() {
		return Integer.parseInt(getProperty("perPage"));
	}

	public static int getPerLogsNum() {
		return Integer.parseInt(getProperty("perLogsNum"));
	}

	public static String getVersion() {
		return getProperty("version");
	}
	
	public static String getTitle(){
		String result = "null";
		try {
			result = new String(getProperty("title").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getDesKey() {
		return getProperty("deskey");
	}
	
	public static String getFilePath() {
		return getProperty("filePath");
	}
	
	public static String getPageLogsNum() {
		return getProperty("pageLogsNum");
	}
	
	public static String getIp() {
		return getProperty("ip");
	}
	
	public static String getPort() {
		return getProperty("port");
	}
}
