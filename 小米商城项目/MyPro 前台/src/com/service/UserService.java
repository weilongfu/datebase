package com.service;

import java.util.ArrayList;

import com.bean.User;

public interface UserService {
	/**
	 * �ж��û���¼
	 */
	public User login(String uname, String pwd);

	/**
	 * ע���û��ķ���
	 */
	public int register(User user);
	
	/**
	 * ������ҳ�ķ���
	 */
	public ArrayList toindex(String keyword,String shoesstate);
}
