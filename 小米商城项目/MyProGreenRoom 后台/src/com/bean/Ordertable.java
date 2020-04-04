package com.bean;

import java.util.Date;

//¶©µ¥±í
public class Ordertable {
private String orderid;
private Date orderDate;
private double orderPrice;
private int userid;
private String username;
private String orderAddress;
private String phoen;
private String orderstase;
public Ordertable() {
}
public Ordertable(String orderid, Date orderDate, double orderPrice,
		int userid, String username, String orderAddress, String phoen,
		String orderstase) {
	super();
	this.orderid = orderid;
	this.orderDate = orderDate;
	this.orderPrice = orderPrice;
	this.userid = userid;
	this.username = username;
	this.orderAddress = orderAddress;
	this.phoen = phoen;
	this.orderstase = orderstase;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public double getOrderPrice() {
	return orderPrice;
}
public void setOrderPrice(double orderPrice) {
	this.orderPrice = orderPrice;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
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

}
