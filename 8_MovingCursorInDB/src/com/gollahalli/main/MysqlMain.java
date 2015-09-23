package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gollahalli.main.tables.States;
// import com.gollahalli.main.tables.Tours;

public class MysqlMain {

	public static void main(String[] args) throws SQLException {



		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT stateId, stateName FROM states");
				// ResultSet rs = stmt.executeQuery("SELECT * FROM tours")
		// this type is called try(with) catch block
				) {

			States.displayData(rs);
			// Tours.displayData(rs);
			
			
			rs.first();
			// will go to first line in db
			System.out.println("the first row number and its content is: " + rs.getRow() + " - " + 
							rs.getString("stateName"));
			// with getRow you get the row number and with getString you get the content in that row.
			
			
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
