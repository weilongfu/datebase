package com.bean;

import java.util.Date;

//��������
public class Orderinfo {
    private String shoesimg;  //��ƷͼƬ 
	private String orderid;   //�������
	private String shoesname; //��Ʒ����
	private double shoesprice; //��Ʒ�۸�
	private Date orderDate;  //�µ�ʱ��
	private String username;      //�ջ�������
	private String orderAddress;  //�ջ���ַ
	private String phoen;           //�绰����
	private String orderstase;       //����״̬
	private String shoesnum ;       //��������
	public Orderinfo() {
	}
	public Orderinfo(String shoesimg, String orderid, String shoesname,
			double shoesprice, Date orderDate, String username,
			String orderAddress, String phoen, String orderstase,
			String shoesnum) {
		super();
		this.shoesimg = shoesimg;
		this.orderid = orderid;
		this.shoesname = shoesname;
		this.shoesprice = shoesprice;
		this.orderDate = orderDate;
		this.username = username;
		this.orderAddress = orderAddress;
		this.phoen = phoen;
		this.orderstase = orderstase;
		this.shoesnum = shoesnum;
	}
	public String getShoesimg() {
		return shoesimg;
	}
	public void setShoesimg(String shoesimg) {
		this.shoesimg = shoesimg;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getPhoen() {
		return phoen;
	}
	public void setPhoen(String phoen) {
		this.phoen = phoen;
	}
	public String getOrderstase() {
		return orderstase;
	}
	public void setOrderstase(String orderstase) {
		this.orderstase = orderstase;
	}
	public String getShoesnum() {
		return shoesnum;
	}
	public void setShoesnum(String shoesnum) {
		this.shoesnum = shoesnum;
	}
	
}
