package blobexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbcexample.Connectionclass;

public class insertingimage {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement psmt = null;
		con = Connectionclass.getjdbcconnection();
		System.out.println("entered");
		String sqlq="insert into personimageinserting values(?,?)";
		System.out.println("entered");

		
		psmt=con.prepareStatement(sqlq);
		
		psmt.setString(1, "Taj Mahal");
		System.out.println("entered");

		File f=new File("nitin.jpg");
		FileInputStream fis= new FileInputStream(f);
		System.out.println("entered");

		psmt.setBlob(2, fis);
		System.out.println("entered");

		int rw=psmt.executeUpdate();
		System.out.println("entered");

		System.out.println("inserted rows are :"+rw);
		
		Connectionclass.closeConnection(null, psmt, con);

	}

}
