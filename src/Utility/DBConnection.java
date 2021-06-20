package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection dbconnect;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbconnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlbankmgmt","root","AND@123");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbconnect;
	}

}
