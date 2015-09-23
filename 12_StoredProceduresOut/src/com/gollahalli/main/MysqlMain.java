package com.gollahalli.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.gollahalli.main.tables.Tours;
import com.gollahalli.main.util.InputHelper;

public class MysqlMain {
	private static final String SQL = "{call GetToursWithCountByPrice(?,?)}";
	// This function is stored in the Data base with two parameters as inputs
	
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
				) {
			stmt.setDouble(1, maxPrice);
			stmt.registerOutParameter("total", Types.INTEGER);
			// we get out the vale of type int
			rs = stmt.executeQuery();
			int nRows = stmt.getInt("total");
			// we take those values and store them in the int nRows
			
			
			Tours.displayData(rs, nRows);
			// then we send these two values to displayData function
			// see Tours.java
			
			
			
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
