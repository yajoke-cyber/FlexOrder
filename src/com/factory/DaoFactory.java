package com.factory;


import com.dao.CartDao;
import com.dao.CatalogDao;
import com.dao.CreditDao;
import com.dao.GoodsDao;
import com.dao.LeaveMsgDao;
import com.dao.OrderDao;
import com.dao.StaffDao;
import com.dao.TodoListDao;
import com.dao.UserDao;
import com.dao.Impl.CartDaoImpl;
import com.dao.Impl.CatalogDaoImpl;
import com.dao.Impl.CreditDaoImpl;
import com.dao.Impl.GoodsDaoImpl;
import com.dao.Impl.LeaveMsgDaoImpl;
import com.dao.Impl.OrderDaoImpl;
import com.dao.Impl.StaffDaoImpl;
import com.dao.Impl.TodoListDaoImpl;
import com.dao.Impl.UserDaoImpl;


public class DaoFactory {
	public static UserDao createUserDao() {
		return new UserDaoImpl();
	}
	
	public static GoodsDao createGoodsDao() {
		return new GoodsDaoImpl();
	}
	
	public static CatalogDao createCatalogDao() {
		return new CatalogDaoImpl();
	}
	
	public static OrderDao createOrderDao() {
		return new OrderDaoImpl();
	}
	
	public static CreditDao creatCreditDao() {
		return new CreditDaoImpl();
	}
	
	public static LeaveMsgDao creatLeaveMsgDao() {
		return new LeaveMsgDaoImpl();
	}
	
	public static CartDao createCartDao() {
		return new CartDaoImpl();
	}
	
	public static TodoListDao createTotoListDao() {
		return new TodoListDaoImpl();
	}
	
	public static StaffDao createStaffDao() {
		return new StaffDaoImpl();
	}
}
