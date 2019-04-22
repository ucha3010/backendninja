package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.converter.UserConverter;
import com.udemy.entity.User;
import com.udemy.model.UserModel;
import com.udemy.repository.UserJpaRepository;
import com.udemy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserModel> listAllUsers() {
		LOG.info("Servicio listAllUsers");
		List<User> userList = userJpaRepository.findAll();
		List<UserModel> userModelList = new ArrayList<UserModel>();
		for(User user : userList){
			userModelList.add(userConverter.userTouserModel(user));
		}
		return userModelList;
	}

	@Override
	public UserModel addUser(UserModel userModel) {
		LOG.info("Servicio addUser");
		User user = userConverter.userModelTouser(userModel);
		return userConverter.userTouserModel(userJpaRepository.save(user));
	}

	@Override
	public int removeUser(int id) {
		LOG.info("Servicio removeUser");
		User user = null;
		int usersDeleted = 1;
		try{
			if(id > 0){
				user = userJpaRepository.findByUserId(id);
			}
			if(user != null){
				userJpaRepository.delete(user);
			} 
		} catch (Exception e){
			usersDeleted = 0;
		}
		return usersDeleted;
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		LOG.info("Servicio updateUser");
		return addUser(userModel);
	}

	@Override
	public List<UserModel> findByLastname(String lastname) {
		LOG.info("Servicio findByLastname");
		List<User> userList = userJpaRepository.findByLastname(lastname);
		List<UserModel> userModelList = new ArrayList<UserModel>();
		for(User user : userList){
			userModelList.add(userConverter.userTouserModel(user));
		}
		return userModelList;
	}

	@Override
	public List<UserModel> findByName(String name) {
		LOG.info("Servicio findByName");
		List<User> userList = userJpaRepository.findByNameOrderByLastname(name);
		List<UserModel> userModelList = new ArrayList<UserModel>();
		for(User user : userList){
			userModelList.add(userConverter.userTouserModel(user));
		}
		return userModelList;
	}

}
