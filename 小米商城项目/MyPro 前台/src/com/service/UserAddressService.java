package com.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.bean.ShopCar;
import com.bean.ShopCarItem;
import com.bean.User;
import com.bean.UserAddress;

/**
 * �ջ���ַ
 * @author pc
 *
 */
public interface UserAddressService {
	  //ͨ���û���Ų�ѯ�û���ַ��Ϣ�ķ���  һ���û����ж����ַ
		public ArrayList<UserAddress> queryById(int id);
		
		//��ӵ�ַ��Ϣ�ķ���
		public boolean addUserAddress(UserAddress address);
		
		//ͨ����ַ��Ų�ѯ��ַ��Ϣ
		public UserAddress queryAddressById(int id);
		
		//��Ӷ�����Ͷ�����ϸ��ķ���
		public int addOrder(HashMap<Integer, ShopCarItem> items ,UserAddress address,ShopCar car,User user);
}
