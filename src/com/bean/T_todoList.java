package com.bean;


public class T_todoList {
	private String id;
	private String content;
	private String user_id;
	
	public void SetAttribute(String id, String content, String user_id) {
		setId(user_id);
		setContent(content);
		setUser_id(user_id);
	}
	
	public T_todoList() {
		
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
