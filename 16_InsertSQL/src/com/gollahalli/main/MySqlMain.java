package com.gollahalli.main;

import java.sql.SQLException;

import com.gollahalli.main.bean.Admin;
import com.gollahalli.main.tables.AdminManager;
import com.gollahalli.main.util.InputHelper;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
		// below is the code for asking for insertion
		Admin bean = new Admin();
		bean.setUserName(InputHelper.getInput("User name: "));
		bean.setPassword(InputHelper.getInput("Password: "));
		
		boolean result = AdminManager.insert(bean);
		
		if(result){
			// if the result is true which is 1 as it is a boolean function.
			System.out.println("new row with primary key " + bean.getAdminId() +" was inserted!");
			// get the new primary key in adminId row
		}
		
	}

}
