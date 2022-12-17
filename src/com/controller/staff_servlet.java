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

import com.bean.Tstaff;
import com.bean.vo.MessageModel;
import com.factory.ServiceFactory;
import com.service.OrderService;
import com.service.StaffService;

public class staff_servlet extends HttpServlet{
	
	StaffService staffService = ServiceFactory.createStaffService();
	OrderService orderService = ServiceFactory.createOrderService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		switch (type) {
			case "stafflogin":
				stafflogin(req, res);
				break;
			case "adminReg":
				adminReg(req, res);
				break;
			case "adminUpdatePwd":
				adminUpdatePwd(req, res);
				break;
			case "addStaff":
				addStaff(req, res);
				break;
			case "deleteStaff":
				deleteStaff(req, res);
				break;
			case "staffMana":
				staffMana(req, res);
				break;
			case "AcceptOrder":
				AcceptOrder(req,res);
				break;
			case "staffLogout":
				staffLogout(req,res);
				break;
			case "staffEditPwd":
				staffEditPwd(req,res);
				break;
			
			case "staffEditPwdPage":
				staffEditPwd(req,res);
				break;
			default:
				break;
		}
	}
	
	public void staffEditPwd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		String newPwd = req.getParameter("newPwd");
		staffService.updatePwd(newPwd, staff.getId());
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path", "/back/index.jsp");
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void stafflogin(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		String uname = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		Tstaff staff = staffService.login(uname, pwd);
		if (staff == null) {
			MessageModel result = new MessageModel();
			result.SetAttribute(0, "密码错误", null);
			req.setAttribute("res", result);
			dispatch("/common/fail.jsp", req, res);
			req.setAttribute("path",  "/back/login/login.jsp");
			return;
		}
		HttpSession session = req.getSession();
		session.setAttribute("staff", staff);
		System.out.println(staff.getLevel());
		System.out.println(staff.getUserName());
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		dispatch("/back/index.jsp", req, res);
	}
	public void staffLogout(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("staff", null);
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "注销成功", null);
		req.setAttribute("res", result);
		dispatch("/back/login/login.jsp", req, res);
	}
	
	public void adminReg(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String id=String.valueOf(new Date().getTime());
		String uname = req.getParameter("logUname");
		String pwd = req.getParameter("logPwd");
		String level = "3";
		boolean flag=staffService.queryByloginName(uname);
		if(flag)
		{
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "用户名冲突，请重新注册", null);
			req.setAttribute("res", result);
			req.setAttribute("path",  "/back/login/login.jsp");
	        String targetURL = "/common/fail.jsp";
			dispatch(targetURL, req, res);
		}
		else
		{
			Tstaff staff = new Tstaff();
			staff.SetAttribute(id, uname, pwd, level);
			staffService.insert(staff);
			
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "操作成功", null);
			req.setAttribute("res", result);
			req.setAttribute("path", "site/default.jsp");
			
	        String targetURL = "/common/success.jsp";
			dispatch(targetURL, req, res);
		}
	}
	
	public void adminUpdatePwd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (staff.getLevel() != "3") {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			
			dispatch("", req, res);
			return;
		}
		
		String newPwd = req.getParameter("newPwd");
		String id = req.getParameter("id");
		staffService.updatePwd(newPwd, id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		dispatch("", req, res);
	}
	public void staffEditPwdPage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", staff.getId());
		req.setAttribute("res", result);
		dispatch("/back/editPwd", req, res);
	}
	
	public void addStaff(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (!staff.getLevel().equals("管理员")) {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);	
			dispatch("/common/fail.jsp", req, res);
			return;
		}
		String id=String.valueOf(new Date().getTime());
		String uname = req.getParameter("user_name");
		String pwd = req.getParameter("user_pwd");
		String level = req.getParameter("level");

		Tstaff newStaff = new Tstaff();
		newStaff.SetAttribute(id, uname, pwd, level);
		staffService.insert(newStaff);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "添加成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path",  req.getContextPath() + "/staff?type=staffMana");
		dispatch("/common/success.jsp", req, res);
	}
	
	public void deleteStaff(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (!staff.getLevel().equals("管理员") ){
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			req.setAttribute("path", req.getContextPath() +  "/staff?type=staffMana");
			dispatch("/common/fail.jsp", req, res);
			return;
		}
		
		String id = req.getParameter("id");
		
		staffService.delete(id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "删除成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path", req.getContextPath() + "/staff?type=staffMana");
		dispatch("/common/success.jsp", req, res);
	}
	
	public void staffMana(HttpServletRequest req,HttpServletResponse res) {
		ArrayList<Tstaff> staffList =staffService.queryAll();
		System.out.print("mana"+staffList.size());
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", staffList);
		req.setAttribute("res", result);
		dispatch("/back/staff/staffManage.jsp", req, res);
	}
	
	public void AcceptOrder(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (staff.getLevel().equals("店员")) {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			dispatch("/common/fail.jsp", req, res);
			return;
		}
		
		String orderId = req.getParameter("orderId");
		orderService.updateStatus(orderId, "已送达");
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path", req.getContextPath() + "/order?type=orderMana");
		dispatch("/common/success.jsp", req, res);
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
