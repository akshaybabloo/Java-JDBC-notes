package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// import com.gollahalli.main.tables.States;
import com.gollahalli.main.tables.Tours;

public class MysqlMain2 {

	public static void main(String[] args) throws SQLException {



		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours "
						+ "LIMIT 10, 5");
				// syntax LIMIT leave the # rows, then display # rows
				) {

			Tours.displayData(rs);
			
			
		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
		}

	}

}
