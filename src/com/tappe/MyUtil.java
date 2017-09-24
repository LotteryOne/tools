package com.tappe;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.namespace.QName;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class MyUtil {

	// webservice
	public static  String receive(String receive, String method, String urlad,
			String urlname) throws Exception {
		Service service = new Service();
		Call call = null;
		call = (Call) service.createCall();
//		call.setTimeout(1000 * 15);
		 
		call.setTargetEndpointAddress(new java.net.URL(urlad));
		call.setOperationName(new QName(urlname, method));
		String ret = "";
		ret = (String) call.invoke(new Object[] { receive });
		return ret;
	}

	// http post
	public String receiveHttp(String receive, String urlad) throws Exception {
		URL url = null;
		HttpURLConnection conn = null;
		String result = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			url = new URL(urlad);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setReadTimeout(30000);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.connect();
			os = conn.getOutputStream();

			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(receive);

			oos.flush();
			oos.close();
			is = conn.getInputStream();
			result = IOUtils.toString(is, "UTF-8");
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

	public static List getBeanListFromJsonData(String data, Class beanClass) {

		JSONArray jsonArray = JSONArray.fromObject(data);
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpher(new String[] { "yyyy-MM-dd" }));
		List list = new ArrayList(jsonArray.size());
		for (Iterator iter = jsonArray.iterator(); iter.hasNext();) {
			JSONObject jsonObject = (JSONObject) iter.next();
			list.add(JSONObject.toBean(jsonObject, beanClass));
		}
		return list;
	}

	public static void connectionJdbc() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.1.35.19:1521:orcl";

		String user = "mzyljg";
		String password = "mzyljg";
		String organId = "0281a0a3298735ff0129c9a097b11111";
		Connection conn = null;
		CallableStatement cst = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			String procedure = "{call updateOrganById(?)}";
			cst = conn.prepareCall(procedure);
			cst.setString(1, organId);
			boolean f = cst.execute();
			System.out.println(f);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cst != null)
				cst.close();
			if (conn != null)
				conn.close();
		}
	}

	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static Object invokeXml(String ret, Object obj) throws Exception {
		if (obj == null)
			return null;
		if (ret == null || "".equals(ret))
			return null;
		Class<? extends Object> clss = obj.getClass();
		Document doc = DocumentHelper.parseText(ret);
		Field[] fie = clss.getDeclaredFields();
		Element root = doc.getRootElement();
		for (Field field : fie) {
			String name = field.getName();
			String result = trimEmptyOrNull(root.element(name).getTextTrim());
			name = "set" + name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			Class<?> type = field.getType();

			if (type.isAssignableFrom(Date.class)) {
				Date re = sdf.parse(result);
				clss.getMethod(name, Date.class).invoke(obj, re);
			} else if (type.isAssignableFrom(java.sql.Date.class)) {
				Date re = sdf.parse(result);
				clss.getMethod(name, Date.class).invoke(obj, re);
			} else if (type.isAssignableFrom(Double.class)) {
				double re = Double.parseDouble(result);
				clss.getMethod(name, Double.class).invoke(obj, re);
			} else if (type.isAssignableFrom(Integer.class)) {
				int re = Integer.parseInt(result);
				clss.getMethod(name, Integer.class).invoke(obj, re);
			} else {
				clss.getMethod(name, String.class).invoke(obj, result);
			}
		}
		return obj;
	}

	private static String trimEmptyOrNull(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return "";
		} else {
			return str;
		}
	}

	public static String getNewId15(String id) {
		String newid;
		newid = id;
		newid = newid.substring(0, 6) + newid.substring(8, 17);
		return newid;
	}

	public String getNewId18(String id) {
		if (id != null && id.length() == 15) {
			int w[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
			String A[] = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3",
					"2" };
			int i, j, s = 0;
			String newid;
			newid = id;
			newid = newid.substring(0, 6) + "19"
					+ newid.substring(6, id.length());
			for (i = 0; i < newid.length(); i++) {
				j = Integer.parseInt(newid.substring(i, i + 1)) * w[i];
				s = s + j;
			}
			s = s % 11;
			newid = newid + A[s];
			return newid;
		} else {
			return id;
		}
	}

	public void getListElementByXml() throws DocumentException {
		String xml = "<xqpg><data><idcard>12312</idcard><name>����</name></data><data><idcard>454545</idcard><name>����111</name></data></xqpg>";
		Document doc = DocumentHelper.parseText(xml);
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements("data");
		for (Object object : list) {
			Element e = (Element) object;
			String re = e.elementTextTrim("idcard");
			String name = e.elementTextTrim("name");
			System.out.println(re + "::::>>" + name);
		}
	}
	
	
	
	/// i can`t read  what i write ####
	
	private Pattern pattern = Pattern.compile("\\&\\#(\\d+)");
	
	public String tr(String str) {
		if (str == null)
			return "";
		Matcher m = pattern.matcher(str);
		String regex = "&#[0-9]{5};";
		while (m.find()) {
			char tempc = (char) Integer.valueOf(m.group(1)).intValue();
			String te = String.valueOf(tempc);
			String s = str.replaceFirst(regex, te);
			str = s;
		}
		return str;
	}
	
	
	
		private static final String ALGORITHM = "DES/ECB/PKCS5Padding";
	  private static byte[] encrypt(byte[] data, String key) throws Exception {   
	        Key k = toKey(key.getBytes("UTF8"));  
	        //IvParameterSpec iv = new IvParameterSpec(key.getBytes("GBK"));
	        Cipher cipher = Cipher.getInstance(ALGORITHM);   
	        cipher.init(Cipher.ENCRYPT_MODE, k);   
	  
	        return cipher.doFinal(data);   
	    }   
	
	  /**  
	     * 转换密钥 
	     * @param key  密钥
	     * @return  Key对象
	     * @throws Exception  
	     */  
	    private static Key toKey(byte[] key) throws Exception {   
	        DESKeySpec dks = new DESKeySpec(key);   
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");   
	        SecretKey secretKey = keyFactory.generateSecret(dks);    
	        return secretKey;   
	    }   
	    
	    
	    private static byte[] decrypt(byte[] data, String key) throws Exception {   
	        Key k = toKey(key.getBytes());   
	        //IvParameterSpec iv = new IvParameterSpec(key.getBytes("GBK"));
	        Cipher cipher = Cipher.getInstance(ALGORITHM);   
	        cipher.init(Cipher.DECRYPT_MODE, k);   
	  
	        return cipher.doFinal(data);   
	    }   
	  
	
	
}
