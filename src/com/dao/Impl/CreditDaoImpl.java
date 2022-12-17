package com.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.bean.Tcredit;
import com.dao.CreditDao;
import com.dao.DB;

public class CreditDaoImpl implements CreditDao{

	@Override
	public int insert(Tcredit credit) {
		String sql="insert into t_credit(id,attribute,content,time,user_id) values(?,?,?,?,?)";
		Object[] params={credit.getId(),credit.getAttribute(),credit.getContent(),credit.getTime(),credit.getUser_id()};
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
		String sql="delete from t_credit where id=?";
		Object[] params={id};
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
	public ArrayList<Tcredit> queryAll(String user_id) {
		ArrayList<Tcredit> creditList=new ArrayList();
		String sql="select * from t_credit where user_id=?";
		Object[] params={user_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tcredit credit=new Tcredit();
				
				credit.setId(rs.getString("id"));
				credit.setAttribute(rs.getString("attribute"));
				credit.setContent(rs.getString("content"));
				credit.setTime(rs.getString("time"));
				
				credit.setUser_id(rs.getString("user_id"));
				
				creditList.add(credit);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return creditList;
	}

}
