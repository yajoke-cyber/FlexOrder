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
import javax.servlet.http.HttpSession;

import com.bean.Tcatalog;
import com.bean.Tstaff;
import com.bean.vo.MessageModel;
import com.dao.DB;
import com.factory.ServiceFactory;
import com.service.CatalogService;


public class catalog_servlet extends HttpServlet
{
	CatalogService catalogService = ServiceFactory.createCatalogService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        switch (type) {
			case "catalogAdd":
				catalogAdd(req, res);
				break;
			case "catalogMana":
				catalogMana(req,res);
				break;
			case "catalogDel":
				catalogDel(req, res);
				break;
			default:
				break;
		}
	}
	//菜品列表
		public void catalogMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
		{
			ArrayList<Tcatalog> catalogList=new ArrayList();
			catalogList = catalogService.queryAll();
			
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "操作成功", catalogList);
			req.setAttribute("res", result);
			dispatch("/back/catalog/cataManage.jsp",req, res);
		}
	
	//添加菜品
	public void catalogAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		String id=String.valueOf(new Date().getTime());
		String name=req.getParameter("name").trim();
		String del="no";
		String detail = req.getParameter("detail");
		Tcatalog catalog = new Tcatalog();
		catalog.SetAttribute(id, name, del,detail);
 		catalogService.insert(catalog);
 		catalogMana(req,res);
	}
	
	//删除菜品
	public void catalogDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (!staff.getLevel().equals("店员") && !staff.getLevel().equals("管理员")) {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			catalogMana(req,res);
			return;
		}
		String id = req.getParameter("id");
		catalogService.delete(id);
		catalogMana(req,res);
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
