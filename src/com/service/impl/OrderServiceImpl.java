package com.service.impl;

import java.util.ArrayList;

import com.bean.Torder;
import com.dao.OrderDao;
import com.factory.DaoFactory;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	OrderDao orderDao = DaoFactory.createOrderDao();
	
	@Override
	public int insert(Torder order) {
		return orderDao.insert(order);
	}

	@Override
	public int delete(String id) {
		return orderDao.delete(id);
	}

	@Override
	public ArrayList<Torder> queryAll() {
		return orderDao.queryAll();
	}

	@Override
	public int updateStatus(String id, String newStatus) {
		return orderDao.updateStatus(id, newStatus);
	}

	@Override
	public int updateReply(String id, String reply) {
		return orderDao.updateReply(id, reply);
	}

	@Override
	public ArrayList<Torder> queryByUser(String user_id) {
		return orderDao.queryByUser(user_id);
	}
	
}
