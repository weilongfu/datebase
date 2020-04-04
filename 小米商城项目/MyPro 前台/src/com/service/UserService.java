package com.service;

import java.util.ArrayList;

import com.bean.User;

public interface UserService {
	/**
	 * 判断用户登录
	 */
	public User login(String uname, String pwd);

	/**
	 * 注册用户的方法
	 */
	public int register(User user);
	
	/**
	 * 进入主页的方法
	 */
	public ArrayList toindex(String keyword,String shoesstate);
}
