package com.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.bean.Torder;
import com.bean.Tstaff;
import com.bean.Tuser;
import com.dao.DB;
import com.dao.StaffDao;

public class StaffDaoImpl implements StaffDao{

	@Override
	public int delete(String id) {
		String sql="delete from t_staff where id="+id;
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
	public int updatePwd(String newPwd, String id) {
		String sql="update t_staff set user_pwd = ? where id=?";
		Object[] params={newPwd,id};
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
	public Tstaff login(String userName, String pwd) {
		String sql="select * from t_staff where user_name=? and user_pwd=?";
		Object[] params={userName,pwd};
		Tstaff staff=new Tstaff();
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
			     staff.setId(rs.getString("id"));
				 staff.setUserName(rs.getString("user_name"));
				 staff.setUserPwd(rs.getString("user_pwd"));
				 staff.setLevel(rs.getString("level"));
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return staff;
	}

	@Override
	public int insert(Tstaff staff) {
		String sql="insert into t_staff values(?,?,?,?)";
		Object[] params={staff.getId(), staff.getUserName(),staff.getUserPwd(), staff.getLevel()};
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
	public ArrayList<Tstaff> queryAll() {
		ArrayList<Tstaff> staffList = new ArrayList<Tstaff>(); 
		String sql="select * from t_staff";
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
                Tstaff staff=new Tstaff();
				
				staff.setId(rs.getString("id"));
				staff.setUserName(rs.getString("user_name"));
				staff.setUserPwd(rs.getString("user_pwd"));
				staff.setLevel(rs.getString("level"));
				
				staffList.add(staff);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		mydb.closed();
		return staffList;
	}

	@Override
	public boolean queryByloginName(String loginName) {
		String sql="select * from t_staff where user_name=?";
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

}
