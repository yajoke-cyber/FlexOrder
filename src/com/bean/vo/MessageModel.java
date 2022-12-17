package com.bean.vo;

public class MessageModel {
	public void SetAttribute(Integer code, String msg, Object obj) {
		setCode(code);
		setMsg(msg);
		setObj(obj);
	}
	
	public MessageModel() {
		
	}
	//	当servlet给前端返回数据时使用的Bean，类似于自定义res
	private Integer code = 0;//状态码 (1 = 成功, 0 = 失败)
	private String msg = "";//提示信息
	private Object obj = null;//回显对象(基本数据类型、字符串类型、List、Map等）
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
}