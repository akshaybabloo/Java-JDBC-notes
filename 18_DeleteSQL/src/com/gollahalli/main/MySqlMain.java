package com.gollahalli.main;

import java.sql.SQLException;

import com.gollahalli.main.tables.AdminManager;
import com.gollahalli.main.util.InputHelper;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("select a row to be deleted: ");
		// you take in the int value and put it in adminId
		
		if (AdminManager.delete(adminId)) {
			// and then goes to delete() method in AdminManager class
			System.out.println("row has been deleted");
		} else {
			System.err.println("nothing to delete");

		}
		
	}

}
