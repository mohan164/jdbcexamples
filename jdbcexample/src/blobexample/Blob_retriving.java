package blobexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import jdbcexample.Connectionclass;

public class Blob_retriving {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = "select *from personimageinserting where name=?";
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("enter name"); String s = sc.next();
		 */
		conn = Connectionclass.getjdbcconnection();
		psmt = conn.prepareStatement(sql);

		psmt.setString(1, "Taj Mahal");
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			String name = rs.getString(1);

			InputStream fis = rs.getBinaryStream(2);
			File f = new File("nitin_download.jpg");

			FileOutputStream fos = new FileOutputStream(f);
			// 1st logic
			/*
			 * byte[] buffer=new byte[2048];
			 * 
			 * if(fis.read(buffer)>0) { fos.write(buffer); }
			 */
			// 2nd logic

			/*
			 * int i = fis.read(); while (i != -1) { fos.write(i); i = fis.read(); }
			 * fos.flush();
			 */
			// 3rd logic
			IOUtils.copy(fis, fos);	
			
			System.out.print(name);
			System.out.println("file stored at" + f.getAbsolutePath());
		}
	}

}
