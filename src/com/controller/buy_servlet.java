package com.controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Tcart;
import com.bean.Tcatalog;
import com.bean.Tgoods;
import com.bean.Torder;
import com.bean.Tuser;
import com.bean.vo.MessageModel;
import com.factory.ServiceFactory;
import com.service.CartService;
import com.service.CatalogService;
import com.service.GoodsService;
import com.service.OrderService;


public class buy_servlet extends HttpServlet
{
	GoodsService goodsService = ServiceFactory.createGoodsService();
	CartService cartService = ServiceFactory.createCartService();
	OrderService orderService = ServiceFactory.createOrderService();
	CatalogService catalogService = ServiceFactory.createCatalogService();
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        switch (type) {
        	case "addToCart":
        		addToCart(req, res);
        		break;
        	case "deleteCart":
        		deleteCart(req,res);
        		break;
        	case "clearCart":
        		clearCart(req, res);
        		break;
        	case "orderSubmit":
        		orderSubmit(req, res);
        		break;
        	case "myorder":
        		myorder(req, res);
        		break;
        	case "orderDetail":
        		orderDetail(req, res);
        		break;
        	case "myCartPage":
        		myCartPage(req, res);
        		break;
        	default:
				break;
        }
	}
	//购物车页面		
			public void myCartPage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
				HttpSession session=req.getSession();
				Tuser user=(Tuser)session.getAttribute("user");
				
				ArrayList<Tcart> cartList = cartService.queryUserCart(user.getId());
				
				MessageModel result = new MessageModel();
				result.SetAttribute(1, "操作成功", cartList);
				req.setAttribute("res", result);
				
				MessageModel resultGoodSName = new MessageModel();
				ArrayList<Tgoods> goodsList = new ArrayList();
				for (int i = 0; i < cartList.size(); i++) {
					goodsList.add(goodsService.queryById(cartList.get(i).getGoods_id()));
				}
				resultGoodSName.SetAttribute(1, "操作成功", goodsList);
				req.setAttribute("resCatalog", resultGoodSName);
				
				MessageModel resultCatalog = new MessageModel();
				ArrayList<Tcatalog> catalogList = catalogService.queryAll();
				resultCatalog.SetAttribute(1, "操作成功", catalogList);
				req.setAttribute("resCatalog", resultCatalog);
				dispatch("/site/cart/mycart.jsp", req, res);
			}
	//增加到购物车
			
	public void addToCart(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{	
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		System.out.println("addToCart");
		String id=String.valueOf(new Date().getTime());
		String goods_id=req.getParameter("goods_id");
		int quantity= Integer.parseInt(req.getParameter("quantity"));
		Tgoods goods=goodsService.queryById(goods_id);
		Tcart cart = cartService.queryByUser_Goods(user.getId(), goods_id);
		System.out.println(goods_id);
		System.out.println(user.getId());
		System.out.println(cart.getId());
		if (cart.getId() == null) {
			cart.SetAttribute(id, "",goods_id, quantity, user.getId(), quantity * goods.getMarketPrice());
			cartService.insert(cart);
		} else {
			cartService.updateQuantity_Amount(id, quantity, goods.getMarketPrice());
		}
		MessageModel resultCatalog = new MessageModel();
		ArrayList<Tcatalog> catalogList = catalogService.queryAll();
		resultCatalog.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", resultCatalog);
		dispatch("/site/cart/mycart.jsp", req, res);
		
	}
	
	//删除购物车
	public void deleteCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		cartService.delete(id, user.getId());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		myCartPage(req,res);
	}
	
	//清空购物车
	public void clearCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		cartService.clearUserRecord(user.getId());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		myCartPage(req,res);
	}
	
	
	//提交订单
	public void orderSubmit(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String deliveryAddress=req.getParameter("deliveryAddress");
		String paymentMethod=req.getParameter("paymentMethod");
		
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		Torder order=new Torder();
		
		order.setId(String.valueOf(new Date().getTime()));
		order.setShowId(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		order.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		order.setStatus("已支付");
		
		order.setReply("");
		
		order.setDeliveryAddress(deliveryAddress);
		order.setPaymentMethod(paymentMethod);
		order.setAmount(cartService.queryAmount(user.getId()));
		order.setUser_id(user.getId());
		
		orderService.insert(order);
		cartService.clearUserRecord(user.getId());
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", null);
		req.setAttribute("res", result);
		req.getRequestDispatcher("site/order/orderSubmit.jsp").forward(req, res);
	}
	
	//用户的订单
	public void myorder(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", orderService.queryByUser(user.getId()));
		req.setAttribute("res", result);
		//设置侧边栏
		MessageModel resultCatalog = new MessageModel();
		ArrayList<Tcatalog> catalogList = catalogService.queryAll();
		resultCatalog.SetAttribute(1, "操作成功", catalogList);
		req.setAttribute("resCatalog", resultCatalog);
		req.getRequestDispatcher("site/order/myorder.jsp").forward(req, res);
	}
	
	//订单详情
	public void orderDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String order_id=req.getParameter("order_id");	
		System.out.println(order_id+"DD");
		MessageModel result = new MessageModel();
		result.SetAttribute(1, "操作成功", cartService.queryByOrderId(order_id));
		req.setAttribute("res", result);
		req.getRequestDispatcher("site/order/orderDetail.jsp").forward(req, res);
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
