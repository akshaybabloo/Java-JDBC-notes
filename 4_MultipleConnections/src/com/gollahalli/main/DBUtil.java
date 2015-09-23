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
	// this is a function called getConnection that we have created to connect a BDMS
	// according to the input given to it it will try and connect to that DBMS
		
		switch (type) {
		// a string input for switch can only be possible in Java 7 and above
		
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
			
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);

		default:
			return null;
		}
	}
	
	
}
