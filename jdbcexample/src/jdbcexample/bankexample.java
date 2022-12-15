package jdbcexample;

import java.io.IOException;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class bankexample {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver Loaded..");
		Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/practice","root","mohan@123");
		System.out.println("connected to database..");
		java.sql.Statement st =  con.createStatement();
		st.execute("create table employeedabase27(name varchar(20),dob Date)");

		//st.execute("create table bank(accno int,name varchar(20),address varchar(20),balance int,acctype varchar(20))");
		System.out.println("table created..");
		//st.execute("insert into bank values('6344','mohan','hyderabad','5000000','savings')");
		//st.execute("insert into bank values('6345','raju','kochi','45836','savings')");
		st.execute("insert into bank values('6343','ramesh','vizag','445455','salary')");
		System.out.println("rows inserted..");
	
		st.execute("update bank set balance='7000000' where name='mohan'");
		
		con.close();
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}

}
}