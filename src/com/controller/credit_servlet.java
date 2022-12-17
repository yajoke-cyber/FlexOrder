package com.controller;

import java.io.IOException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Tcredit;
import com.bean.vo.MessageModel;
import com.dao.DB;
import com.factory.ServiceFactory;
import com.service.CreditService;



public class credit_servlet extends HttpServlet
{
	
	CreditService creditService = ServiceFactory.createCreditService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        switch (type) {
			case "creditAdd":
				creditAdd(req, res);
				break;
			case "creditMana":
				creditMana(req, res);
				break;
			case "creditDel":
				creditDel(req, res);
				break;
			default:
				break;		
		}
	}
	
	//添加评价
	public void creditAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String attribute=req.getParameter("attribute").trim();
		String content=req.getParameter("content").trim();
		String time=req.getParameter("time").trim();
		
		String user_id=req.getParameter("user_id").trim();
		
		Tcredit credit = new Tcredit();
		credit.SetAttribute(id, attribute, content, time, user_id);
		
		creditService.insert(credit);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	//用户的所有评价
	public void creditMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String user_id=req.getParameter("user_id").trim();
		
		ArrayList<Tcredit> creditList=new ArrayList();
		creditList = creditService.queryAll(user_id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", creditList);
		req.setAttribute("res", result);
		req.getRequestDispatcher("admin/credit/creditMana.jsp").forward(req, res);
	}
	
	
	//删除评价
	public void creditDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id").trim();
		
		creditService.delete(id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
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
