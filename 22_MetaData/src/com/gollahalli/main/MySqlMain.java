package com.gollahalli.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionManager.getInstance().getConnection();
		ResultSet rsTables = null;
		
		try {
			DatabaseMetaData metadata = conn.getMetaData();
			// creating a constructor for metadata
			String[] tableTypes = {"TABLE"};
			// an array to tableType where you put TABLE into it
			// TABLE is a MySQL way for asking the contents in a given table
			rsTables = metadata.getTables(null, "%", "%", tableTypes);
			// putting the values in ResultSet rsTables
			// syntax of getTables(where, from what, name of table in db, from all db)
			while (rsTables.next()) {
				// when there is a next available line do the following
				System.out.println(rsTables.getString("TABLE_NAME"));
				// get the table name from the database
				// see ConnectionManager.java for which table
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			rsTables.close();
		}
		
		
		
		ConnectionManager.getInstance().close();
	}

}
