package com.bean;

public class Tgoods //菜品信息类
{
	private String id;//菜品的ID
	private String catalog_id;//菜品类别的ID
	private String showId;//菜品的编号
	private String name;//菜品的名称
	
	private String introduction;//菜品的介绍
	private String img;//菜品的图片
	private int marketPrice;//菜品的市场价
	private int specialPrice;//菜品的特价
	
	private String del;//菜品是否删除标志

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


	public String getCatalog_id()//得到菜品类别ID
	{
		return catalog_id;
	}

	public void setCatalog_id(String catalog_id)//设置菜品类别ID
	{
		this.catalog_id = catalog_id;
	}

	public String getDel()//得到菜品是否删除信息
	{
		return del;
	}

	public void setDel(String del)//设置菜品是否删除信息
	{
		this.del = del;
	}

	public String getId()//得到菜品ID信息
	{
		return id;
	}

	public void setId(String id)//设置菜品ID信息
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
