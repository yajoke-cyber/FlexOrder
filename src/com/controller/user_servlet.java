package com.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.bean.Tcredit;
import com.bean.Tuser;
import com.bean.vo.MessageModel;
import com.factory.ServiceFactory;
import com.service.CreditService;
import com.service.UserService;
import com.util.QueryMapping;

public class user_servlet extends HttpServlet
{
	
	UserService userService = ServiceFactory.createUserService();
	CreditService creditService = ServiceFactory.createCreditService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		switch (type) {
			case "userLog":
				userLog(req, res);
				break;
			case "userReg":
				userReg(req,res);
				break;
			case "userMana":
				userMana(req, res);
				break;
			case "userLogout":
				userLogout(req, res);
				break;
			case "userDel":
				userDel(req, res);
				break;
			case "userDetail":
				userDetail(req, res);
				break;
			default:
				break;
		}
	}
	
	public void userLog(HttpServletRequest req,HttpServletResponse res) {
		String uname = req.getParameter("logUname");
		String pwd = req.getParameter("logPwd");
		Tuser user = userService.login(uname, pwd);
		if (user == null) {
			MessageModel result = new MessageModel();
			result.SetAttribute(0, "账户未注册或者密码错误", null);
			req.setAttribute("res", result);
			dispatch("/common/fail.jsp", req, res);
			return;
		}
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		dispatch("/site/index.jsp", req, res);
	}

	
	public void userReg(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String regName=req.getParameter("regUname");
		String regPwd=req.getParameter("regPwd");
		String del="no";
		
		boolean flag=userService.queryByloginName(regName);
		if(flag)
		{
			MessageModel result = new MessageModel();
			result.SetAttribute(0, "用户名重复，请重新注册", null);
			req.setAttribute("res", result);
			req.setAttribute("path", "site/userreg/userreg.jsp");
	        String targetURL = "/common/msg.jsp";
			dispatch(targetURL, req, res);
		}
		else
		{
			Tuser user = new Tuser();
			user.SetAttribute(id, regName, regPwd, regName, del);
			userService.insert(user);
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "注册成功", null);
			req.setAttribute("res", result);
			req.setAttribute("path", "site/logReg/user.jsp");
			String targetURL = "/common/success.jsp";
			dispatch(targetURL, req, res);
		}
	}
	
	
	
	public void userLogout(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		session.setAttribute("userType", null);
		session.setAttribute("user", null);
		
			
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "退出成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path", "site/logReg/user.jsp");
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void userMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		ArrayList<Tuser> userList=new ArrayList();
		userList = userService.queryAll();
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", userList);
		req.setAttribute("res", result);
		req.getRequestDispatcher("admin/user/userMana.jsp").forward(req, res);
	}
	
	
	
	public void userDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
        String id=req.getParameter("id");
		
        userService.delete(id);
		
        MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void userDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		ArrayList<Tuser> userList=new ArrayList();
		userList = userService.queryById(id);
		ArrayList<Tcredit> creditList = creditService.queryAll(id);
		
		MessageModel resultUserList = new MessageModel();
		resultUserList.SetAttribute(1, "操作成功", userList);
		req.setAttribute("resUserList", resultUserList);
		
		MessageModel resultCreditList = new MessageModel();
		resultCreditList.SetAttribute(1, "操作成功", creditList);
		req.setAttribute("resultCreditList", resultCreditList);
		
		req.getRequestDispatcher("admin/user/userDetail.jsp").forward(req, res);
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
