package jdbcexample;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.*;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
public class storedprocedure {
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver Loaded..");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/practice","root","mohan@123");
		System.out.println("connected to database..");
		java.sql.CallableStatement cal=con.prepareCall("{call insertIntoEMP(?,?)}");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter sal");
		int sal=sc.nextInt();
		cal.setString(1, name);
		cal.setInt(2, sal);
		cal.execute();
		con.close();
		sc.close();
		System.out.println("data inserted");
	}
		catch(Exception e) {
			System.out.println(e);
		}

}
}
