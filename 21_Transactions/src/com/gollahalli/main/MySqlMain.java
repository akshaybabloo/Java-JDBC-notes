package com.gollahalli.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.gollahalli.main.bean.Admin;
import com.gollahalli.main.tables.AdminManager;
import com.gollahalli.main.util.InputHelper;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		ConnectionManager.getInstance().setDBType(DBType.MYSQL);
		
		AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("select a row to be updated: ");
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		conn.setAutoCommit(false);
		// you are forcing JDBC to stop what ever it is doing to complete a query and listen to us
		
		Admin bean = AdminManager.getRow(adminId);
		if (bean == null) {
			System.err.println("row not found.");
			return;
		}
		
		String password = InputHelper.getInput("enter new password: ");
		bean.setPassword(password);
		if (AdminManager.update(bean)) {
			System.out.println("success!");
		} else {
			System.err.println("something went wrong!");
		}
				
		conn.commit();
		// if you use this you are telling JDBC that what ever you have done is correct
		// preceed with what ever the function is doing
		System.out.println("Transaction comitted");
		
//		conn.rollback();
		// this will undo what ever the input user is given
//		System.out.println("Transaction rolled backed");
		
		ConnectionManager.getInstance().close();
	}

}
