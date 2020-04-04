package com.bean;

//商品信息类
public class Shoesinfo {
	private String shoesimg;
	private int shoesid;
	private String shoesname;
	private double shoesprice;
	private String introduce;
	private String shoesintr;
	private int shoescount;
	private String shoesstate;
	private String release;
	private String color;

	public Shoesinfo() {
		// TODO Auto-generated constructor stub
	}

	public Shoesinfo(String shoesimg, int shoesid, String shoesname,
			double shoesprice, String introduce, String shoesintr,
			int shoescount, String shoesstate, String release, String color) {
		super();
		this.shoesimg = shoesimg;
		this.shoesid = shoesid;
		this.shoesname = shoesname;
		this.shoesprice = shoesprice;
		this.introduce = introduce;
		this.shoesintr = shoesintr;
		this.shoescount = shoescount;
		this.shoesstate = shoesstate;
		this.release = release;
		this.color = color;
	}

	public String getShoesimg() {
		return shoesimg;
	}

	public void setShoesimg(String shoesimg) {
		this.shoesimg = shoesimg;
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

	public double getShoesprice() {
		return shoesprice;
	}

	public void setShoesprice(double shoesprice) {
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

}
