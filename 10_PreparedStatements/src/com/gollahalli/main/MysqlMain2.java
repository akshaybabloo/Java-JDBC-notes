package com.gollahalli.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gollahalli.main.tables.Tours;
import com.gollahalli.main.util.InputHelper;

public class MysqlMain2 {
	private static final String SQL = "SELECT tourId, tourName, price FROM tours "
			+ "WHERE price <= ?";
	// you created a constant SQL with the input query. the ? is where you tell jave for the input

	public static void main(String[] args) throws SQLException {

		double maxPrice;
		// double because if you see the db tourId is in double form
		try {
			maxPrice = InputHelper.getDoubleInput("Enter a max price: ");
			// this is a custom class and custom method from InputHelper.java
		} catch (NumberFormatException e) {
			// if you dont give it a correct format you will get this error exception
			System.err.println("error: invalid number");
			return;
		}

		ResultSet rs = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(SQL);
				// an sql is precompiled when a prepared statement is used
				) {
			stmt.setDouble(1, maxPrice);
			// as we have only 1 input thats why 1 if we had 2 then it would be 2 and so on
			// maxPrice is the input value
			rs = stmt.executeQuery();
			// we dont have to call the SQL value as we have already precompiled in PreparedStatement 
			// but then we need executeQuery to execute SQL
			Tours.displayData(rs);
			
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
		} finally{
			if(rs != null){
				rs.close();
			// closing the ResultSet
			}
			
		}

	}

}
