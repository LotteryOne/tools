package junit;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

public class TestyljgOlderCheck {
	public static void main(String[] args) throws Exception {
		Service service = new Service();
		Call call = null;
		call = (Call) service.createCall();
		// call.setTimeout(1000 * 15);
		String urlad = "http://localhost:8080/syljg/services/olderInfoGis";
		call.setTargetEndpointAddress(new java.net.URL(urlad));
		String urlname = "http://webServices.ylfl.wonders.com";
		String method = "olderCheck";
		call.setOperationName(new QName(urlname, method));
		String ret = "";
		String receive = makeXml();
		System.out.println(receive);
		ret = (String) call.invoke(new Object[] { receive });
		System.out.println(ret);
	}

	static String makeXml() {
		String xml = "<xqpg><data><id>1600000001</id><xm>米老鼠</xm><sfzh>413026198906141213</sfzh></data>"
				+ "<data><id>1600000002</id><xm>十点多</xm><sfzh>310100197006140443</sfzh></data>"
				+ "</xqpg>";
		return xml;
	}
}
