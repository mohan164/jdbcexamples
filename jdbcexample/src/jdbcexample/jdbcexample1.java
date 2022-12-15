package jdbcexample;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class jdbcexample1{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/practice";

   static final String USER = "root";
   static final String PASS = "mohan@123";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to a selected database");
      conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully");
       System.out.println("Creating table in database");
      stmt = (Statement) conn.createStatement();
      
      String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 
      stmt.executeUpdate(sql);
      System.out.println("Created table in  database");
      System.out.println("Inserting records into the table");
      stmt = (Statement) conn.createStatement();
      
      String sql1 = "INSERT INTO Registration " +
                   "VALUES (100, 'allu', 'arjun', 18)";
      stmt.executeUpdate(sql1);
      sql1 = "INSERT INTO Registration " +
                   "VALUES (101, 'nani', 'nani', 25)";
      stmt.executeUpdate(sql1);
      sql1 = "INSERT INTO Registration " +
                   "VALUES (102, 'ram', 'potheneni', 30)";
      stmt.executeUpdate(sql1);
      sql1 = "INSERT INTO Registration " +
                   "VALUES(103, 'ram', 'charan', 28)";
      stmt.executeUpdate(sql1);
      System.out.println("Inserted records into the table");
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("CLOSING CONNECTION");
}
}