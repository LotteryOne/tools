package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class SendMessage {

	public static void main(String[] args) {

//		new SendMessage().send();
		System.out.println("cccc");
	}

	public void send() {

		try {
//			 FileInputStream fis=new FileInputStream(new
//			 File("src/organList.txt"));
//
//			BufferedInputStream bis=new BufferedInputStream(fis);
			 
			 
			 
			FileReader fr = new FileReader(new File("src/organList.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			
			
			
			while (br.read() != -1) {
				String receive = br.readLine().trim();
				System.out.println(receive);
				String url = "http://130.2.4.29:9080/ylfl/services/dataService?wsdl";
				String urlname = "http://130.2.4.29:9080/ylfl/services/dataService";
				String method = "getOrgan";
				try {
					String resutl = receive(receive, method, url, urlname);
					System.out.println(resutl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String receive(String receive, String method, String urlad,
			String urlname) throws Exception {
		Service service = new Service();
		Call call = null;
		call = (Call) service.createCall();
		call.setTimeout(1000 * 15);
		call.setTargetEndpointAddress(new java.net.URL(urlad));
		call.setOperationName(new QName(urlname, method));
		String ret = "";
		ret = (String) call.invoke(new Object[] { receive });
		return ret;
	}

}
