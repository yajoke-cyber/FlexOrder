package com.bean;

public class Tcart
{
	private String id;//������ϸID
	private String order_id;//����ID
	private String goods_id;//��ƷID
	private int goods_quantity;//��Ʒ����
	private int goods_Amount;//��Ʒ�ܽ��
	private String user_id;
	
	
	private Tgoods goods;
	
	public void SetAttribute(String id, String order_id, String goods_id, int goods_quantity, String user_id, int Amount) {
		setId(id);
		setOrder_id(order_id);
		setGoods_id(goods_id);
		setGoods_quantity(goods_quantity);
		setUser_id(user_id);
		setGoods_Amount(Amount);
	}
	public Tcart() {
		// TODO Auto-generated constructor stub
	}
	public int getGoods_quantity()//�õ���Ʒ����
	{
		return goods_quantity;
	}
	public void setGoods_quantity(int goods_quantity)//������Ʒ����
	{
		this.goods_quantity = goods_quantity;
	}
	
	public String getGoods_id()//�õ���ƷID
	{
		return goods_id;
	}
	public void setGoods_id(String goods_id)//������ƷID
	{
		this.goods_id = goods_id;
	}
	public String getId()//�õ�������ϸID
	{
		return id;
	}
	public void setId(String id)//���ö�����ϸID
	{
		this.id = id;
	}
	public String getOrder_id()//�õ�����ID
	{
		return order_id;
	}
	public void setOrder_id(String order_id)//���ö���ID
	{
		this.order_id = order_id;
	}
	public Tgoods getGoods()//�õ���Ʒ��Ϣ
	{
		return goods;
	}
	public void setGoods(Tgoods goods)//������Ʒ��Ϣ
	{
		this.goods = goods;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getGoods_Amount() {
		return goods_Amount;
	}
	public void setGoods_Amount(int goods_Amount) {
		this.goods_Amount = goods_Amount;
	}
	
	

}
