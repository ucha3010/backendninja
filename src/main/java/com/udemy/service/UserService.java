package com.udemy.service;

import java.util.List;

import com.udemy.model.UserModel;

public interface UserService {
	
	public abstract List<UserModel> listAllUsers();
	
	public abstract UserModel addUser(UserModel userModel);
	
	public abstract int removeUser(int id);
	
	public abstract UserModel updateUser(UserModel userModel);
	
	public abstract List<UserModel> findByLastname(String lastname);
	
	public abstract List<UserModel> findByName(String name);

}
