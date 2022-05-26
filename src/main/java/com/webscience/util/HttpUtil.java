package com.webscience.util;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.webscience.json.ws_a_cugb_dept_detail;

public class HttpUtil {
	static String pathName = "G:\\publicKey.txt";

	public static String getSerchPersion(String url, String param) {
		HttpClient httpClient = new HttpClient();

		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(5000);

		GetMethod getMethod = new GetMethod(url);

		getMethod.getParams().setParameter("http.socket.timeout",
				Integer.valueOf(5000));

		getMethod.getParams().setParameter("http.method.retry-handler",
				new DefaultHttpMethodRetryHandler());
		String response = "";
		try {
			int statusCode = httpClient.executeMethod(getMethod);

			if (statusCode != 200) {
				System.err.println("请求出错: " + getMethod.getStatusLine());
			}

			Header[] headers = getMethod.getResponseHeaders();
			for (Header h : headers) {
				System.out
						.println(h.getName() + "------------ " + h.getValue());
			}
			byte[] responseBody = getMethod.getResponseBody();
			response = new String(responseBody, param);
			System.out.println("----------response:" + response);
		} catch (HttpException e) {
			System.out.println("请检查输入的URL!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("发生网络异常!");
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return response;
	}

	public static JSONObject doPost(String url, JSONObject json, String charset) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json;charset=" + charset);
		JSONObject response = null;
		try {
			StringEntity s = new StringEntity(json.toString(), charset);
			s.setContentEncoding(new BasicHeader("Content-Type",
					"application/json"));
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(res.getEntity());
				response = JSONObject.fromObject(result);
				System.out.println("----------response:" + response.toString());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static JSONObject doPost(String url, JSONArray json, String charset) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		JSONObject response = null;
		try {
			StringEntity s = new StringEntity(json.toString());
			s.setContentEncoding(charset);
			s.setContentType("application/json");
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(res.getEntity());
				response = JSONObject.fromObject(result);
				System.out.println("----------response:" + response.toString());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static JSONObject doPost(String url, String encryptByPublicKey,
			String charset) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		JSONObject response = null;
		try {
			StringEntity s = new StringEntity(encryptByPublicKey);
			s.setContentEncoding(charset);
			s.setContentType("application/json");
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(res.getEntity());
				response = JSONObject.fromObject(result);
				System.out.println("----------response:" + response.toString());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static String doPostByXML(String url, String encryptByPublicKey,
			String charset) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		String result = "";
		try {
			StringEntity s = new StringEntity(encryptByPublicKey);
			s.setContentEncoding(charset);
			s.setContentType("text/xml");
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == 200) {
				result = new String(EntityUtils.toString(res.getEntity())
						.getBytes("ISO-8859-1"), "UTF8");
				System.out.println("----------response:" + result);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public static void main(String[] arg) throws Exception {
//		 String url = "http://127.0.0.1:8080/webscience/kjcQuery.do";
//		 String url = "http://39.103.222.205:8080/webscience/kjcQuery.do";
		 ws_a_cugb_dept_detail dept = new ws_a_cugb_dept_detail();
//		 dept.setCurPage("1");
//		 dept.setPerPage("10");
//		 dept.setFlagCode("paper");
//		 dept.setDeptCode("30100");
//		 dept.setTypeCode("null");
//		 dept.setYear("2012~2017");
//		 JSONObject reObject = JSONObject.fromObject(dept);
//		 System.out.println("----------request:" + reObject.toString());
//		 doPost(url, reObject.toString(), "UTF-8");
		 
		 String url = "http://127.0.0.1:8080/webscience/kjcQueryList.do";
		 dept.setFlagCode("paper");
		 dept.setTypeCode("null");
		 dept.setYear("2012~2017");
		 JSONObject reObject = JSONObject.fromObject(dept);
		 System.out.println("----------request:" + reObject.toString());
		 doPost(url, reObject.toString(), "UTF-8");
	}
}