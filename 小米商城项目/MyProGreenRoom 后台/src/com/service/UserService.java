package com.service;

import java.util.ArrayList;

import com.bean.User;

public interface UserService {
	//查询所有用户信息的方法
		public ArrayList<User> query();
		
		//删除用户信息的方法
		public int delete(int userid);
		
		//根据用户编号查询用户信息的方法
		public User toUpdate(int userid);
		
		//修改用户信息的方法
		public int update(User user);
		
		//添加用户的方法
		public int add(User user);
}
