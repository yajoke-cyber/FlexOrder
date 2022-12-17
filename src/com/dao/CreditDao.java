package com.dao;

import java.util.ArrayList;

import com.bean.Tcredit;



public interface CreditDao {
	public int insert(Tcredit credit);
	public int delete(String id);
	public ArrayList<Tcredit> queryAll(String user_id);
}
