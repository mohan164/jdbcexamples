package jdbcexample;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
public class batchprogram {
	
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	/*
	 * Driver D=new Driver(); DriverManager.registerDriver(D);
	 */
	System.out.println("driver Loaded..");
	Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/practice","root","mohan@123");
	System.out.println("connected to database..");
	Statement st=(Statement) con.createStatement();
	con.setAutoCommit(false);
	st.addBatch("update emp_jdbc set name='ram' where name='sai'");
	st.addBatch("insert into emp_jdbc values('109','mohan','software engineer')");
	st.addBatch("insert into emp_jdbc values ('110','arun','software engineer')");
	try {
		st.executeBatch();
		System.out.println("batch executed");
		con.commit();
	}
	catch(Exception e) {
		try {
			con.rollback();
			System.out.println("batch cancelled");
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		con.close();
	}

}
} 
