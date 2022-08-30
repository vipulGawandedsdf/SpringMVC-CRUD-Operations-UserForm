package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoimpl.HomeDao;
import com.app.model.User;
import com.app.serviceinterface.IService;

@Service
public class HomeService implements IService{

	@Autowired
	private HomeDao homeDao;
	
	
	@Override
	public int saveUser(User user) {
	int id =	homeDao.saveUser(user);
		return id;
	}


	@Override
	public int loginCheck(String uname, String password) {
	int id =	homeDao.loginCheck(uname, password);
		return id;
	}


	@Override
	public List<User> getAllUsers() {
	List<User> list=	homeDao.getAllUsers();
		return list;
	}


	@Override
	public List<User> deleteUser(int uid) {
		// TODO Auto-generated method stub
		return homeDao.deleteUser(uid);
	}


	@Override
	public User editUser(int uid) {
		
		return homeDao.editUser(uid);
	}


	@Override
	public List<User> updateUser(User user) {
		
		return homeDao.updateUser(user);
	}

}
