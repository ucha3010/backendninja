package com.udemy.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
	
	public abstract User findByUserId(int userId);
	
	public abstract List<User> findByLastname(String lastname);
	
	public abstract List<User> findByNameOrderByLastname(String name);
	
	public abstract List<User> findByNameAndLastname(String name, String lastname);

}
