package jdbcexample;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class gettingdatefromdb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the user name");
		String name = sc.next();

		String SQLQUERY = "select name,dob from employeedabase27 where name=?";
		try {
			connection = Connectionclass.getjdbcconnection();
			psmt = connection.prepareStatement(SQLQUERY);

			if (psmt != null) {
				psmt.setString(1, name);
				rs = psmt.executeQuery();
			}
			if(rs!=null)
			{
				System.out.println("NAME\tDATE\t");
				if(rs.next())
				{
					String name1=rs.getString(1);
					java.sql.Date sdate=rs.getDate(2);
					
					SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
					String date1= sdf.format(sdate);
					
					System.out.print(name1+"\t"+date1+"\t");
					
					
				}
				else
				{
					System.out.println("user not found");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
