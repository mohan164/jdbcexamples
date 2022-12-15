package clobexample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import jdbcexample.Connectionclass;

public class retirvingtext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			con = Connectionclass.getjdbcconnection();

			if (con != null) {
				String sql = "select * from historyinfo where name =?";

				pst = con.prepareStatement(sql);
				System.out.println("enter name of city");
				String s = sc.next();
				pst.setString(1, s);
			}
			if (pst != null) {
				rs = pst.executeQuery();

			}
			if (rs != null) {
				while (rs.next()) {

					String data = rs.getString(1);
					File f = new File("banglore.txt");

					Reader reader = rs.getCharacterStream(2);

					FileWriter writer = new FileWriter(f);

					IOUtils.copy(reader, writer);
					writer.flush();
					System.out.println("city name is: " + data);
					System.out.println("file saved at " + f.getAbsolutePath());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				Connectionclass.closeConnection(rs, pst, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
