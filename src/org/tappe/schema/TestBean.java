package org.tappe.schema;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class TestBean {
public static void main(String[] args) {
	ClassPathXmlApplicationContext cxa=new ClassPathXmlApplicationContext("applicationContext.xml");
	User user=(User) cxa.getBean("tom");
	System.out.println(user.getEmail());
	cxa.close();
}
}
