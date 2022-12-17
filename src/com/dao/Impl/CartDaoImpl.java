package com.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Tcart;
import com.bean.Tgoods;
import com.dao.CartDao;
import com.dao.DB;

public class CartDaoImpl implements CartDao{

	@Override
	public int insert(Tcart cart) {
		String sql="insert into t_cart(id,goods_id, goods_quantity, goods_Amount, user_id) values(?,?,?,?,?)";
		Object[] params={cart.getId(),cart.getGoods_id(), cart.getGoods_quantity(), 
				cart.getGoods_Amount(),cart.getUser_id()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);//ִ��sql��䣬�����ݿ������ɾ�Ĳ飬�����ֵ�������params��
		int i = 0;
		try {
			i = mydb.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}

	@Override
	public int delete(String id, String user_id) {
		String sql="delete from t_cart where id=? and user_id = ?";
		Object[] params={id, user_id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i = 0;
		try {
			i = mydb.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}

	@Override
	public int updateStatus(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Tcart> queryUserCart(String user_id) {
		ArrayList<Tcart> cartList = new ArrayList();
		String sql="select * from t_cart where user_id= ?";
		Object[] params={user_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{	
				Tcart cart = new Tcart();
					
				cart.setId(rs.getString("id"));
				cart.setGoods_id(rs.getString("goods_id"));
				cart.setGoods_quantity(rs.getInt("goods_quantity"));
				cart.setUser_id(rs.getString("user_id"));
				cart.setGoods_Amount(rs.getInt("goods_Amount"));
				
				cartList.add(cart);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return cartList;
	}

	@Override
	public Tcart queryByUser_Goods(String user_id, String goods_id) {
		Tcart cart = new Tcart();
		String sql="select * from t_cart where user_id= ? and goods_id = ?";
		Object[] params={user_id, goods_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{	
				cart.setId(rs.getString("id"));
				cart.setGoods_id(rs.getString("goods_id"));
				cart.setGoods_quantity(rs.getInt("goods_quantity"));
				cart.setUser_id(rs.getString("user_id"));
				cart.setGoods_Amount(rs.getInt("goods_Amount"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return cart;
	}

	@Override
	public int updateQuantity_Amount(String id, int goods_quantity, int gooos_price) {
		String sql="update t_cart set goods_quantity = goods_quantity + ? and goods_amount = goods_amount + ? where id=?";
		Object[] params={goods_quantity, goods_quantity * gooos_price, id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i = 0;
		try {
			i = mydb.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}	
	
	public int queryAmount(String user_id) {
		String sql="select sum(goods_Amount) as total from t_cart where user_id = ?";
		Object[] params={user_id};
		DB mydb=new DB();
		int total = 0;
		
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.getInt("total");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return total;
	}

	@Override
	public ArrayList<Tcart> queryByOrderId(String order_id) {
		ArrayList<Tcart> cartList = new ArrayList<Tcart>();
		String sql="select * from t_cart where order_id = ?";
		Object[] params={order_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{	
				Tcart cart = new Tcart();
				cart.setId(rs.getString("id"));
				cart.setOrder_id(rs.getString("order_id"));
				cart.setGoods_id(rs.getString("goods_id"));
				cart.setGoods_quantity(rs.getInt("goods_quantity"));
				cart.setUser_id(rs.getString("user_id"));
				cart.setGoods_Amount(rs.getInt("goods_Amount"));
				cartList.add(cart);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return cartList;
	}

	@Override
	public int clearUserRecord(String user_id) {
		String sql="delete from t_cart where user_id = ?";
		Object[] params={user_id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i = 0;
		try {
			i = mydb.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}

}
