package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// import com.gollahalli.main.tables.States;
import com.gollahalli.main.tables.Tours;

public class MysqlMain {

	public static void main(String[] args) throws SQLException {


		ResultSet rs = null;

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				
				) {
			
			stmt.setMaxRows(5);
			// this will not give an arbitrary  value but then just limits these rows output
			rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours");
			Tours.displayData(rs);
			
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
		} finally {
			if(rs != null){
			rs.close();
			// we have to manually close this as it is out of when block
			}
		}			
// MysqlMain2.java for better output
	}

}
