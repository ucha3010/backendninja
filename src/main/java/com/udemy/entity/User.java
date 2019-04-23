package com.udemy.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user_security")
public class User {

	private int userId;
	private String name;
	private String lastname;
	private Date bithday;
	private String role;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Length(max = 45)
	private String username;

	@NotNull
	@Length(max = 256)
	private String password;

	private boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public User() {

	}

	public User(int userId, String name, String lastname, Date bithday, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.lastname = lastname;
		this.bithday = bithday;
		this.role = role;
	}

	public User(@Length(max = 45) String username, @NotNull @Length(max = 256) String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(@Length(max = 45) String username, @NotNull @Length(max = 256) String password, boolean enabled,
			Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", lastname=" + lastname + ", bithday=" + bithday
				+ ", role=" + role + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", userRole=" + userRole + "]";
	}

}
