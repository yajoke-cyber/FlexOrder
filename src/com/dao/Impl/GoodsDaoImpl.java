package com.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Tgoods;
import com.dao.DB;
import com.dao.GoodsDao;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public int insert(Tgoods goods) {
		String del="no";
		String sql="insert into t_goods(id,catalog_id,showId,name,introduction,img,marketPrice,specialPrice,del) " +
				   "values(?,?,?,?,?,?,?,?,?)";
		Object[] params={goods.getId(),goods.getCatalog_id(),goods.getShowId(),goods.getName(),goods.getIntroduction(),goods.getImg(),goods.getMarketPrice(),goods.getSpecialPrice(),del};//Object[]定义一个一维对象，不需要强制类型转换
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
	public int update(Tgoods goods) {
		String sql="update t_goods set catalog_id=?,showId=?,name=?,introduction=?,img=?,marketPrice=?,specialPrice=? where id=?";
		Object[] params={goods.getCatalog_id(),goods.getShowId(),goods.getName(),goods.getIntroduction(),goods.getImg(),goods.getMarketPrice(),goods.getSpecialPrice(),goods.getId()};
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
		String sql="update t_goods set del='yes' where id="+id;
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
	public ArrayList<Tgoods> queryAll() {
		ArrayList<Tgoods> goodsList=new ArrayList();
		String sql="select * from t_goods where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgoods goods=new Tgoods();
				
				goods.setId(rs.getString("id"));
				goods.setCatalog_id(rs.getString("catalog_id"));
				goods.setShowId(rs.getString("showId"));
				
				goods.setName(rs.getString("name"));
				goods.setIntroduction(rs.getString("introduction"));
				goods.setImg(rs.getString("img"));
				
				goods.setMarketPrice(rs.getInt("marketPrice"));
				goods.setSpecialPrice(rs.getInt("specialPrice"));
				goods.setDel(rs.getString("del"));
				
				goodsList.add(goods);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return goodsList;
	}

	@Override
	public Tgoods queryById(String id) {
		Tgoods goods=new Tgoods();
		
		String sql="select * from t_goods where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			goods.setId(rs.getString("id"));
			goods.setCatalog_id(rs.getString("catalog_id"));
			goods.setShowId(rs.getString("showId"));
			
			goods.setName(rs.getString("name"));
			goods.setIntroduction(rs.getString("introduction"));
			goods.setImg(rs.getString("img"));
			
			goods.setMarketPrice(rs.getInt("marketPrice"));
			goods.setSpecialPrice(rs.getInt("specialPrice"));
			goods.setDel(rs.getString("del"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return goods;
	}

	@Override
	public ArrayList<Tgoods> queryByCataLog_id(String cataLog_id) {
		ArrayList<Tgoods> goodsList=new ArrayList();
		String sql="select * from t_goods where del='no' and catalog_id=? order by id desc";
		Object[] params={cataLog_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgoods goods=new Tgoods();
				
				goods.setId(rs.getString("id"));
				goods.setCatalog_id(rs.getString("catalog_id"));
				goods.setShowId(rs.getString("showId"));
				
				goods.setName(rs.getString("name"));
				goods.setIntroduction(rs.getString("introduction"));
				goods.setImg(rs.getString("img"));
				
				goods.setMarketPrice(rs.getInt("marketPrice"));
				goods.setSpecialPrice(rs.getInt("specialPrice"));
				goods.setDel(rs.getString("del"));
				
				goodsList.add(goods);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return goodsList;
	}

	@Override
	public ArrayList<Tgoods> queryByName(String name) {
		ArrayList<Tgoods> goodsList=new ArrayList();
		String sql="select * from t_goods where del='no' and name like '%"+name+"%'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgoods goods=new Tgoods();
				
				goods.setId(rs.getString("id"));
				goods.setCatalog_id(rs.getString("catalog_id"));
				goods.setShowId(rs.getString("showId"));
				
				goods.setName(rs.getString("name"));
				goods.setIntroduction(rs.getString("introduction"));
				goods.setImg(rs.getString("img"));
				
				goods.setMarketPrice(rs.getInt("marketPrice"));
				goods.setSpecialPrice(rs.getInt("specialPrice"));
				goods.setDel(rs.getString("del"));
				
				goodsList.add(goods);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return goodsList;
	}
	
}
