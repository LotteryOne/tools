package test.bt;

import org.junit.Test;

import test.builder.ClassFileCreater;

public class TestBuilder {
	
	 @Test
	public void testCreate(){
		ClassFileCreater cfc=new ClassFileCreater();
		String name="alpha";
		cfc.createModule(name);
		
	}
	//@Test
	public void testString(){
		String name="alpha";
		
		String className=name.substring(0, 1).toUpperCase()+name.substring(1);
		System.out.println(className);
	}
}
