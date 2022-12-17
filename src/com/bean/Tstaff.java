package com.bean;

public class Tstaff {
	private String id;
	private String userName;
	private String userPwd;
	private String level;
	
	public void SetAttribute(String id, String userName, String userPwd, String level) {
		setId(id);
		setUserName(userName);
		setUserPwd(userPwd);
		setLevel(level);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
