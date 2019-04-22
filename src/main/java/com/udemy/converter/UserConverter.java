package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.User;
import com.udemy.model.UserModel;

@Component
public class UserConverter {
	
	public UserModel userTouserModel(User user) {
		UserModel userModel = new UserModel();
		userModel.setUserId(user.getUserId());
		userModel.setName(user.getName());
		userModel.setLastname(user.getLastname());
		userModel.setBithday(user.getBithday());
		userModel.setRole(user.getRole());
		return userModel;
	}
	
	public User userModelTouser(UserModel userModel) {
		User user = new User();
		user.setUserId(userModel.getUserId());
		user.setName(userModel.getName());
		user.setLastname(userModel.getLastname());
		user.setBithday(userModel.getBithday());
		user.setRole(userModel.getRole());
		return user;
	}

}
