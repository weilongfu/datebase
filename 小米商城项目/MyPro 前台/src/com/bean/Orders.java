package com.bean;

import java.util.Date;

/**
 * ∂©µ•–≈œ¢
 * @author pc
 *
 */
public class Orders {
private String shoesimg;	
private String orderid;
private String orderstase;
private double shoesprice;
private Date orderDate;
public Orders() {
}
public Orders(String shoesimg, String orderid, String orderstase,
		double shoesprice, Date orderDate) {
	super();
	this.shoesimg = shoesimg;
	this.orderid = orderid;
	this.orderstase = orderstase;
	this.shoesprice = shoesprice;
	this.orderDate = orderDate;
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
public String getOrderstase() {
	return orderstase;
}
public void setOrderstase(String orderstase) {
	this.orderstase = orderstase;
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

}
