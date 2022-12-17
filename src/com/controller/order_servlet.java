package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Torder;
import com.bean.Tstaff;
import com.bean.vo.MessageModel;
import com.dao.DB;
import com.factory.ServiceFactory;
import com.service.OrderService;


public class order_servlet extends HttpServlet
{
	
	OrderService orderService = ServiceFactory.createOrderService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        switch (type) {
			case "orderMana":
				orderMana(req, res);
				break;
			case "orderDel":
				orderDel(req, res);
				break;
			case "orderAccept":
				orderAccept(req, res);
				break;
			case "replyAdd":
				replyAdd(req, res);
				break;
			default:
				break;
		}
	}
	
	//订单管理
	public void orderMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List orderList=new ArrayList();
		orderList = orderService.queryAll();
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", orderList);
		req.setAttribute("res", result);
		dispatch("/back/order/orderManage.jsp",req, res);
	}
	
	//订单删除
	public void orderDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
        String id=req.getParameter("id");
        if (!staff.getLevel().equals("管理员")) {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			dispatch("/common/fail.jsp", req, res);
			return;
		}
		orderService.delete(id);
		orderMana(req, res);
	}
	
	//订单出餐
	public void orderAccept(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (staff.getLevel().equals("骑手")) {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			dispatch("/common/fail.jsp", req, res);
			return;
		}
        String id=req.getParameter("id");
		orderService.updateStatus(id,"已出餐");
		orderMana(req, res);
		
	}
	
	//添加回复
	public void replyAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
        String id=req.getParameter("id");
        String reply=req.getParameter("relpy");
		
        orderService.updateReply(id, reply);
		
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
