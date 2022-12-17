package com.dao;

import java.util.ArrayList;

import com.bean.Tcatalog;


public interface CatalogDao {
	public int insert(Tcatalog catalog);
	public int delete(String id);
	public ArrayList<Tcatalog> queryAll();
	public Tcatalog queryById(String id);
}
