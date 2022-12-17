package com.service.impl;

import java.util.ArrayList;

import com.bean.TLeaveMsg;
import com.dao.LeaveMsgDao;
import com.factory.DaoFactory;
import com.service.LeaveMsgService;

public class LeaveMsgServiceImpl implements LeaveMsgService{

	LeaveMsgDao leaveMsgDao = DaoFactory.creatLeaveMsgDao();
	
	@Override
	public int insert(TLeaveMsg LeaveMsg) {
		return leaveMsgDao.insert(LeaveMsg);
	}

	@Override
	public int setReply(String reply, String replyTime, String id) {
		return leaveMsgDao.setReply(reply, replyTime, id);
	}

	@Override
	public int delete(String id) {
		return leaveMsgDao.delete(id);
	}

	@Override
	public ArrayList<TLeaveMsg> queryAll() {
		return leaveMsgDao.queryAll();
	}

	@Override
	public TLeaveMsg queryById(String id) {
		return leaveMsgDao.queryById(id);
	}
	
}
