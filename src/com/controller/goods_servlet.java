package com.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Tcatalog;
import com.bean.Tgoods;
import com.bean.vo.MessageModel;
import com.factory.ServiceFactory;
import com.service.CatalogService;
import com.service.GoodsService;


public class goods_servlet extends HttpServlet
{
	
	GoodsService goodsService = ServiceFactory.createGoodsService();
	CatalogService catalogService = ServiceFactory.createCatalogService();
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        switch (type) {
			case "goodsAdd":
				goodsAdd(req, res);
				break;
			case "goodsMana":
				goodsMana(req, res);
				break;
			case "goodsDel":
				goodsDel(req, res);
				break;
			case "goodsDetailBackend":
				goodsDetailBackend(req, res);
				break;
			case "goodsQueyById":
				goodsQueyById(req, res);
				break;
			case "goodsEdit":
				goodsEdit(req, res);
				break;
			case "goodsNew":
				goodsNew(req, res);
				break;
			case "goodsByCatalog":
				goodsByCatalog(req, res);
				break;
			case "goodsDetailFrontEnd":
				goodsDetailFrontEnd(req, res);
				break;
			case "goodsQueryByName":
				goodsQueryByName(req, res);
				break;
			case "goodsAddPage":
				goodsAddPage(req, res);
				break;
			case "goodsSearchPage":
				goodsSearchPage(req, res);
				break;
			case "goodsEditPage":
				goodsEditPage(req, res);
				break;
			default:
				break;
		}
	}
	//添加菜品
	public void goodsAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String catalogId=req.getParameter("catalog_id");
		String showId=req.getParameter("showId");
		String name=req.getParameter("name");
		
		String introduction=req.getParameter("introduction");
		String img=req.getParameter("img");
		int marketPrice=Integer.parseInt(req.getParameter("marketPrice"));
		System.out.println(catalogId);
		System.out.println(name);
		Tgoods goods = new Tgoods();
		goods.SetAttribute(id, catalogId, showId, name, introduction, img, marketPrice, marketPrice);
		goodsService.insert(goods);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	//菜品管理
	public void goodsMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		ArrayList<Tgoods> goodsList=new ArrayList();
		goodsList = goodsService.queryAll();
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", goodsList);
		req.setAttribute("res", result); 
		
		ArrayList<Tcatalog> cataLogList = new ArrayList<Tcatalog>();
		for(int i = 0; i < goodsList.size(); i++) {
			Tcatalog catalog = catalogService.queryById(goodsList.get(i).getCatalog_id());
			cataLogList.add(catalog);
		}
		MessageModel resultCatalog = new MessageModel();
		resultCatalog.SetAttribute(1, "操作成功", cataLogList);
		req.setAttribute("resCatalog", resultCatalog);
		
		dispatch("/back/goods/goodsManage.jsp",req, res);
	}
	//主页搜索页面
	public void goodsSearchPage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		MessageModel resultCatalog = new MessageModel();
		ArrayList<Tcatalog> catalogList = catalogService.queryAll();
		resultCatalog.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", resultCatalog);
		req.getRequestDispatcher("/site/goods/goodsSearch.jsp").forward(req, res);
	}
	//获取类别
		public void goodsAddPage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
		{
			System.out.println("goods");
			ArrayList<Tcatalog> catalogList=new ArrayList();
			catalogList = catalogService.queryAll();
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "操作成功", catalogList);
			req.setAttribute("res", result);
			dispatch("/back/goods/goodsAdd.jsp",req, res);
		}
	
	//菜品删除
	public void goodsDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		goodsService.delete(id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "删除成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path", req.getContextPath() + req.getContextPath() + "/back/gooods?type=goodsMana");
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	//菜品详情后台查看
	public void goodsDetailBackend(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		Tgoods goods = goodsService.queryById(id);
		Tcatalog catalog = catalogService.queryById(goods.getCatalog_id());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", goods);
		req.setAttribute("res", result);
		
		MessageModel resultCatalog = new MessageModel();
		resultCatalog.SetAttribute(1, "操作成功", goods);
		req.setAttribute("catalogName", catalog.getName());
		
		dispatch("/back/goods/goodsDetail.jsp",req, res);
	}
	
	//查询菜品通过id
	public void goodsQueyById(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id = req.getParameter("id");
		
		Tgoods goods = goodsService.queryById(id);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", goodsService.queryById(id));
		req.setAttribute("res", result);
		req.getRequestDispatcher("admin/goods/goodsPre.jsp").forward(req, res);
	}
	
	//菜品编辑
	public void goodsEdit(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String catalog_id=req.getParameter("catalog_id");
		String showId=req.getParameter("showId");
		String name=req.getParameter("name");
		
		String introduction=req.getParameter("introduction");
		String img=req.getParameter("img");
		int marketPrice=Integer.parseInt(req.getParameter("marketPrice"));
		int specialPrice=Integer.parseInt(req.getParameter("specialPrice"));

		Tgoods goods = new Tgoods();
		goods.SetAttribute(id, catalog_id, showId, name, introduction, img, marketPrice, specialPrice);
		goodsService.update(goods);
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		req.setAttribute("path", req.getContextPath() + "/back/gooods?type=goodsMana");
		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	//菜品编辑
		public void goodsEditPage(HttpServletRequest req,HttpServletResponse res)
		{
			String id=req.getParameter("id");
			Tgoods goods =  goodsService.queryById(id);
			MessageModel result = new MessageModel();
			result.SetAttribute(1, "操作成功", goods);
			req.setAttribute("res", result);
			dispatch("/back/goods.goodsEdit.jsp", req, res);
		}
	
	//首页菜品列表
	public void goodsNew(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List goodsList=new ArrayList();
		
		goodsList = goodsService.queryAll();
		
		if(goodsList.size()>4)
		{
			goodsList=goodsList.subList(0, 4);
		}
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", goodsList);
		req.setAttribute("res", result);
		List catalogList=new ArrayList();
		catalogList = catalogService.queryAll();
		MessageModel result2 = new MessageModel();
		result2.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", result2);
		req.getRequestDispatcher("/site/goods/goodsNew.jsp").forward(req, res);
	}
	
	//通过菜品分类查找菜品
	public void goodsByCatalog(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List goodsList=new ArrayList();
		MessageModel result = new MessageModel();
		String catalog_id = req.getParameter("catalog_id");
		goodsList = goodsService.queryByCataLog_id(catalog_id);
		result.SetAttribute(1, "操作成功", goodsList);
		req.setAttribute("res", result);
		MessageModel result2 = new MessageModel();
		List catalogList=new ArrayList();
		catalogList = catalogService.queryAll();
		result2.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", result2);
		req.getRequestDispatcher("/site/goods/goodsNew.jsp").forward(req, res);
	}
	
	//前台查询菜品信息
	public void goodsDetailFrontEnd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		Tgoods goods = goodsService.queryById(id);
		Tcatalog catalog = catalogService.queryById(goods.getCatalog_id());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", goods);
		req.setAttribute("res", result);
		
		MessageModel result2 = new MessageModel();
		List catalogList=new ArrayList();
		catalogList = catalogService.queryAll();
		result2.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", result2);
		req.getRequestDispatcher("site/goods/goodsDetailMoney.jsp").forward(req, res);
	}
	
	//通过名字查找菜品
	public void goodsQueryByName(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		
		ArrayList<Tgoods> goodsList = goodsService.queryByName(name.trim());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", goodsList);
		req.setAttribute("res", result);
		MessageModel resultCatalog = new MessageModel();
		ArrayList<Tcatalog> catalogList = catalogService.queryAll();
		resultCatalog.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", resultCatalog);
		req.getRequestDispatcher("/site/goods/goodsNew.jsp").forward(req, res);
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
