package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gollahalli.main.tables.States;

public class HsqldbMain {

	public static void main(String[] args) throws SQLException {



		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM states");
		// this type is called try(with) catch block
				) {

			States.displayData(rs);
			// Tours.displayData(rs);
			
			
			rs.first();
			// will go to first line in db
			System.out.println("the first row number and its content is: " + rs.getRow() + " - " + 
							rs.getString("stateName"));
			
			
			rs.last();
			// will go to the last line in db
			System.out.println("the last row number and its content is: " + rs.getRow() + " - " +
							rs.getString("stateName"));
			
			
			rs.absolute(10);
			// will go to the specified line in db
			System.out.println("the 10th row number and its content is: " + rs.getRow() + " - " + 
							rs.getString("stateName"));

		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
		} 

	}

}
