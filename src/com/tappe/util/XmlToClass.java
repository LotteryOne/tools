package com.tappe.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlToClass {

	public static void main(String[] args) {

		User user = (User) xmlToObj("<xqpg><name>12312</name></xqpg>",
				User.class);

		System.out.println(user.getName());
	}

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

}
