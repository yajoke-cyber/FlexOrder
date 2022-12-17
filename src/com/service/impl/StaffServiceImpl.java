package com.service.impl;

import java.util.ArrayList;

import com.bean.Tstaff;
import com.dao.StaffDao;
import com.factory.DaoFactory;
import com.service.StaffService;

public class StaffServiceImpl implements StaffService{

	StaffDao staffDao = DaoFactory.createStaffDao();
	
	@Override
	public int insert(Tstaff staff) {
		return staffDao.insert(staff);
	}

	@Override
	public int delete(String id) {
		return staffDao.delete(id);
	}

	@Override
	public int updatePwd(String newPwd, String id) {
		return staffDao.updatePwd(newPwd, id);
	}

	@Override
	public Tstaff login(String userName, String pwd) {
		return staffDao.login(userName, pwd);
	}

	@Override
	public ArrayList<Tstaff> queryAll() {
		return staffDao.queryAll();
	}

	@Override
	public boolean queryByloginName(String loginName) {
		return staffDao.queryByloginName(loginName);
	}

	
	
}
