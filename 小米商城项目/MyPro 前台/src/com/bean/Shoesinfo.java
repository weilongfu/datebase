package com.bean;

public class Shoesinfo {
	private int shoesid; // 商品id，
	private String shoesname; // 商品名称
	private float shoesprice; // 商品价格
	private String introduce; // 商品介绍
	private String shoesintr; // 商品描述
	private int shoescount; // 商品库存
	private String shoesstate; // 商品状态
	private String release; // 版本
	private String color; // 颜色
	private String shoesType;// 类型
	private String keyword; // 分类关键字
	private String shoesimg;// 商品图片

	public Shoesinfo() {
		// TODO Auto-generated constructor stub
	}

	public Shoesinfo(int shoesid, String shoesname, float shoesprice,
			String introduce, String shoesintr, int shoescount,
			String shoesstate, String release, String color, String shoesType,
			String keyword, String shoesimg) {
		super();
		this.shoesid = shoesid;
		this.shoesname = shoesname;
		this.shoesprice = shoesprice;
		this.shoesintr = shoesintr;
		this.shoescount = shoescount;
		this.shoesstate = shoesstate;
		this.release = release;
		this.color = color;
		this.shoesType = shoesType;
		this.keyword = keyword;
		this.shoesimg = shoesimg;
		this.introduce = introduce;
	}

	public int getShoesid() {
		return shoesid;
	}

	public void setShoesid(int shoesid) {
		this.shoesid = shoesid;
	}

	public String getShoesname() {
		return shoesname;
	}

	public void setShoesname(String shoesname) {
		this.shoesname = shoesname;
	}

	public float getShoesprice() {
		return shoesprice;
	}

	public void setShoesprice(float shoesprice) {
		this.shoesprice = shoesprice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getShoesintr() {
		return shoesintr;
	}

	public void setShoesintr(String shoesintr) {
		this.shoesintr = shoesintr;
	}

	public int getShoescount() {
		return shoescount;
	}

	public void setShoescount(int shoescount) {
		this.shoescount = shoescount;
	}

	public String getShoesstate() {
		return shoesstate;
	}

	public void setShoesstate(String shoesstate) {
		this.shoesstate = shoesstate;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShoesType() {
		return shoesType;
	}

	public void setShoesType(String shoesType) {
		this.shoesType = shoesType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getShoesimg() {
		return shoesimg;
	}

	public void setShoesimg(String shoesimg) {
		this.shoesimg = shoesimg;
	}

}
