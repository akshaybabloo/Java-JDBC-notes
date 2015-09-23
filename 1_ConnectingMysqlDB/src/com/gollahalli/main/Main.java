package com.gollahalli.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static final String USERNAME = "root";
	// final will make this string as a constant.
	// this is the user name for MySQL
	
	private static final String PASSWORD = "root";
	// this is the user name for MySQL
	
	private static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
	/* this is how you connect to the database which you have imported into mysql through
	phpmyadmin */
	
	
	public static void main(String[] args) throws SQLException {
		// the throws SQLException is for the if statement
		
		Connection conn = null;
		// Connection is a data type for conn to initialize a connection to the DB
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			// DriverManager is a type of interface to the JDBC connection
			// we ask for the connection by using getConnection method.
			
			System.out.println("connection successful");
			// if the connection is successful give this out put.
			
		} catch (SQLException e) {
			// if there is an SQLException
			System.out.println("there was no connection!");
			System.err.println(e);
			
			// tell what the error is
		} finally {
			if(conn != null){
				conn.close();
				// a connection must be closed, so we use close() method
			}
		}

	}

}
