package com.bean;
/**
 * 管理员表
 * @author pc
 *
 */
public class Admin {
	private int AdminId;
	private String AdminName;
	private String AdminPwd;
	private String AdminSex;
	private String AdminPhone;
	private String AdminGrade;
	
	public Admin() {
	}
	
	public Admin(int adminId, String adminName, String adminPwd,
			String adminSex, String adminPhone, String adminGrade) {
		super();
		AdminId = adminId;
		AdminName = adminName;
		AdminPwd = adminPwd;
		AdminSex = adminSex;
		AdminPhone = adminPhone;
		AdminGrade = adminGrade;
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPwd() {
		return AdminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
	public String getAdminSex() {
		return AdminSex;
	}
	public void setAdminSex(String adminSex) {
		AdminSex = adminSex;
	}
	public String getAdminPhone() {
		return AdminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		AdminPhone = adminPhone;
	}
	public String getAdminGrade() {
		return AdminGrade;
	}
	public void setAdminGrade(String adminGrade) {
		AdminGrade = adminGrade;
	}
	
	
}
