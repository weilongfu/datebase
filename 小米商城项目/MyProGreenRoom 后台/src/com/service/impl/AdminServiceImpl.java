package com.service.impl;

import java.util.ArrayList;

import com.bean.Admin;
import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao = new AdminDaoImpl();

	// 判断管理员登录的方法
	public Admin login(String AdminName, String AdminPwd) {
		return dao.login(AdminName, AdminPwd);
	}

	// 管理员注册的方法
	public int reg(Admin admin) {
		return dao.reg(admin);
	}

	// 查询所有管理员的方法
	public ArrayList<Admin> query() {
		return dao.query();
	}

	// 根据管理员编号删除管理员的方法
	public int delete(int adminId) {
		return dao.delete(adminId);
	}

	// 根据管理员编号查询管理员信息
	public Admin queryById(int adminId) {
		return dao.queryById(adminId);
	}

	//根据管理员编号修改管理员信息的方法
	public int update(Admin admin) {
		return dao.update(admin);
	}

	//添加管理员的方法
	public int add(Admin admin) {
		return dao.add(admin);
	}

}
