package com.service.impl;

import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService{
   private UserDao dao = new UserDaoImpl();
	
	//查看所有用户的方法
	public ArrayList<User> query() {
		return dao.query();
	}

	//删除用户信息的方法
	public int delete(int userid) {
		return dao.delete(userid);
	}

	//根据用户编号查询用户信息的方法
	public User toUpdate(int userid) {
		return dao.toUpdate(userid);
	}

	//修改用户信息的方法
	public int update(User user) {
		return dao.update(user);
	}

	//添加用户的方法
	public int add(User user) {
		return dao.add(user);
	}

	
}
