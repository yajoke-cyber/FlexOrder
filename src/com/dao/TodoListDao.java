package com.dao;

import java.util.ArrayList;

import com.bean.T_todoList;

public interface TodoListDao {
	public int insert(T_todoList todoList);
	public int delete(String id);
	public ArrayList<T_todoList> queryByContent(String content, String user_id);
	public int updateContent(String id, String user_id, String newContent);
	public ArrayList<T_todoList> queryByUserId(String userId);
}
