package com.bean;

public class Tuser
{
	private String id;//�û�ID
	private String loginname;//�û���¼�˺�
	private String loginpw;//�û���¼����
	private String name;//�û���¼��
	
	private String del;//�Ƿ�ɾ����־
	
	public void SetAttribute(String id, String loginname, String loginpw, String name, String del) {
		setId(id);
		setLoginname(loginname);
		setLoginpw(loginpw);
		setName(name);
		setDel(del);
	}
	public Tuser() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId()//�õ��û�ID
	{
		return id;
	}
	public void setId(String id)//�����û�ID
	{
		this.id = id;
	}
	public String getLoginname()//�õ��û���¼�˺�
	{
		return loginname;
	}
	public void setLoginname(String loginname)//�����û���¼�˺�
	{
		this.loginname = loginname;
	}
	public String getLoginpw()//�õ��û���¼����
	{
		return loginpw;
	}
	
	public String getDel()//�õ��û��Ƿ�ɾ����Ϣ
	{
		return del;
	}
	public void setDel(String del)//�����û��Ƿ�ɾ����Ϣ
	{
		this.del = del;
	}
	public void setLoginpw(String loginpw)//�õ��û���¼����
	{
		this.loginpw = loginpw;
	}
	public String getName()//�õ��û�����
	{
		return name;
	}
	public void setName(String name)//�����û�����
	{
		this.name = name;
	}
	
}
