package junit;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

public class XqpgOlderCheck {
	public static void main(String[] args) throws Exception {
		Service service = new Service();
		Call call = null;
		call = (Call) service.createCall();
		// call.setTimeout(1000 * 15);
		String urlad = "http://localhost:8080/syljg/services/olderInfoGis";
		urlad="http://localhost:8080/xqpg/services/ExportDataCollectorService?wsdl";
		call.setTargetEndpointAddress(new java.net.URL(urlad));
		String urlname = "http://webServices.ylfl.wonders.com";
		urlname="http://localhost:8080/xqpg/services/ExportDataCollectorService";
		String method = "olderCheck";
		String s="authorized_keys";
		
		
		call.setOperationName(new QName(urlname, method));
		String ret = "";
		String receive = makeXml();
		System.out.println(receive);
		ret = (String) call.invoke(new Object[] { receive });
		System.out.println(ret);
	}

	static String makeXml() {
		String xml = "<xqpg><data><id>1600000001</id><xm>×£ÁøÓ¢</xm><sfzh>310221192507174021</sfzh></data>"
				+ "<data><id>1600000002</id><xm>Ê®µã¶à</xm><sfzh>310100197006140443</sfzh></data>"
				+ "</xqpg>";
		return xml;
	}
}
