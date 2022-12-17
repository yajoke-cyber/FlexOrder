package com.service.impl;

import java.util.ArrayList;

import com.bean.Tcredit;
import com.dao.CreditDao;
import com.factory.DaoFactory;
import com.service.CreditService;


public class CreditServiceImpl implements CreditService{

	CreditDao creditDao = DaoFactory.creatCreditDao();
	
	@Override
	public int insert(Tcredit credit) {
		return creditDao.insert(credit);
	}

	@Override
	public int delete(String id) {
		return creditDao.delete(id);
	}

	@Override
	public ArrayList<Tcredit> queryAll(String user_id) {
		return creditDao.queryAll(user_id);
	}

}
