package com.tappe.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.io.IOUtils;

import com.tappe.MyUtil;

public class TestBesPeck {
	public static void main(String[] args) throws Exception {
		//0281a0a2288186b70128fc784fdc3764
		//0281a0a2288186b70128fc8765503774
		String xml = "<yljg>" + "<name>张乃清</name>"
				+ "<organid>0281a0a235a97d120135bd733aff2529</organid>"
				+ "<idcard>31011019350501741X</idcard>" + "<sex>01</sex>"
				+ "<birth>1935/05/01</birth>" + "<mobile>13761616814</mobile>"
				+ "<reservation>2016/08/29</reservation>"
				+ "<socialcard></socialcard>" + "<oldertype></oldertype>"
				+ "<nation></nation>" + "<natiove></natiove>"
				+ "<marry></marry>" + "<culture></culture>"
				+ "<olderwork></olderwork>" + "<olderjob></olderjob>"
				+ "<subsidy></subsidy>" + "<telephone></telephone>"
				+ "<iscity>1</iscity>" + "<livepro></livepro>"
				+ "<livecity>310000000000</livecity>"
				+ "<livearea>310115000000</livearea>"
				+ "<livestreet>310115123000</livestreet>"
				+ "<liveroad></liveroad>"
				+ "<livecountry>310115123011</livecountry>"
				+ "<livealley></livealley>" + "<liveNumber></liveNumber>"
				+ "<livetext></livetext>" + "<regpro>新园路439弄13号102室</regpro>"
				+ "<regcity>310000000000</regcity>"
				+ "<regarea>310115000000</regarea>"
				+ "<regstreet>310115123000</regstreet>" + "<regroad></regroad>"
				+ "<regcountry>310115123216</regcountry>"
				+ "<regalley></regalley>" + "<regnumber></regnumber>"
				+ "<regroom></regroom>" + "<regtext>东孙家沟5号</regtext>"
				+ "<zodiac></zodiac>" + "<pinyin></pinyin>"
				+ "<bodyresult>四级照护</bodyresult>"
				+ "<econresult>不符合市财政补贴</econresult>" + "<bodydec>高血压</bodydec>"
				+ "</yljg>";
		
		String method="bespeak";
		String urlad="http://yljg.shmzj.gov.cn/services/olderInfoGis";
		String urlname="http://webServices.ylfl.wonders.com";
		Service service = new Service();
		Call call = null;
		call = (Call) service.createCall();
//		call.setTimeout(1000 * 15);
		call.setTargetEndpointAddress(new java.net.URL(urlad));
		call.setOperationName(new QName(urlname, method));
		String ret = "";
		ret = (String) call.invoke(new Object[] { xml });
		System.out.println(ret);
	}
	
}
