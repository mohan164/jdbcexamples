package jdbcexample;
import java.util.*;
import java.sql.*;

public class getstring {
	
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded...");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practice","root","mohan@123");
		System.out.println("database connected");
		System.out.println(con);
		System.out.println();
		
		
		Statement smt = con.createStatement();
		System.out.println(smt);
System.out.println();
		ResultSet rst = smt.executeQuery("select * from tom;");
		System.out.println(rst);
System.out.println();
		
		System.out.println("No       Name    Department   Designation");
		while(rst.next())
		{
			try
			{
			System.out.print(rst.getString("empid"));
			System.out.print(" \t " + rst.getString("name"));
			System.out.print(" \t " + rst.getString("dept"));
			System.out.print(" \t     " + rst.getString("designation"));	
			}
			catch(Exception e)
			{
				System.out.println("Exception:" + e);
			}
			System.out.println("  ");
		}
		con.close();
		System.out.println("Connection closed...");
		
	}

}