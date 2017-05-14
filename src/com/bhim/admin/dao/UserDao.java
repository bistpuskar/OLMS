package com.bhim.admin.dao;

import java.util.List;

import com.bhim.admin.entity.User;

public interface UserDao {
	
public List<User> getAllUser();
public void updateUser(User user);
public void addUser(User user);
public void deleteUser(int id);
public User getUser(String username);
public int getUserId();
public User login(User user);
public int countrecord();
}
