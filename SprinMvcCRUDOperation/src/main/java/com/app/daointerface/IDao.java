package com.app.daointerface;

import java.util.List;

import com.app.model.User;

public interface IDao {

	public int saveUser(User user);
	
	public int loginCheck(String uname, String password);
	
	public List<User> getAllUsers();
	
	public List<User> deleteUser(int uid);
	
	public User editUser(int uid);
	
	public List<User> updateUser(User user);
}
