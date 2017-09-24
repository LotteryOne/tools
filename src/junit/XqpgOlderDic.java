package junit;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.tagext.TryCatchFinally;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class XqpgOlderDic extends TestCase {

	private static String url = "jdbc:oracle:thin:@10.1.35.19:1521:orcl";
	// system为登陆oracle数据库的用户名
	private static String user = "ylfl3";
	// manager为用户名system的密码
	private static String password = "wonders";
	public static Connection conn;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void test1() throws Exception {

		File fileout=new File("src/out.txt");
		if(!fileout.exists())
				fileout.createNewFile();
		FileWriter fw=new FileWriter(fileout);
		
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			System.out
					.println("start>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			if (conn != null) {
				String sql = "select" + " * "
						+ " from dic_area_t t where t.AREA_LEVEL='E'";

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				int f = 0;
				while (rs.next()) {

					String code = rs.getString(1);
					String name = rs.getString(2);
					String parentCode = rs.getString(3);

					String sql1 = "select * from dic_area_tran tn where tn.code=?";

					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setString(1, parentCode);
					ResultSet rs1 = ps1.executeQuery();
					String parentAreaId = null;
					while (rs1.next()) {
						parentAreaId = rs1.getString(1);
					}
					if (rs1 != null)
						rs1.close();
					if (ps1 != null)
						ps1.close();

					String one = "居委会";
					String two = "村村委会";
					String three = "村委会";
					String four = "居委";
					String likename = name.replaceAll(one, "%")
							.replaceAll(two, "%").replaceAll(three, "%")
							.replaceAll(four, "%");
					// System.out.println(name + "\t" + likename);
					String sql2 = "select * from dic_area_yl y where y.area_name like ? and y.parent_id=? and y.area_level='D' ";
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ps2.setString(1, "%" + likename + "%");
					ps2.setString(2, parentAreaId);

					ResultSet rs2 = ps2.executeQuery();
					int s = 0;
					while (rs2.next()) {
						s++;
						String result = s + "\t" + code + "\t" + name + "\t"
								+ rs2.getString(1) + "\t" + rs2.getString(2);
						System.out.println(result);
						
						String sql3="insert into dic_area_tran_temp values(?,?,?,?,?)";
						PreparedStatement ps3=conn.prepareStatement(sql3);
						ps3.setString(1, Integer.toString(s));
						ps3.setString(2, code);
						ps3.setString(3, rs2.getString(1));
						ps3.setString(4, name);
						ps3.setString(5, rs2.getString(2));
						ps3.executeUpdate();
						if(ps3!=null)ps3.close();
						
//						bw.write(result+"\n");
					}

					if (rs2 != null)
						rs2.close();
					if (ps2 != null)
						ps2.close();
				}

			}
			if(bw!=null)bw.close();
			if(fw!=null)fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

}
