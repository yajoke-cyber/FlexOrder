package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.T_todoList;
import com.bean.Tuser;
import com.bean.vo.MessageModel;
import com.factory.ServiceFactory;
import com.service.TodoListService;

public class todoList_servlet extends HttpServlet {
	
	TodoListService todoListService = ServiceFactory.createTodoListService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		 
		String type=req.getParameter("type");
		 
		switch (type) {
			case "todoListInsert":
				todoListInsert(req, res);
				break;
			case "todoListDelete":
				todoListDelete(req, res);
				break;
			case "todoListQueryContent":
				todoListQueryContent(req, res);
				break;
			case "todoListQueryByUser":
				todoListQueryByUser(req, res);
				break;
			case "todoListUpdate":
				todoListUpdate(req, res);
				break;
			default:
				break;
		}
		 
	}
	
	// 新增备忘录
	public void todoListInsert(HttpServletRequest req,HttpServletResponse res) {
		String id=String.valueOf(new Date().getTime());
		String content = req.getParameter("content");
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
	
		T_todoList todoList = new T_todoList();
		todoList.SetAttribute(id, content, user.getId());
		todoListService.insert(todoList);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		dispatch("", req, res);
	}
	
	//删除备忘录
	public void todoListDelete(HttpServletRequest req,HttpServletResponse res) {
		String id = req.getParameter("id");
		
		todoListService.delete(id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		dispatch("", req, res);
	}
	
	//通过内容查询
	public void todoListQueryContent(HttpServletRequest req,HttpServletResponse res) {
		String content = req.getParameter("content");
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		ArrayList<T_todoList> todoLists = new ArrayList();
		todoLists = todoListService.queryByContent(content, user.getId());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", todoLists);
		req.setAttribute("res", result);
		dispatch("", req, res);
	}
	
	//查找该用户的备忘录
	public void todoListQueryByUser(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		ArrayList<T_todoList> todoLists = new ArrayList();
		todoLists = todoListService.queryByUserId(user.getId());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", todoLists);
		req.setAttribute("res", result);
		dispatch("", req, res);
	}
	
	//修改内容
	public void todoListUpdate(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		
		todoListService.updateContent(id,user.getId(),content);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		dispatch("", req, res);
	}

	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
