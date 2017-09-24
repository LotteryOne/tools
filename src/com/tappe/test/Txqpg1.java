package com.tappe.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Txqpg1 {
	public static void main(String[] args) throws ServiceException,
			MalformedURLException, RemoteException {
		String urlName = "http://localhost:8080/xqpg/services/ExportDataCollectorService?wsdl";
//		urlName = "http://localhost:8080/xqpg/services/ExportDataCollectorService";
		Service s = new Service();
		Call call = (Call) s.createCall();
//		call.setTimeout(new Integer(50000));
		call.setOperationName(new QName(
				"http://services.assess.wondersgroup.com", "xqpgOlderApply"));
		call.setTargetEndpointAddress(new URL(urlName));
		String xml = "<xqpg>"
				+ "<name>≤‚ ‘ «À≠</name>"
				+ "<applytime>2016-03-11</applytime>"
				+ "<idcard>310112195006023200</idcard>"
				+ "<gender>F</gender>"
				+ "<nation>∫∫</nation>"
				+ "<birth>1950-06-02</birth>"
				+ "<marry>2</marry>"
				+ "<ensurecard></ensurecard>"
				+ "<education>6</education>"
				+ "<degree></degree>"
				+ "<career></career>"
				+ "<native></native>"
				+ "<regarea>12</regarea>"
				+ "<regneighbor>12108</regneighbor>"
				+ "<regvillage>1210801</regvillage>"
				+"<regtext></regtext>"
				+ "<regzip>200000</regzip>"
				+ "<regphone></regphone>"
				+ "<mobile>15286800773</mobile>"
				+ "<livearea>12</livearea>"
				+ "<liveneighbor>12108</liveneighbor>"
				+ "<livevillage>1210801</livevillage>"
				+"<livetext></livetext>"
				+ "<mateoldername></mateoldername>"
				+ "<mateidcard></mateidcard>"
				+"<matecon></matecon>"
				+ "<liveneighbor></liveneighbor>"
				+ "<healthlevel></healthlevel>"
				+ "<econresult></econresult>"
				+ "</xqpg>";
		String name = (String) call.invoke(new Object[] { xml });
		System.out.println(name);
	}
}
