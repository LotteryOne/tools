package com.tappe.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;


public class TestYlflDataChange {
	public static void main(String[] args) throws Exception {
		
		OrganExecute execute=new OrganExecute();
		execute.setWorkOnGradeRels("");
		execute.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		execute.setOrganName("≤‚ ‘ ˝æ›‘ı√¥");
		System.out.println(execute.getId());
		String url="http://localhost:8089/ylfl/dataChange.do?method=getOrgan";
		JSONObject obj = JSONObject.fromObject(execute);
		String receive=obj.toString();
		receive=URLEncoder.encode(receive, "GBK");
		receive="&data=["+receive+"]";
		System.out.println(receive);
		String res=receiveHttp(receive, url);
		System.out.println(res);
		
		
	}

	public static  String receiveHttp(String receive, String urlad) throws Exception {
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

}
