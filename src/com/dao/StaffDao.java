package com.dao;

import java.util.ArrayList;

import com.bean.Tstaff;

public interface StaffDao {
	public int insert(Tstaff staff);
	public int delete(String id);
	public int updatePwd(String newPwd, String id);
	public boolean queryByloginName(String loginName);
	public Tstaff login(String userName, String pwd);
	public ArrayList<Tstaff> queryAll();
}
