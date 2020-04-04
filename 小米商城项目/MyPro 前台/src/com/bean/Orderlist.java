package com.bean;
/**
 * ¶©µ¥Ã÷Ï¸±í
 * @author pc
 *
 */
public class Orderlist {
private int id;
private String orderId;
private int shoesid;
private int shoesnum;
public Orderlist() {
	// TODO Auto-generated constructor stub
}
public Orderlist(int id, String orderId, int shoesid, int shoesnum) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.shoesid = shoesid;
	this.shoesnum = shoesnum;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public int getShoesid() {
	return shoesid;
}
public void setShoesid(int shoesid) {
	this.shoesid = shoesid;
}
public int getShoesnum() {
	return shoesnum;
}
public void setShoesnum(int shoesnum) {
	this.shoesnum = shoesnum;
}


}
