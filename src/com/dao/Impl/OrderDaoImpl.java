package com.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Torder;
import com.dao.DB;
import com.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int insert(Torder order) {
		String sql="insert into t_order values(?,?,?,?,?,?,?,?,?)";
		Object[] params={order.getId(),order.getShowId(),order.getTime(),order.getStatus(),order.getReply(),
				order.getDeliveryAddress(),order.getPaymentMethod(), order.getAmount(),order.getUser_id()};
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
	public int delete(String id) {
		String sql="delete from t_order where id=?";
		Object[] params={id};
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
	public ArrayList<Torder> queryAll() {
		ArrayList<Torder> orderList = new ArrayList<Torder>();
		String sql="select * from t_order order by status desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
                Torder order=new Torder();
				
				order.setId(rs.getString("id"));
				order.setShowId(rs.getString("showId"));
				order.setTime(rs.getString("time"));
				order.setStatus(rs.getString("status"));
				order.setReply(rs.getString("reply"));
				order.setDeliveryAddress(rs.getString("deliveryAddress"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				order.setAmount(rs.getInt("amount"));
				order.setUser_id(rs.getString("user_id"));
				
				orderList.add(order);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return orderList;
	}

	@Override
	public int updateStatus(String id, String newStatus) {
		String sql="update t_order set status = ? where id = ?";
		Object[] params={newStatus,id};
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
	public int updateReply(String id, String reply) {
		String sql="update t_order set reply=? where id=?";
		Object[] params={reply,id};
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
	public ArrayList<Torder> queryByUser(String user_id) {
		ArrayList<Torder> orderList = new ArrayList<Torder>();
		String sql="select * from t_order where user_id = ?";
		Object[] params={user_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
                Torder order=new Torder();
				
				order.setId(rs.getString("id"));
				order.setShowId(rs.getString("showId"));
				order.setTime(rs.getString("time"));
				order.setStatus(rs.getString("status"));
				order.setReply(rs.getString("reply"));
				order.setDeliveryAddress(rs.getString("deliveryAddress"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				order.setAmount(rs.getInt("amount"));
				order.setUser_id(rs.getString("user_id"));
				
				orderList.add(order);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return orderList;
	}
}
