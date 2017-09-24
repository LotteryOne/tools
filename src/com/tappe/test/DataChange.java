package com.tappe.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

public class DataChange {

	public boolean sendOrgan(String id) {
		if (id == null)
			return false;
		// OrganExecute execute = sa0101Vs.getExecuteById(id);
		// if (execute == null || execute.getId() == null)
		// return false;

		// JSONObject obj=JSONObject.fromObject(execute);
		// String receive=obj.toString();
		String receive = "";
		try {
			receive = URLEncoder.encode(receive, "GBK");
		} catch (UnsupportedEncodingException e1) {
		}
		receive = "&data=[" + receive + "]";
		// String
		// urlad="http://130.2.4.29:9080/ylfl/dataChange.do?method=getOrgan";
//		String urlad = "http://10.1.30.16/ylfl/dataChange.do?method=getOrgan";
		String urlad="http://10.1.30.16/ylfl/dataChange.do?method=getOrgan";
		try {
			String resutl = receiveHttp(receive, urlad);
			System.out.println(resutl);
		} catch (Exception e) {
			System.out.println(">>>>>>>dataChangeConnectionFaile");
			return false;
		}

		return true;
	}

	private String receiveHttp(String receive, String urlad) throws Exception {
		URL url = null;
		HttpURLConnection conn = null;
		String result = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			url = new URL(urlad);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestProperty("Charset", "GBK");
			conn.setReadTimeout(30000);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setRequestProperty("Accept-Charset", "GBK");
			conn.connect();
			os = conn.getOutputStream();

			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(receive);

			oos.flush();
			oos.close();
			is = conn.getInputStream();
			result = IOUtils.toString(is, "GBK");
			conn.disconnect();
		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}

			} catch (IOException e) {
			}
		}
		return result;
	}

	public String sendOrganString(String receive) {
		// if (id == null)
		// return false;
		// OrganExecute execute = sa0101Vs.getExecuteById(id);
		// if (execute == null || execute.getId() == null)
		// return false;

		// JSONObject obj=JSONObject.fromObject(execute);
		// String receive=obj.toString();
		// String receive="";
//		try {
//			receive = URLEncoder.encode(receive, "GBK");
//		} catch (UnsupportedEncodingException e1) {
//		}
//		receive = "&data=[" + receive + "]";
		// String
		// urlad="http://130.2.4.29:9080/ylfl/dataChange.do?method=getOrgan";
		String urlad = "http://130.2.4.29:9080/ylfl/dataChange.do?method=getOrgan";
		String resutl = "";
		try {
			resutl = receiveHttp(receive, urlad);
			System.out.println(">>>>>>"+receive);
			
		} catch (Exception e) {
			System.out.println(">>>>>>>dataChangeConnectionFaile");
			return "error";
		}

		return resutl;
	}
}
