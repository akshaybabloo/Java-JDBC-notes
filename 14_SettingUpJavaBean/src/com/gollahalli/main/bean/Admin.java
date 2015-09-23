package com.gollahalli.main.bean;


public class Admin {
// java says that a bean should have an "implements Serializable"
// for this application we don't need this
	
	private int adminId;
	private String userName;
	private String password;
	
	public int getAdminId() {
		return adminId;
		// this gets the adminId
	}
	public void setAdminId(int adminId) {
		// void because it dosent return anything
		this.adminId = adminId;
		// and this sets the adminId to itself
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
