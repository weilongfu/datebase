package com.service;

import java.util.ArrayList;

import com.bean.Admin;

public interface AdminService {
	// 管理员登录的方法
	public Admin login(String AdminName, String AdminPwd);

	// 注册管理员的方法
	public int reg(Admin admin);

	// 查询所有管理员的方法
	public ArrayList<Admin> query();

	// 根据管理员编号删除管理员的方法
	public int delete(int adminId);

	// 根据管理员编号查询管理员信息
	public Admin queryById(int adminId);

	// 根据管理员编号修改管理员信息的方法
	public int update(Admin admin);

	// 添加管理员的方法
	public int add(Admin admin);
}
