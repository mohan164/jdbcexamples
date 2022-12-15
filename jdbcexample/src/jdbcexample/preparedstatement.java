package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedstatement {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;

		String query = "insert into bank values (?,?,?,?,?)";
		String query1 = "select *from bank";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "mohan@123");
			System.out.println("Connected to the database");

			ps = con.prepareStatement(query);
			ps1 = con.prepareStatement(query1);

			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a accountno..");
			String Acc_no = sc.next();
			System.out.println("Please enter Name..");
			String Name = sc.next();
			System.out.println("Please enter Address..");
			String Address = sc.next();
			System.out.println("Please enter Balance..");
			int Bal = sc.nextInt();
			System.out.println("enter account type");
			String acctype = sc.next();
			ps.setString(1, Acc_no);
			ps.setString(2, Name);
			ps.setString(3, Address);
			ps.setInt(4, Bal);
			ps.setString(5, acctype);
			ps.executeUpdate();
			System.out.println("Inserted a record in the db...");

			ResultSet rs = ps1.executeQuery();
			System.out.println("ACCNO\tname\taddress\tbalance\tacctype\t");

			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
