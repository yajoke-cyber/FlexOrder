package com.service.impl;

import java.util.ArrayList;

import com.bean.Tuser;
import com.dao.UserDao;
import com.factory.DaoFactory;
import com.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao = DaoFactory.createUserDao();
	
	@Override
	public int insert(Tuser user) {
		return userDao.insert(user);
	}

	@Override
	public int update(Tuser user) {
		return userDao.update(user);
	}

	@Override
	public int delete(String id) {
		return userDao.delete(id);
	}

	@Override
	public ArrayList<Tuser> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public ArrayList<Tuser> queryById(String id) {
		return userDao.queryById(id);
	}

	@Override
	public boolean queryByloginName(String loginName) {
		return userDao.queryByloginName(loginName);
	}

	@Override
	public Tuser login(String loginName, String loginPw) {
		return userDao.login(loginName, loginPw);
	}
	
}
