package com.bean;

/**
 * 收货地址类
 * 
 * @author pc
 *
 */
public class UserAddress {

	private int id;
	private int userid;
	private String area;
	private String address;
	private String zipcode;
	private String name;
	private String tel;

	public UserAddress() {
	}

	public UserAddress(int id, int userid, String area, String address,
			String zipcode, String name, String tel) {
		super();
		this.id = id;
		this.userid = userid;
		this.area = area;
		this.address = address;
		this.zipcode = zipcode;
		this.name = name;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
