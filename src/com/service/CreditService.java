package com.service;

import java.util.ArrayList;

import com.bean.Tcredit;

public interface CreditService {
	public int insert(Tcredit credit);
	public int delete(String id);
	public ArrayList<Tcredit> queryAll(String user_id);
}
