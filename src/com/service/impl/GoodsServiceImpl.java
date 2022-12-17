package com.service.impl;

import java.util.ArrayList;

import com.bean.Tgoods;
import com.dao.GoodsDao;
import com.factory.DaoFactory;
import com.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{

	GoodsDao goodsDao = DaoFactory.createGoodsDao();
	@Override
	public int insert(Tgoods goods) {
		return goodsDao.insert(goods);
	}

	@Override
	public int update(Tgoods goods) {
		return goodsDao.update(goods);
	}

	@Override
	public int delete(String id) {
		return goodsDao.delete(id);
	}

	@Override
	public ArrayList<Tgoods> queryAll() {
		return goodsDao.queryAll();
	}

	@Override
	public Tgoods queryById(String id) {
		return goodsDao.queryById(id);
	}

	@Override
	public ArrayList<Tgoods> queryByCataLog_id(String cataLog_id) {
		return goodsDao.queryByCataLog_id(cataLog_id);
	}

	@Override
	public ArrayList<Tgoods> queryByName(String name) {
		return goodsDao.queryByName(name);
	}

}
