package junit;

import com.tappe.MyUtil;

public class YljgInfor {
	public static void main(String[] args) {
		t2();
	}

	public static void t1() {

		MyUtil util = new MyUtil();

		try {
//			String su = util.receive("", "yljgInfomation");
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void t2(){
		
	String	json="{\"head\":\"{\"lrsfz\":\"411626199304053245\",\"lrxm\":\"app%E6%B5%8B%E8%AF%95002\",\"ascx0001\":\"260\"}\",\"batchid\":\"360f899a17b340afa8077a76795f7138\",\"condition\":\"{\"a26yy\":\"\",\"a9xq\":\"\",\"f6ax3x2\":\"\",\"f6ax3x3\":\"\",\"f6ax3x1\":\"\",\"aa28tgrs\":\"\",\"f6ax3x6\":\"\",\"f6ax3x4\":\"\",\"f6ax3x5\":\"\",\"a12f\":\"\",\"field4\":\"\",\"field3\":\"\",\"field2\":\"\",\"a12z\":\"\",\"bcsx\":\"\",\"f6bx10x1\":\"\",\"field1\":\"\",\"a12s\":\"\",\"f6bx10x2\":\"\",\"a26l\":\"\",\"f6bx1x1\":\"\",\"f6bx1x2\":\"\",\"f6bx1x3\":\"\",\"f6bx1x4\":\"\",\"f6ex9x2\":\"\",\"f6ex9x3\":\"\",\"f6ex9x4\":\"\",\"f6ex9x5\":\"\",\"f6ex9x1\":\"\",\"a25l\":\"\",\"md5\":\"\",\"md6\":\"\",\"md3\":\"\",\"md4\":\"\",\"md1\":\"1\",\"md2\":\"\",\"f6ex8x1\":\"\",\"fzgj14\":\"\",\"fzgj13\":\"\",\"fzgj12\":\"\",\"fzgj11\":\"\",\"fzgj10\":\"\",\"f6cx8x10\":\"\",\"aa8qt\":\"\",\"a9n\":\"\",\"dcri\":\"\",\"a9l\":\"\",\"a9h\":\"\",\"a9s\":\"\",\"a9q\":\"\",\"f610\":\"\",\"lrrxm\":\"%E9%BB%84%E6%B5%A6%E7%AE%A1%E7%90%86%E5%91%98\",\"a8qt\":\"\",\"fzgj7\":\"\",\"fzgj8\":\"\",\"fzgj9\":\"\",\"f6dx10x1\":\"\",\"c04\":\"\",\"c03\":\"\",\"c02\":\"\",\"c01\":\"\",\"f68\":\"\",\"f69\":\"\",\"mxb2\":\"\",\"mxb1\":\"\",\"mxb4\":\"\",\"mxb3\":\"\",\"mxb6\":\"\",\"mxb5\":\"\",\"fzgj2\":\"\",\"fzgj1\":\"\",\"f61\":\"\",\"f62\":\"\",\"f63\":\"\",\"aa17val\":\"\",\"fzgj6\":\"\",\"f64\":\"\",\"fzgj5\":\"\",\"f65\":\"\",\"xzdcr\":\"\",\"fzgj4\":\"\",\"f66\":\"\",\"fzgj3\":\"\",\"f67\":\"\",\"aa\":\"\",\"xzdcrqzrq\":\"\",\"aa11\":\"\",\"mxb8\":\"\",\"aa17\":\"\",\"mxb7\":\"\",\"f6ax1x6\":\"\",\"mxb9\":\"\",\"f6ax1x4\":\"\",\"f6ax1x5\":\"\",\"f6ax1x2\":\"\",\"f6ax1x3\":\"\",\"f6ax1x1\":\"\",\"f6ex10x4\":\"\",\"f6ex10x2\":\"\",\"f6ex10x3\":\"\",\"f6ex10x1\":\"\",\"aa21\":\"\",\"dcyqm\":\"%E9%BB%84%E6%B5%A6%E7%AE%A1%E7%90%86%E5%91%98\",\"mxb11\":\"\",\"mxb10\":\"\",\"f6cx3x2\":\"\",\"f6cx3x3\":\"\",\"f6cx2x1\":\"\",\"f6cx3x4\":\"\",\"f6cx2x2\":\"\",\"f6cx3x5\":\"\",\"mxb17\":\"\",\"f6cx2x3\":\"\",\"mxb16\":\"\",\"bdcrqzrq\":\"\",\"f6cx2x4\":\"\",\"f6cx2x5\":\"\",\"mxb18\":\"\",\"f6cx2x6\":\"\",\"f6cx3x1\":\"\",\"mxb13\":\"\",\"mxb12\":\"\",\"mxb15\":\"\",\"mxb14\":\"\",\"f6cx1x1\":\"\",\"a192\":\"\",\"f6cx1x3\":\"\",\"f6cx1x2\":\"\",\"f6cx1x5\":\"\",\"f6cx1x4\":\"\",\"f6cx1x6\":\"\",\"jb20\":\"\",\"f6cx10x6\":\"\",\"f6cx10x5\":\"\",\"f6cx10x4\":\"\",\"a11fy\":\"\",\"f6ax10x1\":\"\",\"jb19\":\"\",\"a1\":\"app%E6%B5%8B%E8%AF%95002\",\"a2\":\"\",\"azcp0002\":\"411626199304053245\",\"a3\":\"\",\"azcp0003\":\"app%E6%B5%8B%E8%AF%95002\",\"a4\":\"\",\"a5\":\"\",\"a6\":\"\",\"a7\":\"\",\"a8\":\"\",\"f6ex1x3\":\"\",\"f6ex1x2\":\"\",\"f6ex1x4\":\"\",\"f6ex6x2\":\"\",\"f6ex6x1\":\"\",\"f6ax10x3\":\"\",\"f6ax10x2\":\"\",\"f6ex1x1\":\"\",\"f6ex5x6\":\"\",\"f6ex5x4\":\"\",\"aa7\":\"\",\"f6ex5x5\":\"\",\"f6ex5x2\":\"\",\"f6ex5x3\":\"\",\"f6ex2x1\":\"\",\"f6cx10x1\":\"\",\"f6ex2x2\":\"\",\"f6ex5x1\":\"\",\"f6cx10x2\":\"\",\"f6ex2x3\":\"\",\"f6cx10x3\":\"\",\"f6ex4x1\":\"\",\"f6ex3x1\":\"\",\"f6ex4x2\":\"\",\"f6ex3x2\":\"\",\"aa10\":\"\",\"f6ex3x3\":\"\",\"f6ex4x3\":\"\",\"aa9\":\"\",\"aa8\":\"\",\"f6bx5x3\":\"\",\"f6dx8x5\":\"\",\"f6bx4x1\":\"\",\"f6dx8x4\":\"\",\"f6ax2x6\":\"\",\"f6bx5x1\":\"\",\"f6dx6x1\":\"\",\"f6ax2x5\":\"\",\"f6bx5x2\":\"\",\"f6dx6x3\":\"\",\"f6dx6x2\":\"\",\"f6dx6x5\":\"\",\"f6dx6x4\":\"\",\"f6dx7x2\":\"\",\"a20\":\"\",\"f6dx7x1\":\"\",\"f6ax2x4\":\"\",\"f6bx4x4\":\"\",\"f6ax2x3\":\"\",\"f6bx4x5\":\"\",\"f6ax2x2\":\"\",\"f6bx4x2\":\"\",\"f6ex11x1\":\"\",\"f6ax2x1\":\"\",\"f6bx4x3\":\"\",\"a16\":\"\",\"a17\":\"\",\"f6dx9x1\":\"\",\"a14\":\"\",\"a15\":\"\",\"a9jd\":\"\",\"f6bx3x2\":\"\",\"f6bx3x1\":\"\",\"a13\":\"\",\"a10\":\"\",\"f6bx2x4\":\"\",\"ysqm\":\"%E9%BB%84%E6%B5%A6%E7%AE%A1%E7%90%86%E5%91%98\",\"a11\":\"\",\"f6bx2x3\":\"\",\"f6bx2x2\":\"\",\"f6bx2x1\":\"\",\"f6bx3x3\":\"\",\"f6dx8x1\":\"\",\"f6dx8x2\":\"\",\"a18\":\"\",\"f6dx8x3\":\"\",\"a19\":\"\",\"f6ax9x6\":\"\",\"aa29tgrs\":\"\",\"f6bx6x1\":\"\",\"f6bx6x2\":\"\",\"cc05_2\":\"\",\"cc05_3\":\"\",\"cc05_1\":\"\",\"f6bx7x1\":\"\",\"f6bx7x2\":\"\",\"f6bx7x3\"";
		
		
		
		MyUtil util = new MyUtil();
		String receive="&token=123123&json="+json;
		System.out.println(receive);
//		String urlad="http://116.236.223.77/toXqpg.do?method=bodyApply";
		String urlad="http://localhost:8080/syljg/toXqpg.do?method=bodyApply";
		System.out.println(urlad+receive);
		
		try {
			String ff=util.receiveHttp(receive, urlad);
			System.out.println(ff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
