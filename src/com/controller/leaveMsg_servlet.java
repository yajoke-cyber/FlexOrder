package com.controller;

import java.io.IOException;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TLeaveMsg;
import com.bean.Tcatalog;
import com.bean.Tstaff;
import com.bean.Tuser;
import com.bean.vo.MessageModel;
import com.dao.DB;
import com.factory.ServiceFactory;
import com.service.CatalogService;
import com.service.LeaveMsgService;


public class leaveMsg_servlet extends HttpServlet
{
	LeaveMsgService leaveMsgService = ServiceFactory.createLeaveMsgService();
	CatalogService catalogService = ServiceFactory.createCatalogService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        switch (type) {
			case "leaveMsgAdd":
				leaveMsgAdd(req, res);
				break;
			case "leaveMsgMana":
				leaveMsgMana(req, res);
				break;
			case "leaveMsgDel":
				leaveMsgDel(req, res);
				break;
			case "leaveMsgReply":
				leaveMsgReply(req, res);
				break;
			case "leaveMsgAll":
				leaveMsgAll(req, res);
				break;
			case "leaveMsgDetail":
				leaveMsgDetail(req, res);
				break;
			case "leaveMsgBackPage":
				leaveMsgBackPage(req, res);
				break;
			default:
				break;
		}
	}
	
	
	
	//管理留言
	public void leaveMsgMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		ArrayList<TLeaveMsg> leaveMsgList=new ArrayList();
		leaveMsgList = leaveMsgService.queryAll();	
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", leaveMsgList);
		req.setAttribute("res", result);
		ArrayList<Tcatalog> catalogList = catalogService.queryAll();
		cartService.queryAmount("123");
		resultCatalog.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", resultCatalog);
		dispatch("/back/leaveMsg/leaveMsg.jsp",req, res);
	}
	
	//删除留言
	public void leaveMsgDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id = req.getParameter("id");
		
		leaveMsgService.delete(id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	//回复留言
	public void leaveMsgReply(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		Tstaff staff=(Tstaff)session.getAttribute("staff");
		if (staff.getLevel() != "0" && staff.getLevel() != "1") {
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "无权限进行操作", null);
			req.setAttribute("res", result);
			
			dispatch("", req, res);
			return;
		}
		
		String reply=req.getParameter("reply");
		String replyTime=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		String id=req.getParameter("id");
		
		leaveMsgService.setReply(reply, replyTime, id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}

	//所有留言信息
	public void leaveMsgBackPage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		ArrayList<TLeaveMsg> leaveMsgList=new ArrayList();
		leaveMsgList = leaveMsgService.queryAll();	
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", leaveMsgList);
		req.setAttribute("res", result);
		dispatch("/back/leaveMsg/leaveMsg.jsp",req, res);
	}
	//所有留言信息
		public void leaveMsgAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
		{
			ArrayList<TLeaveMsg> leaveMsgList=new ArrayList();
			System.out.print("servlet");
			leaveMsgList = leaveMsgService.queryAll();	
			System.out.print("servlet"+leaveMsgList.get(0).getContent());
			
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "操作成功", leaveMsgList);
			req.setAttribute("res", result);
			//设置侧边栏
			MessageModel resultCatalog = new MessageModel();
			ArrayList<Tcatalog> catalogList = catalogService.queryAll();
			resultCatalog.SetAttribute(1, "操作成功", catalogList);
			req.setAttribute("resCatalog", resultCatalog);
			dispatch("/site/leaveMsg/leaveMsgAll.jsp",req, res);
		}
	//添加回复
		public void leaveMsgAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
		{
			
			HttpSession session=req.getSession();
			Tuser user=(Tuser)session.getAttribute("user");
			
			String content=req.getParameter("content");
			String leaveMsgTime=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
			String user_id=user.getId();
			String reply="";
			String replyTime="";
			
			TLeaveMsg leaveMsg = new TLeaveMsg();
			leaveMsg.SetAttribute(content, leaveMsgTime, user_id, reply, replyTime);
			leaveMsgService.insert(leaveMsg);
	        leaveMsgAll(req,res);
		}
	//留言信息
	public void leaveMsgDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id= req.getParameter("id");
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", leaveMsgService.queryById(id));
		req.setAttribute("res", result);
		req.getRequestDispatcher("/site/leaveMsg/leaveMsgDetail.jsp").forward(req, res);
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
