package com.service.impl;

import java.util.ArrayList;

import com.bean.Tcart;
import com.dao.CartDao;
import com.factory.DaoFactory;
import com.service.CartService;

public class CartServiceImpl implements CartService{

	CartDao cartDao = DaoFactory.createCartDao();
	
	@Override
	public int insert(Tcart cart) {
		return cartDao.insert(cart);
	}

	@Override
	public int delete(String id, String user_id) {
		return cartDao.delete(id,user_id);
	}

	@Override
	public int updateStatus(String id) {
		return 0;
		
	}

	@Override
	public ArrayList<Tcart> queryUserCart(String user_id) {
		return cartDao.queryUserCart(user_id);
	}

	@Override
	public Tcart queryByUser_Goods(String user_id, String goods_id) {
		return cartDao.queryByUser_Goods(user_id, goods_id);
	}

	@Override
	public int updateQuantity_Amount(String id, int goods_quantity, int gooos_price) {
		return cartDao.updateQuantity_Amount(id, goods_quantity, gooos_price);
	}

	@Override
	public int queryAmount(String user_id) {
		return cartDao.queryAmount(user_id);
	}

	@Override
	public ArrayList<Tcart> queryByOrderId(String order_id) {
		return cartDao.queryByOrderId(order_id);
	}

	@Override
	public int clearUserRecord(String user_id) {
		return cartDao.clearUserRecord(user_id);
	}
	
}
