package com.dao;

import java.util.ArrayList;

import com.bean.Torder;

public interface OrderDao {
	public int insert(Torder order);
	public int delete(String id);
	public int updateStatus(String id, String newStatus);
	public int updateReply(String id, String reply);
	public ArrayList<Torder> queryAll();
	public ArrayList<Torder> queryByUser(String user_id);
}
