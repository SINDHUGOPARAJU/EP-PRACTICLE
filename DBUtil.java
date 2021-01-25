package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
//	final static String forNameURL = "oracle.jdbc.driver.OracleDriver";
	final static String forNameURL = "com.mysql.cj.jdbc.Driver";
//	final static String dBURL = "jdbc:oracle:thin:@localhost:1521:XE";
	final static String dBURL = "jdbc:mysql://localhost:3306/studentdata";
	final static String username = "root";
	final static String password = "root";
	public static Connection DBConnection() throws SQLException, ClassNotFoundException {
//		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Class.forName(forNameURL);
		Connection con = DriverManager.getConnection(dBURL, username, password);
		return con;
	}
	
}


