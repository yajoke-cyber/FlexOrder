package com.bean;

public class Tgoods //��Ʒ��Ϣ��
{
	private String id;//��Ʒ��ID
	private String catalog_id;//��Ʒ����ID
	private String showId;//��Ʒ�ı��
	private String name;//��Ʒ������
	
	private String introduction;//��Ʒ�Ľ���
	private String img;//��Ʒ��ͼƬ
	private int marketPrice;//��Ʒ���г���
	private int specialPrice;//��Ʒ���ؼ�
	
	private String del;//��Ʒ�Ƿ�ɾ����־

	public void SetAttribute(String id, String catalogId, String showId, String name, String introduction, String img,
			int marketPrice, int specialPrice) {
		setId(id);
		setCatalog_id(catalogId);
		setShowId(showId);
		setName(name);
		setIntroduction(introduction);
		setImg(img);
		setMarketPrice(marketPrice);
		setSpecialPrice(specialPrice);
	}

	public Tgoods() {
		
	}


	public String getCatalog_id()//�õ���Ʒ���ID
	{
		return catalog_id;
	}

	public void setCatalog_id(String catalog_id)//���ò�Ʒ���ID
	{
		this.catalog_id = catalog_id;
	}

	public String getDel()//�õ���Ʒ�Ƿ�ɾ����Ϣ
	{
		return del;
	}

	public void setDel(String del)//���ò�Ʒ�Ƿ�ɾ����Ϣ
	{
		this.del = del;
	}

	public String getId()//�õ���ƷID��Ϣ
	{
		return id;
	}

	public void setId(String id)//���ò�ƷID��Ϣ
	{
		this.id = id;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(int specialPrice) {
		this.specialPrice = specialPrice;
	}
		
}
