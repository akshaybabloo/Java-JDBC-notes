package com.gollahalli.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gollahalli.main.tables.Tours;
import com.gollahalli.main.util.InputHelper;

public class MysqlMain {
	private static final String SQL = "{call GetToursByPrice(?)}";
	// this function is stored in the mysql database
	
	public static void main(String[] args) throws SQLException {

		double maxPrice;
		try {
			maxPrice = InputHelper.getDoubleInput("Enter a max price: ");
		} catch (NumberFormatException e) {
			System.err.println("error: invalid number");
			return;
		}

		ResultSet rs = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				CallableStatement stmt = conn.prepareCall(SQL);
				// we use the above function to call stored procedures
				) {
			stmt.setDouble(1, maxPrice);
			rs = stmt.executeQuery();
			Tours.displayData(rs);
			
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
		} finally{
			if(rs != null){
				rs.close();
			}
			
		}

	}

}
