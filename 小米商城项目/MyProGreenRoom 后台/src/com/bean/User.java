package com.bean;

public class User {
private int userid;
private String uname;
private String pwd;
private String uphone;
public User() {
}
public User(int userid, String uname, String pwd, String uphone) {
	super();
	this.userid = userid;
	this.uname = uname;
	this.pwd = pwd;
	this.uphone = uphone;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getUphone() {
	return uphone;
}
public void setUphone(String uphone) {
	this.uphone = uphone;
}

}
