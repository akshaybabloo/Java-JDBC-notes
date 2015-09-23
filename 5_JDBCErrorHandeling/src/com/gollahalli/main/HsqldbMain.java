package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqldbMain {


	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = DBUtil.getConnection(DBType.HSQLDB);			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM states");
			
			rs.last();
			System.out.println("numbers of rows is : " + rs.getRow());
			
			System.out.println("connection successful");
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
			// if an error occurs an exception in DBUtil.java will execute
			
			
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
