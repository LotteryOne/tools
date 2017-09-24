package com.tappe.test;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.tappe.MyUtil;

public class GetYljgInformation {
	
	public static void main(String[] args) throws Exception {
		String urlad="http://yljg.shmzj.gov.cn/services/olderInfoGis";
		String method="yljgInfomation";
		String urlname="http://webServices.ylfl.wonders.com";
		
		Service service = new Service();
		Call call = null;
		call = (Call) service.createCall();
		call.setTimeout(1000 * 15);
		call.setTargetEndpointAddress(new java.net.URL(urlad));
		call.setOperationName(new QName(urlname, method));
		String ret = "";
		ret = (String) call.invoke(new Object[] {  });
		System.out.println(ret);
	}

}
