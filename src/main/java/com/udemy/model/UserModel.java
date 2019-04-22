package com.udemy.model;

import java.util.Date;

public class UserModel {

	private int userId;
	private String name;
	private String lastname;
	private Date bithday;
	private String role;

	public UserModel() {

	}

	public UserModel(int userId, String name, String lastname, Date bithday, String role) {
		this.userId = userId;
		this.name = name;
		this.lastname = lastname;
		this.bithday = bithday;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBithday() {
		return bithday;
	}

	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", lastname=" + lastname + ", bithday=" + bithday
				+ ", role=" + role + "]";
	}

}
