package jdbcexample;

import java.util.*;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.sql.*;

public class usingconnectionpool {

	public static void main(String[] args) throws Exception {
		/*
		 * Class.forName("com.mysql.jdbc.Driver");
		 * System.out.println("Driver loaded...");
		 * 
		 * Connection con =
		 * DriverManager.getConnection("jdbc:mysql://localhost/practice","root",
		 * "mohan@123"); System.out.println("database connected");
		 * System.out.println(con); System.out.println();
		 */

		Connection con = null;
		MysqlConnectionPoolDataSource msd = new MysqlConnectionPoolDataSource();
		msd.setUrl("jdbc:mysql://localhost/practice");
		msd.setUser("root");
		msd.setPassword("mohan@123");
		con = msd.getConnection();
		Scanner sc = new Scanner(System.in);

		// inserting data
		String sqlq = "insert into tom values(?,?,?,?)";
		PreparedStatement psmt = con.prepareStatement(sqlq);
		System.out.println("enter empid");
		int id=sc.nextInt();
		System.out.println("eter name");
		String namee=sc.next();
		System.out.println("enter department");
		String dept=sc.next();
		System.out.println("enter designation");
		String desg=sc.next();
		psmt.setInt(1, id);
		psmt.setString(2, namee);
		psmt.setString(3, dept);
		psmt.setString(4, desg);
		int rw=psmt.executeUpdate();
		System.out.println("rows effected are :"+rw);
		

		// retriving data
		Statement smt = con.createStatement();
		System.out.println(smt);
		System.out.println();
		ResultSet rst = smt.executeQuery("select * from tom;");
		System.out.println(rst);
		System.out.println();

		System.out.println("No\tName\tDepartment\tDesignation");
		while (rst.next()) {
			try {
				System.out.print(rst.getInt(1)+"\t"+rst.getString(2)+"\t"+rst.getString(3)
				+"\t"+rst.getString(4));
				System.out.println();
			} catch (Exception e) {
				System.out.println("Exception:" + e);
			}
		}
		con.close();
		System.out.println("Connection closed...");

	}

}