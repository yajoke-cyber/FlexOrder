package com.service;

import java.util.ArrayList;

import com.bean.Tgoods;

public interface GoodsService {
	public int insert(Tgoods goods);
	public int update(Tgoods goods);
	public int delete(String id);
	public ArrayList<Tgoods> queryAll();
	public Tgoods queryById(String id);
	public ArrayList<Tgoods> queryByCataLog_id(String cataLog_id);
	public ArrayList<Tgoods> queryByName(String name);
}
