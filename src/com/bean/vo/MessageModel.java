package com.bean.vo;

public class MessageModel {
	public void SetAttribute(Integer code, String msg, Object obj) {
		setCode(code);
		setMsg(msg);
		setObj(obj);
	}
	
	public MessageModel() {
		
	}
	//	��servlet��ǰ�˷�������ʱʹ�õ�Bean���������Զ���res
	private Integer code = 0;//״̬�� (1 = �ɹ�, 0 = ʧ��)
	private String msg = "";//��ʾ��Ϣ
	private Object obj = null;//���Զ���(�����������͡��ַ������͡�List��Map�ȣ�
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