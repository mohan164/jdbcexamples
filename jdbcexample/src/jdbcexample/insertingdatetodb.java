package jdbcexample;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class insertingdatetodb {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement psmt = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter employee name");
		String name = sc.next();

		System.out.println("enter date of birth in :(dd-mm-YYYY) format ");
		String date = sc.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(date);

		long time = udate.getTime();
		java.sql.Date sqldate = new java.sql.Date(time);
		System.out.println("normal user date " + date);
		System.out.println("simple date format date " + sdf);
		System.out.println("java util date " + udate);
		System.out.println("sql date is " + sqldate);

		String SQLQuery = "insert into employeedabase27(`name`,`dob`) values (?,?)";
		try {
			con = Connectionclass.getjdbcconnection();

			psmt = con.prepareStatement(SQLQuery);

			if (psmt != null) {
				psmt.setString(1, name);
				psmt.setDate(2, sqldate);
				int rowsaffected = psmt.executeUpdate();
				System.out.println("rows effected "+rowsaffected);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
