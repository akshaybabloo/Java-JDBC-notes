package com.gollahalli.main;

import java.sql.SQLException;

import com.gollahalli.main.bean.Admin;
import com.gollahalli.main.tables.AdminManager;
import com.gollahalli.main.util.InputHelper;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("select a row to update: ");
		// takes the input of the row number primary key
		
		Admin bean = AdminManager.getRow(adminId);
		// takes the int value and goes to getRow method in AdminManager class
		// the out value is saved in bean
		if (bean == null) {
			System.err.println("row not found.");
			return;
		}
		
		String password = InputHelper.getInput("enter new password: ");
		// takes in the user input and stors it in the password field
		bean.setPassword(password);
		// updates a new password
		if (AdminManager.update(bean)) {
			System.out.println("success!");
		} else {
			System.err.println("something went wrong!");
		}
		
		// the below code is to update your user id as well.
		
//		String userName = InputHelper.getInput("enter new password: ");
//		bean.setUserName(userName);
//		if (AdminManager.update(bean)) {
//			System.out.println("success!");
//		} else {
//			System.err.println("something went wrong!");
//		}
//		
		
	}

}
