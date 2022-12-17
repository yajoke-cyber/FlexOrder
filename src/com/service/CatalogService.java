package com.service;

import java.util.ArrayList;

import com.bean.Tcatalog;

public interface CatalogService {
	public int insert(Tcatalog catalog);
	public int delete(String id);
	public ArrayList<Tcatalog> queryAll();
	public Tcatalog queryById(String id);
}
