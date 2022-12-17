package com.service;

import java.util.ArrayList;

import com.bean.TLeaveMsg;

public interface LeaveMsgService {
	public int insert(TLeaveMsg LeaveMsg);
	public int setReply(String reply, String replyTime, String id);
	public int delete(String id);
	public ArrayList<TLeaveMsg> queryAll();
	public TLeaveMsg queryById(String id);
}
