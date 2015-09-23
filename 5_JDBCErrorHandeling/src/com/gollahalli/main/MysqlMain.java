package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlMain {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM states");
			
			rs.last();
			System.out.println("numbers of rows is : " + rs.getRow());
			
			System.out.println("connection successful");
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
			
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
