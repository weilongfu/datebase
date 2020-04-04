package com.service.impl;

import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService{
   private UserDao userdao = new UserDaoImpl();
	//判断用户登录
	public User login(String uname, String pwd) {
		return userdao.login(uname, pwd);
	}

	//注册
	public int register(User user){
		return userdao.register(user);
	}

	/**
	 * 进入主页的方法
	 */
	@Override
	public ArrayList toindex(String keyword, String shoesstate) {
		return userdao.toindex(keyword, shoesstate);
	}
}
