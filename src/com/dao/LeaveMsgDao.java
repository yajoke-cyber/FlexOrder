package com.dao;

import java.util.ArrayList;

import com.bean.TLeaveMsg;

public interface LeaveMsgDao {
	public int insert(TLeaveMsg LeaveMsg);
	public int setReply(String reply, String replyTime, String id);
	public int delete(String id);
	public ArrayList<TLeaveMsg> queryAll();
	public TLeaveMsg queryById(String id);
}
