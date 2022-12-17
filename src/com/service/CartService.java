package com.service;

import java.util.ArrayList;

import com.bean.Tcart;


public interface CartService {
	public int insert(Tcart cart);
	public int delete(String id, String user_id);
	public int clearUserRecord(String user_id);
	public int updateStatus(String id);
	public int updateQuantity_Amount(String id, int goods_quantity, int gooos_price);
	public ArrayList<Tcart> queryUserCart(String user_id);
	public Tcart queryByUser_Goods(String user_id, String goods_id);
	public int queryAmount(String user_id);
	public ArrayList<Tcart> queryByOrderId(String order_id);
}
