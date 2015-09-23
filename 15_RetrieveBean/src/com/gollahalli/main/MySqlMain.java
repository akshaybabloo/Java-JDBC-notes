package com.gollahalli.main;

import java.sql.SQLException;

import com.gollahalli.main.bean.Admin;
import com.gollahalli.main.tables.AdminManager;
import com.gollahalli.main.util.InputHelper;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		// AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("Select a row: ");
		// but using the custom method class InputHelper we use its custom method to
		// convert the input int into string
		
		Admin bean = AdminManager.getRow(adminId);
		// creates a getter and uses AdminManager and its custom method and stores it in bean
		
		
		if(bean == null){
			System.err.println("no rows were found");
			// if there is nothing stored in the bean then give out error
		} else{
			// else give these out puts
			System.out.println("Admin Id: " + bean.getAdminId());
			System.out.println("User Id: " + bean.getUserName());
			System.out.println("password: " + bean.getPassword());
			
		}
		
	}

}
