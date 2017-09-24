package com.tappe.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Txqpg2 {
	public static void main(String[] args)  
			  {
		 String message="";
		 String name="";
		try {
			
		
		String urlName = "http://localhost:8080/xqpg/services/ExportDataCollectorService?wsdl";
//			urlName="http://130.2.4.29:9080/xqpg/services/ExportDataCollectorService?wsdl";
		// urlName =
		// "http://localhost:8080/xqpg/services/ExportDataCollectorService";
		Service s = new Service();
		Call call = (Call) s.createCall();
		// call.setTimeout(new Integer(50000));
		call.setOperationName(new QName(
				"http://services.assess.wondersgroup.com", "xqpgOlderApply"));
		call.setTargetEndpointAddress(new URL(urlName));
		String xml = "<xqpg>" + "<name>张宝秀</name>"
				+ "<idcard>310109193307161626</idcard>"
				+ "<applytime>2016-3-31</applytime>" + "<gender>M</gender>"
				+ "<birth>1933-07-16</birth>" + "<marry>2</marry>"
				+ "<nation></nation>" + "<regarea>310109000000</regarea>"
				+ "<regneighbor>310109018000</regneighbor>"
				+ "<regvillage>310109018340</regvillage>"
				+ "<regtext>霍山路21弄22号</regtext>" + "<regzip></regzip>"
				+ "<regphone></regphone>" + "<mobile>13681913722</mobile>"
				+ "<livearea>310109000000</livearea>"
				+ "<liveneighbor>310109010000</liveneighbor>"
				+ "<livevillage>310100901026</livevillage>"
				+ "<livetext>运光路70弄7号303室</livetext>" + "<monincome>2397.7</monincome>"
				+ "<monolder>2352.7</monolder>" + "<datasource>2</datasource>"
				+ "<healthlevel>2</healthlevel>" + "<econresult>6</econresult>"
				+ "<mateoldername></mateoldername>"
				+ "<mateidcard></mateidcard>" + "<matecon></matecon>"
				+ "</xqpg>";
		 name= (String) call.invoke(new Object[] { xml });
		System.out.println(name);
		} catch (Exception e) {
			name= e.getMessage();
		}
//		try {
		
//		File file=new File("result_older.txt");
//		
//		if(file.exists()){
//				file.createNewFile();
//			
//		}
//		
//		FileOutputStream fos=new FileOutputStream(file,true);
//		PrintWriter pw=new PrintWriter(fos);
//		pw.write(name);
//		pw.close();
//		fos.close();
//		} catch (IOException e) {
//			 
//		}
	   
	}
}
