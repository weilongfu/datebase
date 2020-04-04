package com.service.impl;

import java.util.ArrayList;

import com.bean.Admin;
import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao = new AdminDaoImpl();

	// �жϹ���Ա��¼�ķ���
	public Admin login(String AdminName, String AdminPwd) {
		return dao.login(AdminName, AdminPwd);
	}

	// ����Աע��ķ���
	public int reg(Admin admin) {
		return dao.reg(admin);
	}

	// ��ѯ���й���Ա�ķ���
	public ArrayList<Admin> query() {
		return dao.query();
	}

	// ���ݹ���Ա���ɾ������Ա�ķ���
	public int delete(int adminId) {
		return dao.delete(adminId);
	}

	// ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	public Admin queryById(int adminId) {
		return dao.queryById(adminId);
	}

	//���ݹ���Ա����޸Ĺ���Ա��Ϣ�ķ���
	public int update(Admin admin) {
		return dao.update(admin);
	}

	//��ӹ���Ա�ķ���
	public int add(Admin admin) {
		return dao.add(admin);
	}

}
