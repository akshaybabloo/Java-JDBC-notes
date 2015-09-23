package com.gollahalli.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlMain {

	public static void main(String[] args) throws SQLException {



		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM states");
		// this type is called try(with) catch block
				) {

			rs.last();
			System.out.println("numbers of rows is : " + rs.getRow());

			System.out.println("connection successful");

		} catch (SQLException e) {
			System.out.println("there was no connection!");
			DBUtil.processException(e);
		}

	}

}
