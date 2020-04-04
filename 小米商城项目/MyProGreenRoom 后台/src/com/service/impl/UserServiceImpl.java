package com.service.impl;

import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService{
   private UserDao dao = new UserDaoImpl();
	
	//�鿴�����û��ķ���
	public ArrayList<User> query() {
		return dao.query();
	}

	//ɾ���û���Ϣ�ķ���
	public int delete(int userid) {
		return dao.delete(userid);
	}

	//�����û���Ų�ѯ�û���Ϣ�ķ���
	public User toUpdate(int userid) {
		return dao.toUpdate(userid);
	}

	//�޸��û���Ϣ�ķ���
	public int update(User user) {
		return dao.update(user);
	}

	//����û��ķ���
	public int add(User user) {
		return dao.add(user);
	}

	
}
