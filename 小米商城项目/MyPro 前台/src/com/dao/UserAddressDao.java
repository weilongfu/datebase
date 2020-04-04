package com.dao;

import java.util.ArrayList;

import com.bean.Orderlist;
import com.bean.Ordertable;
import com.bean.UserAddress;

/**
 * �ջ���ַ
 * @author pc
 *
 */
public interface UserAddressDao {
    //ͨ���û���Ų�ѯ�û���ַ��Ϣ�ķ���  һ���û����ж����ַ
	public ArrayList<UserAddress> queryById(int id);
	
	//��ӵ�ַ��Ϣ�ķ���
	public boolean addUserAddress(UserAddress address);
	
	//ͨ����ַ��Ų�ѯ��ַ��Ϣ
	public UserAddress queryAddressById(int id);
	
	//��Ӷ�����ķ���
	public int addOrderTable(Ordertable order);
	
	//��Ӷ�����ϸ��ķ���
	public int addOrderMx(Orderlist ordermx);
}
