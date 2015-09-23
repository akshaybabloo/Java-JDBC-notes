package com.gollahalli.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlMain {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		// this is where you store the statement and send it too mysql server
		
		ResultSet rs = null;
		// this stores the out put that we have just queried 
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);	
			
			stmt = conn.createStatement();
			// we are telling the conn that we are creating statement
			
			rs = stmt.executeQuery("SELECT * FROM states");
			// the statement is created and the answer o fit is stored in rs
			
			rs.last();
			// we are asking the executed file to go at the end of the database with last() method
			
			System.out.println("numbers of rows is : " + rs.getRow());
			// then we are asking it for the row number at last position.
			
			System.out.println("connection successful");
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			System.err.println(e);
			
		} finally {
			if(rs != null){
				rs.close();
				System.out.println("rs is closed");
			}
			if(stmt != null){
				stmt.close();
				System.out.println("stmnt is closed");
			}
			if(conn != null){
				conn.close();
				System.out.println("conn is closed");
			}
		}

	}

}
