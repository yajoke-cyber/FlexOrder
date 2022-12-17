package com.dao.Impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Tcatalog;
import com.dao.CatalogDao;
import com.dao.DB;

public class CatalogDaoImpl implements CatalogDao{

	@Override
	public int insert(Tcatalog catalog) {
		String sql="insert into t_catalog(id,name,del,detail) values(?,?,?,?)";
		Object[] params={catalog.getId(),catalog.getName(),catalog.getDel(),catalog.getDetail()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i = 0;
		try {
			i = mydb.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}

	@Override
	public int delete(String id) {
		String sql="update t_catalog set del='yes' where id=" + id;
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i = 0;
		try {
			i = mydb.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}

	@Override
	public ArrayList<Tcatalog> queryAll() {
		ArrayList<Tcatalog> catalogList = new ArrayList();
		String sql="select * from t_catalog where del='no'";
		Object[] params={};
		DB mydb=new DB();
		
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tcatalog catalog=new Tcatalog();
				catalog.setId(rs.getString("id"));
				catalog.setName(rs.getString("name"));
				catalog.setDetail(rs.getString("detail"));
				catalogList.add(catalog);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return catalogList;
	}

	@Override
	public Tcatalog queryById(String id) {
		String sql="select * from t_catalog where id = ? and del = 'no'";
		Object[] params={id};
		DB mydb=new DB();
		Tcatalog catalog = new Tcatalog(); 
		
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			if (rs == null) {
				mydb.closed();
				return null;
			}
			while(rs.next())
			{
				catalog.setId(rs.getString("id"));
				catalog.setName(rs.getString("name"));
				catalog.setDel(rs.getString("del"));
				catalog.setDetail(rs.getString("detail"));
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return catalog;
	}

}
