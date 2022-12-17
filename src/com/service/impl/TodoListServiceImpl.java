package com.service.impl;

import java.util.ArrayList;

import com.bean.T_todoList;
import com.dao.TodoListDao;
import com.factory.DaoFactory;
import com.service.TodoListService;

public class TodoListServiceImpl implements TodoListService{

	TodoListDao todoListDao = DaoFactory.createTotoListDao();
	
	@Override
	public int insert(T_todoList todoList) {
		return todoListDao.insert(todoList);
	}

	@Override
	public int delete(String id) {
		return todoListDao.delete(id);
	}

	@Override
	public ArrayList<T_todoList> queryByContent(String content, String user_id) {
		return todoListDao.queryByContent(content,user_id);
	}

	@Override
	public int updateContent(String id, String user_id, String newContent) {
		return todoListDao.updateContent(id, user_id, newContent);
	}

	@Override
	public ArrayList<T_todoList> queryByUserId(String userId) {
		return todoListDao.queryByUserId(userId);
	}

}
