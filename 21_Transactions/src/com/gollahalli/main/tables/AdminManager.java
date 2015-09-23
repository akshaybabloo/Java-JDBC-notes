package com.gollahalli.main.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gollahalli.main.ConnectionManager;
import com.gollahalli.main.bean.Admin;


public class AdminManager {

	private static Connection conn = ConnectionManager.getInstance().getConnection();
	
	
	public static void displayAllRows() throws SQLException {

		String sql = "SELECT adminId, userName, password FROM admin";
		try (
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
		String sql = "SELECT * FROM admin WHERE adminId = ?";
		ResultSet rs = null;

		try (
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, adminId);
			rs = stmt.executeQuery();
			
		if (rs.next()) {
			Admin bean = new Admin();
			bean.setAdminId(adminId);
			bean.setUserName(rs.getString("userName"));
			bean.setPassword(rs.getString("password"));
			
			return bean;
			
		} else {
			return null;
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

	// this is the logic for inserting a row
	public static boolean insert(Admin bean) throws SQLException{
		String sql = "INSERT into admin (userName, password) VALUES (?,?)";
		// there are two inputs for this -> 2
		
		ResultSet keys = null;
		try(
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			stmt.setString(1, bean.getUserName());
			stmt.setString(2, bean.getPassword());
			int affected = stmt.executeUpdate();
			
			if (affected == 1) {
				keys = stmt.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				bean.setAdminId(newKey);
			} else {
				System.err.println("no row affected");
				return false;
			}
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally{
			if (keys != null) keys.close();
		}
		return true;
	}
	
	
	public static boolean update(Admin bean) throws SQLException{
		String sql = 
				"SELECT * FROM admin WHERE adminId = ?";
		ResultSet rs = null;
		try(
				PreparedStatement stmt = conn.prepareStatement(
						sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);) {
			
			stmt.setInt(1, bean.getAdminId());
			rs = stmt.executeQuery();

			if (rs.next()) {
				rs.updateString("userName", bean.getUserName());
				rs.updateString("password", bean.getPassword());
				rs.updateRow();
				return true;
			} else {
				return false;
			}
			
			
			}catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally{
			if (rs != null)	rs.close();
			
	}
}


	public static boolean delete(int adminId){
		String sql = 
				"DELETE FROM admin WHERE adminId = ?";
		
		try(
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setInt(1, adminId);
			
			int affected = stmt.executeUpdate();
			if (affected == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}

	