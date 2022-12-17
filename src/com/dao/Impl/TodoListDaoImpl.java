package com.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.T_todoList;
import com.dao.DB;
import com.dao.TodoListDao;

public class TodoListDaoImpl implements TodoListDao{

	@Override
	public int insert(T_todoList todoList) {
		String sql="insert into t_todoList(id,content,user_id) values(?,?,?)";
		Object[] params={todoList.getId(),todoList.getContent(),todoList.getUser_id()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);//ִ��sql��䣬�����ݿ������ɾ�Ĳ飬�����ֵ�������params��
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
		String sql="delete from t_todoList where id = ?";
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
	public ArrayList<T_todoList> queryByContent(String content, String user_id) {
		ArrayList<T_todoList> todoList=new ArrayList();
		String sql="select * from t_todoList where user_id = ? and content like '%"+content+"%'";
		Object[] params={user_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				T_todoList todo=new T_todoList();
				
				todo.setId(rs.getString("id"));
				todo.setContent(rs.getString("content"));
				todo.setUser_id(rs.getString("user_id"));
				
				todoList.add(todo);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return todoList;
	}

	@Override
	public int updateContent(String id ,String user_id, String newContent) {
		String sql="update t_todoList set content = ? where id=? and user_id = ?";
		Object[] params={newContent, id, user_id};
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
	public ArrayList<T_todoList> queryByUserId(String userId) {
		ArrayList<T_todoList> todoList=new ArrayList();
		String sql="select * from t_todoList where user_id = ?";
		Object[] params={userId};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				T_todoList todo=new T_todoList();
				
				todo.setId(rs.getString("id"));
				todo.setContent(rs.getString("content"));
				todo.setUser_id(rs.getString("user_id"));
				
				todoList.add(todo);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return todoList;
	}
}
