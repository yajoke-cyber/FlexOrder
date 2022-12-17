package com.dao.Impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.TLeaveMsg;
import com.dao.DB;
import com.dao.LeaveMsgDao;

public class LeaveMsgDaoImpl implements LeaveMsgDao{

	@Override
	public int insert(TLeaveMsg LeaveMsg) {
		String sql="insert into t_leaveMsg(content,leaveMsgTime,user_id,reply,replyTime) values(?,?,?,?,?)";
		Object[] params={LeaveMsg.getContent(),LeaveMsg.getLeaveMsgTime(),LeaveMsg.getUser_id(),LeaveMsg.getReply(),LeaveMsg.getReplyTime()};
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
	public int setReply(String reply, String replyTime, String id) {
		String sql="update t_leaveMsg set reply=?,replyTime=? where id=?";
		Object[] params={reply,replyTime,id};
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
		String sql="delete from t_leaveMsg where id="+id;
		Object[] params={};
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
	public ArrayList<TLeaveMsg> queryAll() {
		ArrayList<TLeaveMsg> leaveMsgList=new ArrayList();
		String sql="select * from t_leaveMsg order by leaveMsgTime";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TLeaveMsg leaveMsg =new TLeaveMsg();
				
				leaveMsg.setId(rs.getInt("id"));
				leaveMsg.setContent(rs.getString("content"));
				leaveMsg.setLeaveMsgTime(rs.getString("leaveMsgTime"));
				leaveMsg.setUser_id(rs.getString("user_id"));
				
				leaveMsg.setReply(rs.getString("reply"));
				leaveMsg.setReplyTime(rs.getString("replyTime"));
			
				leaveMsgList.add(leaveMsg);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return leaveMsgList;
	}

	@Override
	public TLeaveMsg queryById(String id) {
		TLeaveMsg leaveMsg=new TLeaveMsg();
		
		String sql="select * from t_leaveMsg where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				leaveMsg.setId(rs.getInt("id"));
				leaveMsg.setContent(rs.getString("content"));
				leaveMsg.setLeaveMsgTime(rs.getString("leaveMsgTime"));
				leaveMsg.setUser_id(rs.getString("user_id"));
				
				leaveMsg.setReply(rs.getString("reply"));
				leaveMsg.setReplyTime(rs.getString("replyTime"));
			
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return leaveMsg;
	}
	
}
