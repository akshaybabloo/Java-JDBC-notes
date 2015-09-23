// we put everything in once class so that the password is hidden
// and all the bugs can be handled clearly

package com.gollahalli.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
	private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";

	
	public static Connection getConnection(DBType type) throws SQLException{

		switch (type) {
		
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
			
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);

		default:
			return null;
		}
	}
	
	public static void processException(SQLException e){
		// we created a function/method, when an exception occurs we get the following output 
		System.err.println("Error Message: " + e.getMessage());
		// we get an string output as to where the error as occur and what it is the error
		System.err.println("Error Code: " + e.getErrorCode());
		// we get an int error code
		System.err.println("Error State: " + e.getSQLState());
		//we get an int error state
	}
	
}
