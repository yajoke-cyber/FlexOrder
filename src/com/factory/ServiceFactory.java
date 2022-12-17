package com.factory;

import com.service.CartService;


import com.service.CatalogService;
import com.service.CreditService;
import com.service.GoodsService;
import com.service.LeaveMsgService;
import com.service.OrderService;
import com.service.StaffService;
import com.service.TodoListService;
import com.service.UserService;
import com.service.impl.CartServiceImpl;
import com.service.impl.CatalogServiceImpl;
import com.service.impl.CreditServiceImpl;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.LeaveMsgServiceImpl;
import com.service.impl.OrderServiceImpl;
import com.service.impl.StaffServiceImpl;
import com.service.impl.TodoListServiceImpl;
import com.service.impl.UserServiceImpl;

public class ServiceFactory {
	public static UserService createUserService() {
		return new UserServiceImpl();
	}

	public static GoodsService createGoodsService() {
		return new GoodsServiceImpl();
	}
	
	public static CatalogService createCatalogService() {
		return new CatalogServiceImpl();
	}
	
	public static OrderService createOrderService() {
		return new OrderServiceImpl();
	}
	
	public static CreditService createCreditService() {
		return new CreditServiceImpl();
	}
	
	public static LeaveMsgService createLeaveMsgService() {
		return new LeaveMsgServiceImpl();
	}
	
	public static CartService createCartService() {
		return new CartServiceImpl();
	}
	
	public static TodoListService createTodoListService() {
		return new TodoListServiceImpl();
	}
	
	public static StaffService createStaffService() {
		return new StaffServiceImpl();
	}
}
