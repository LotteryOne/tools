package com.tappe.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestOlderExit {
	public static void main(String[] args) {
//			t1();
			t2();
		
	}

	
	
	public static void t1(){
		String name = "";
		try {

			String urlName = "http://localhost:8080/xqpg/services/ExportDataCollectorService?wsdl";
			Service s = new Service();
			
			Call call = (Call) s.createCall();
			call.setTimeout(new Integer(10000));
			call.setTargetEndpointAddress(new URL(urlName));
			call.setOperationName(new QName(
					"http://localhost:8080/xqpg/services/ExportDataCollectorService",
					"olderExist"));

			String xml = "<xqpg><idcard>310221192502055218</idcard></xqpg>";

			name = (String) call.invoke(new Object[] { xml });
			System.out.println(name);
		} catch (Exception e) {
			name = e.getMessage();
		}
	}
	
	
	public static void t2(){
		String name = "";
		try {

			String urlName = "http://localhost:8080/syljg/services/olderInfoGis?wsdl";
			Service s = new Service();
			
			Call call = (Call) s.createCall();
			call.setTimeout(new Integer(10000));
			call.setTargetEndpointAddress(new URL(urlName));
			call.setOperationName(new QName(
					"http://webServices.ylfl.wonders.com",
					"olderExist"));

			String xml = "<xqpg><idcard>310221192502055218</idcard></xqpg>";

			name = (String) call.invoke(new Object[] { xml });
			System.out.println(name);
		} catch (Exception e) {
			name = e.getMessage();
		}
	}
}
