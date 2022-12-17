package com.dao.Impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.bean.Tuser;
import com.dao.DB;
import com.dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public int insert(Tuser user) {
		String sql="insert into t_user values(?,?,?,?,?)";
		Object[] params={user.getId(),user.getLoginname(),user.getLoginname(),user.getLoginpw(),user.getDel()};
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
	public int update(Tuser user) {
		String sql="update t_user set loginname = ?, loginpw = ?  where id=?";
		Object[] params={user.getLoginname(),user.getLoginpw(), user.getId()};
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
		String sql="update t_user set del='yes' where id=?";
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
	public ArrayList<Tuser> queryAll() {
		ArrayList<Tuser> userList=new ArrayList();
		String sql="select * from t_user where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{	
				Tuser user = new Tuser();
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setDel(rs.getString("del"));
				
				userList.add(user);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return userList;
	}

	@Override
	public ArrayList<Tuser> queryById(String id) {
		ArrayList<Tuser> userList=new ArrayList();
		String sql="select * from t_user where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setDel(rs.getString("del"));
				
				userList.add(user);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return userList;
	}

	@Override
	public boolean queryByloginName(String loginName) {
		String sql="select * from t_user where loginname=?";
		Object[] params={loginName};
		DB mydb=new DB();
		boolean flag = false;
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{	
				mydb.closed();
				flag = true;
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return flag;
	}

	@Override
	public Tuser login(String loginName, String loginPw) {
		String sql="select * from t_user where loginname=? and loginpw=? and del='no'";
		Object[] params={loginName,loginPw};
		
		Tuser user=new Tuser();
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			boolean mark=(rs==null||!rs.next()?false:true);
			if(mark==false)
			{
				mydb.closed();
				return null;
			}
			if(mark==true)
			{	    
			     user.setId(rs.getString("id"));
				 user.setLoginname(rs.getString("loginname"));
				 user.setLoginpw(rs.getString("loginpw"));
				 user.setDel(rs.getString("del"));
				 user.setName(rs.getString("name"));
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return user;
	}
	
	
}
