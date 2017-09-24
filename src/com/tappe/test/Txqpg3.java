package com.tappe.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Txqpg3 {
	public static void main(String[] args) throws IOException {
		String name = "";
		try {

			String urlName = "http://localhost:8080/xqpg/services/ExportDataCollectorService?wsdl";
			// String urlName =
			// "http://130.2.32.14:9080/xqpg/services/ExportDataCollectorService?wsdl";
			// urlName =
			// "http://130.2.32.14:9080/xqpg/services/ExportDataCollectorService";
			Service s = new Service();
			Call call = (Call) s.createCall();
			 call.setTimeout(new Integer(10000));
			

			File fileread = new File("xml.txt");

			// FileInputStream fis=new FileInputStream(fileread);
			FileReader read = new FileReader(fileread);

			BufferedReader br = new BufferedReader(read);
			int len = 0;
			String xml = "";
			br.read();
			urlName=br.readLine();
			urlName = urlName.trim();
			call.setTargetEndpointAddress(new URL(urlName));
			br.read();
			
			call.setOperationName(new QName(
					br.readLine().trim(), "xqpgOlderApply"));
			while ((len = br.read()) != -1) {
				String s1 = br.readLine();
				s1 = s1.trim();
				System.out.println(s1);
				xml += s1;
			}
			br.close();
			read.close();
			System.out.println(xml);

			// String xml = "<xqpg>" + "<name>钱云娥</name>"
			// + "<idcard>310223193609230845</idcard>"
			// + "<applytime>2016-06-24</applytime>" + "<gender>F</gender>"
			// + "<birth>1936-09-23</birth>" + "<marry>2</marry>"
			// + "<nation></nation>" + "<regarea>310113000000</regarea>"
			// + "<regneighbor>310113003000</regneighbor>"
			// + "<regvillage></regvillage>"
			// + "<regtext>宝钢九村13号405室</regtext>" + "<regzip></regzip>"
			// + "<regphone></regphone>" + "<mobile>13916321268</mobile>"
			// + "<livearea>310113000000</livearea>"
			// + "<liveneighbor>310113003000</liveneighbor>"
			// + "<livevillage></livevillage>"
			// + "<livetext>宝钢九村13号405室</livetext>" + "<monincome></monincome>"
			// + "<monolder></monolder>" + "<datasource>2</datasource>"
			// + "<healthlevel>5</healthlevel>" + "<econresult>4</econresult>"
			// + "<mateoldername></mateoldername>"
			// + "<mateidcard></mateidcard>" + "<matecon></matecon>"
			// + "</xqpg>";

			// String xml = "<xqpg>" + "<name>钱云鹅</name>"
			// + "<idcard>310223193609230845</idcard>"
			// + "<applytime>2016-06-24</applytime>" + "<gender>F</gender>"
			// + "<birth>1985-06-02</birth>" + "<marry>2</marry>"
			// + "<nation></nation>" + "<regarea>310113000000</regarea>"
			// + "<regneighbor>310113000000</regneighbor>"
			// + "<regvillage>310112108010</regvillage>"
			// + "<regtext></regtext>" + "<regzip></regzip>"
			// + "<regphone></regphone>" + "<mobile>11111111111</mobile>"
			// + "<livearea>310112000000</livearea>"
			// + "<liveneighbor>310112108000</liveneighbor>"
			// + "<livevillage>310112108010</livevillage>"
			// + "<livetext>eeeee</livetext>" + "<monincome>1234</monincome>"
			// + "<monolder>123</monolder>" + "<datasource>2</datasource>"
			// + "<healthlevel>3</healthlevel>" + "<econresult>3</econresult>"
			// + "<mateoldername></mateoldername>"
			// + "<mateidcard></mateidcard>" + "<matecon></matecon>"
			// + "</xqpg>";
			name = (String) call.invoke(new Object[] { xml });
			System.out.println(name);
		} catch (Exception e) {
			name=e.getMessage();
		}
		File file = new File("tt.txt");
		if (!file.exists())
			file.createNewFile();

		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
				file, true));
		osw.write(name+"\n");
		osw.flush();
		osw.close();

	}
}
