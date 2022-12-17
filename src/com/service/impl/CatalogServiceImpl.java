package com.service.impl;

import java.util.ArrayList;

import com.bean.Tcatalog;
import com.dao.CatalogDao;
import com.factory.DaoFactory;
import com.service.CatalogService;

public class CatalogServiceImpl implements CatalogService{

	CatalogDao catalogDao = DaoFactory.createCatalogDao();
	
	@Override
	public int insert(Tcatalog catalog) {
		return catalogDao.insert(catalog);
	}

	@Override
	public int delete(String id) {
		return catalogDao.delete(id);
	}

	@Override
	public ArrayList<Tcatalog> queryAll() {
		return catalogDao.queryAll();
	}

	@Override
	public Tcatalog queryById(String id) {
		return catalogDao.queryById(id);
	}

}
