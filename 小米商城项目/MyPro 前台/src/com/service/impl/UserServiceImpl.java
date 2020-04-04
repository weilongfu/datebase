package com.service.impl;

import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService{
   private UserDao userdao = new UserDaoImpl();
	//�ж��û���¼
	public User login(String uname, String pwd) {
		return userdao.login(uname, pwd);
	}

	//ע��
	public int register(User user){
		return userdao.register(user);
	}

	/**
	 * ������ҳ�ķ���
	 */
	@Override
	public ArrayList toindex(String keyword, String shoesstate) {
		return userdao.toindex(keyword, shoesstate);
	}
}
