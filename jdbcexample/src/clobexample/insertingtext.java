package clobexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbcexample.Connectionclass;

public class insertingtext {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Connection con=null;
		PreparedStatement psmt=null;
		 try {
			con= Connectionclass.getjdbcconnection();
			
			String sqlq="insert into historyinfo values(?,?)";
			if(con!=null)
			{
			psmt=con.prepareStatement(sqlq);
			}
			if(psmt!=null)
			{
				psmt.setString(1, "bengaluru");
				
				File f=new File("benagluru_history.txt");
				FileReader fr= new FileReader(f);
				
				psmt.setCharacterStream(2, fr);
				 int ra=psmt.executeUpdate();
				 
				 System.out.println("rows affected are :"+ra);
				 System.out.println("files inserrting from "+f.getAbsolutePath());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
