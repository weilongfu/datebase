package com.service;

import java.util.ArrayList;

import com.bean.Admin;

public interface AdminService {
	// ����Ա��¼�ķ���
	public Admin login(String AdminName, String AdminPwd);

	// ע�����Ա�ķ���
	public int reg(Admin admin);

	// ��ѯ���й���Ա�ķ���
	public ArrayList<Admin> query();

	// ���ݹ���Ա���ɾ������Ա�ķ���
	public int delete(int adminId);

	// ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	public Admin queryById(int adminId);

	// ���ݹ���Ա����޸Ĺ���Ա��Ϣ�ķ���
	public int update(Admin admin);

	// ��ӹ���Ա�ķ���
	public int add(Admin admin);
}
