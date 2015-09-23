package com.gollahalli.main.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gollahalli.main.DBType;
import com.gollahalli.main.DBUtil;
import com.gollahalli.main.bean.Admin;


public class AdminManager {

	public static void displayAllRows() throws SQLException {

		String sql = "SELECT adminId, userName, password FROM admin";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Admin Table:");
			while (rs.next()) {
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("adminId") + ": ");
				bf.append(rs.getString("userName") +", ");
				bf.append(rs.getString("password"));
				System.out.println(bf.toString());
			}
		}
	}

	public static Admin getRow(int adminId) throws SQLException {
		// i created a new static method row which takes in int value
		String sql = "SELECT * FROM admin WHERE adminId = ?";
		// give the sql syntax
		ResultSet rs = null;

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, adminId);
			// this adminId number id will be sent to the sql query 
			rs = stmt.executeQuery();
			// after sending the number then execute it and store it in ResultSet rs
			
		if (rs.next()) {
			Admin bean = new Admin();
			// create an no argument constructor 
			bean.setAdminId(adminId);
			// setAdminId takes the int value of adminId
			bean.setUserName(rs.getString("userName"));
			// takes the userName
			bean.setPassword(rs.getString("password"));
			// Takes the password
			
			return bean;
			// then give the out put of each
			
		} else {
			return null;
			// if nothing is found give nothing
		}
			
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} finally {
			if (rs != null) {
				rs.close();
			}
		}


	}

}
