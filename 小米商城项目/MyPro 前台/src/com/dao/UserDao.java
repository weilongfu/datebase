package com.dao;

import java.util.ArrayList;

import com.bean.User;

public interface UserDao {
  /**
   * �ж��û���¼�ķ���
   * 
   */
	public User login(String uname,String pwd);
	
	/**
	 * ע���û��ķ���
	 */
	public int register(User user);
	
	/**
	 * ������ҳ�ķ���
	 */
	public ArrayList toindex(String keyword,String shoesstate);
}
