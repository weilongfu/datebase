package com.service;

import java.util.ArrayList;

import com.bean.User;

public interface UserService {
	//��ѯ�����û���Ϣ�ķ���
		public ArrayList<User> query();
		
		//ɾ���û���Ϣ�ķ���
		public int delete(int userid);
		
		//�����û���Ų�ѯ�û���Ϣ�ķ���
		public User toUpdate(int userid);
		
		//�޸��û���Ϣ�ķ���
		public int update(User user);
		
		//����û��ķ���
		public int add(User user);
}
