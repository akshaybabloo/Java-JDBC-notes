package com.gollahalli.main;

import java.sql.SQLException;

import com.gollahalli.main.tables.AdminManager;
import com.gollahalli.main.util.InputHelper;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		// Explicitly using MYSQL
		ConnectionManager.getInstance().setDBType(DBType.MYSQL);
		// ConnectionManager.getInstance().getConnection();
		
		AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("select a row to be deleted: ");
		
		
		if (AdminManager.delete(adminId)) {
			System.out.println("row has been deleted");
		} else {
			System.err.println("nothing to delete");

		}
		
		ConnectionManager.getInstance().close();
		// closing connection
	}

}
