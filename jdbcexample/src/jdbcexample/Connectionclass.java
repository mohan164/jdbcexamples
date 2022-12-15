package jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class Connectionclass {

	public static Connection getjdbcconnection() throws SQLException, IOException {

		Connection connection = null;

		MysqlConnectionPoolDataSource msd = new MysqlConnectionPoolDataSource();
		
		Properties props = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Mohan\\eclipse-workspace\\jdbcexample\\src\\properties\\properties");

		props.load(fis);

		String url = props.getProperty("url");
		String username = props.getProperty("user");
		String password = props.getProperty("password");

		msd.setUrl(url);
		msd.setUser(username);
		msd.setPassword(password);
		connection =msd.getConnection();

		
		//2nd method through properties file
		/*
		 * Properties props = new Properties();
		 * 
		 * FileInputStream fis = new FileInputStream(
		 * "C:\\Users\\Mohan\\eclipse-workspace\\jdbcexample\\src\\properties\\properties"
		 * );
		 * 
		 * props.load(fis);
		 * 
		 * String url = props.getProperty("url"); String username =
		 * props.getProperty("user"); String password = props.getProperty("password");
		 * 
		 * connection = DriverManager.getConnection(url, username, password);
		 */
		
		// 3rd through traditional method
		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","mohan@123");

		if (connection != null) {
			return connection;
		}
		return connection;
	}

	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection)
			throws SQLException {

		// 6. closing the resources used
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();

		}
		if (connection != null) {
			connection.close();
		}

	}

}
