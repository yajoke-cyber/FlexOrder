package com.bean;

public class Tcatalog //菜品类别类
{
	private String id;//菜品类别ID
	private String name;//菜品类别名称
	private String del;//菜品类别是否删除标志
	private String detail; //菜品类别描述
	
	public void SetAttribute(String id, String name, String del, String detail) {
		setId(id);
		setName(name);
		setDel(del);
		setDetail(detail);
	}
	public Tcatalog() {
		// TODO Auto-generated constructor stub
	}
	public String getDel()//得到是否删除信息
	{
		return del;
	}
	public void setDel(String del)//设置是否删除信息
	{
		this.del = del;
	}
	public String getName()//得到菜品类别名信息
	{
		return name;
	}
	public void setName(String name)//设置菜品类别名信息
	{
		this.name = name;
	}
	public String getId()//得到菜品类别ID信息
	{
		return id;
	}
	public void setId(String id)//设置菜品类别ID信息
	{
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
