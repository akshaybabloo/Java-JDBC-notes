package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// import com.gollahalli.main.tables.States;
import com.gollahalli.main.tables.Tours;

public class MysqlMain {
	private static final String SQL = "SELECT tourId, tourName, price FROM tours";

	public static void main(String[] args) throws SQLException {


		ResultSet rs = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				) {

			rs = stmt.executeQuery(SQL);
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
