package com.tappe.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;

public class XmlDealUtil {
	/**
	 * xml 转 对象
	 * 
	 * @param xml
	 * @param class
	 * @return object
	 */
	public static Object xmlToObj(String xml, Class<?> type) {
		Object obj = null;

		try {
			obj = type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			Field[] fie = type.getDeclaredFields();
			for (int i = 0; i < fie.length; i++) {
				String name = fie[i].getName();
				Element ele = root.element(name);
				String text = ele.getText();
				name = "set" + name.substring(0, 1).toUpperCase()
						+ name.substring(1);
				try {
					type.getMethod(name, fie[i].getType()).invoke(obj, text);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 对象 转 xml
	 * 
	 * @param obj
	 * @return xml
	 */
	public static String objToXml(Object obj) {

		Class<? extends Object> type = obj.getClass();
		Field[] fields = type.getDeclaredFields();
		String left = "<";
		String right = ">";
		StringBuffer bf = new StringBuffer();
		String root = type.getName().substring(
				type.getName().lastIndexOf(".") + 1);
		bf.append(left + root + right);
		for (Field field : fields) {
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						type);
				Method getMethod = pd.getReadMethod();// 获得get方法
				Object o = getMethod.invoke(obj);
				bf.append(left + field.getName() + right);
				if (o != null)
					bf.append(o==null?"":o.toString());
				bf.append(left + "/" + field.getName()+ right);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bf.append(left + "/" + root + right);
		return bf.toString();
	}

	public static void main(String[] args) {

		User user = new User();
		user.setName("aasdddd");
		
		User uc = new User();
		uc.setName("ucuccucu");

//		List<User> list = new ArrayList<User>();
//		list.add(user);
//		list.add(uc);
//		List<Map<String, Object>> map = getMapList(list);
//		System.out.println(JSONArray.fromObject(map).toString());
		System.out.println(objToXml(uc));
	}

	public static void test(Class<?> type) {
		Field[] fields = type.getDeclaredFields();
		for (Field field : fields) {
			PropertyDescriptor pd;
			try {
				pd = new PropertyDescriptor(field.getName(), type);
				MethodParameter parm = BeanUtils.getWriteMethodParameter(pd);
				Method method = parm.getMethod();
				// 根据 type 处理
				System.out.println(method.getParameterTypes()[0].getName());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static List<Map<String, Object>> getMapList(List list) {
		if (list == null)
			return null;
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		if (list.size() > 0) {
			Object content = list.get(0);
			Field[] fields = content.getClass().getDeclaredFields();
			for (Object obj : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (Field field : fields) {
					try {

						PropertyDescriptor pd = new PropertyDescriptor(
								field.getName(), obj.getClass());
						Method getMethod = pd.getReadMethod();// 获得get方法
						Object o = getMethod.invoke(obj);
						map.put(field.getName(), o);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				mapList.add(map);
			}
		}
		return mapList;
	}

}
