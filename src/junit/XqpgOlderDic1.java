package junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import junit.framework.TestCase;

public class XqpgOlderDic1  extends TestCase{
	private static String url = "jdbc:oracle:thin:@10.1.35.19:1521:orcl";
	// system为登陆oracle数据库的用户名
	private static String user = "ylfl3";
	// manager为用户名system的密码
	private static String password = "wonders";
	public static Connection conn;

	public void test1() throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);

		try {

			String sql = "select p.code from dic_area_tran_temp p group by p.code";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String code = rs.getString(1);
				System.out.println(code+">>>>>>>");
				String sql1 = " select * from ( "
						+ "select rownum rn ,c.* from ( "
						+ "select  p.* from dic_area_tran_temp p  "
						+ "where p.code=? "
						+ "order by length(p.name))c )c where c.rn=1";

				String sql2 = "insert into dic_area_tran_temp1 values(?,?,?,?,?)";

				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ps1.setString(1, code);
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ps2.setString(1, rs1.getString("nums"));
					ps2.setString(2, rs1.getString("code"));
					ps2.setString(3, rs1.getString("codename"));
					ps2.setString(4, rs1.getString("areaid"));
					ps2.setString(5, rs1.getString("name"));
					ps2.execute();
					if (ps2 != null)
						ps2.close();
					System.out.println(rs1.getString(2)+">>>>");
				}

				if (rs1 != null)
					rs1.close();
				if (ps1 != null)
					ps1.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();

		}

	}
}
