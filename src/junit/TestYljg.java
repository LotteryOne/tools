package junit;

import com.tappe.MyUtil;

public class TestYljg {

	public static void main(String[] args) {
		String receive = "<yljg>" + "<name>胡金仙</name>"
				+ "<organid>0281a0a229873627012a31f047015cc1</organid>"
				+ "<idcard>310225192801201225</idcard>" + "<sex>02</sex>"
				+ "<birth>1928/01/20</birth>" + "<mobile>13501887806</mobile>"
				+ "<reservation>2016/10/28</reservation>"
				+ "<socialcard></socialcard>" + "<oldertype></oldertype>"
				+ "<nation></nation>" + "<natiove></natiove>"
				+ "<marry></marry>" + "<culture></culture>"
				+ "<olderwork></olderwork>" + "<olderjob></olderjob>"
				+ "<subsidy></subsidy>" + "<telephone></telephone>"
				+ "<iscity>1</iscity>" + "<livepro></livepro>"
				+ "<livecity>310000000000</livecity>"
				+ "<livearea>310115000000</livearea>"
				+ "<livestreet>310115132000</livestreet>"
				+ "<liveroad></liveroad>" + "<livecountry></livecountry>"
				+ "<livealley></livealley>" + "<liveNumber></liveNumber>"
				+ "<livetext></livetext>" + "<regpro>周浦镇塘东村162号2室</regpro>"
				+ "<regcity>310000000000</regcity>"
				+ "<regarea>310115000000</regarea>"
				+ "<regstreet>310115132000</regstreet>" + "<regroad></regroad>"
				+ "<regcountry></regcountry>" + "<regalley></regalley>"
				+ "<regnumber></regnumber>" + "<regroom></regroom>"
				+ "<regtext>周浦镇塘东村162号2室</regtext>" + "<zodiac></zodiac>"
				+ "<pinyin></pinyin>" + "<bodyresult>五级照护</bodyresult>"
				+ "<econresult>低收入</econresult>"
				+ "<bodydec>高血压冠心病脑梗塞</bodydec>" + "</yljg>";
		;
		String method = "bespeak";
		String urlad = "http://yljg.shmzj.gov.cn/services/olderInfoGis";
		String urlname = "http://webServices.ylfl.wonders.com";

		try {
			String result = MyUtil.receive(receive, method, urlad, urlname);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
