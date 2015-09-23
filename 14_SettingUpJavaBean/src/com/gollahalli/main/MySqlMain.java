package com.gollahalli.main;

import java.sql.SQLException;

import com.gollahalli.main.tables.AdminManager;


public class MySqlMain {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
	}

}
