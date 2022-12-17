package com.bean;

public class Tcredit
{
	private String id;//管理员给用户评价ID
	private String attribute;//管理员给用户评价属性
	private String content;//管理员给用户评价内容
	private String time;//管理员给用户评价时间
	
	private String user_id;//用户ID

	public void SetAttribute(String id, String attribute, String content, String time, String user_id) {
		setId(id);
		setAttribute(attribute);
		setContent(content);
		setTime(time);
		setUser_id(user_id);
	}

	public Tcredit() {
		// TODO Auto-generated constructor stub
	}

	public String getId()//得到评价ID
	{
		return id;
	}

	public void setId(String id)//设置评价ID
	{
		this.id = id;
	}

	public String getUser_id()//得到用户ID
	{
		return user_id;
	}

	public void setUser_id(String user_id)//设置用户ID
	{
		this.user_id = user_id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
