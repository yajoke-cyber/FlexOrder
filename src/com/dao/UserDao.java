package com.dao;

import java.util.ArrayList;

import com.bean.Tuser;

public interface UserDao {
	public int insert(Tuser user);
	public int update(Tuser user);
	public int delete(String id);
	public ArrayList<Tuser> queryAll();
	public ArrayList<Tuser> queryById(String id);
	public boolean queryByloginName(String loginName);
	public Tuser login(String loginName, String loginPw);
}
