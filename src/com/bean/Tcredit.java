package com.bean;

public class Tcredit
{
	private String id;//����Ա���û�����ID
	private String attribute;//����Ա���û���������
	private String content;//����Ա���û���������
	private String time;//����Ա���û�����ʱ��
	
	private String user_id;//�û�ID

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

	public String getId()//�õ�����ID
	{
		return id;
	}

	public void setId(String id)//��������ID
	{
		this.id = id;
	}

	public String getUser_id()//�õ��û�ID
	{
		return user_id;
	}

	public void setUser_id(String user_id)//�����û�ID
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
