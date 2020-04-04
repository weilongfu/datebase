package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.bean.Orderlist;
import com.bean.Ordertable;
import com.bean.ShopCar;
import com.bean.ShopCarItem;
import com.bean.User;
import com.bean.UserAddress;
import com.dao.UserAddressDao;
import com.dao.impl.UserAddressDaoImpl;
import com.service.UserAddressService;

/**
 * �ջ���ַ��Ϣ
 * @author pc
 *
 */
public class UserAddressServiceImpl implements UserAddressService{

	private UserAddressDao dao = new UserAddressDaoImpl();
	
	//ͨ���û���Ų�ѯ�û���ַ��Ϣ�ķ���  һ���û����ж����ַ
	public ArrayList<UserAddress> queryById(int id) {
		return dao.queryById(id);
	}

	//��ӵ�ַ��Ϣ�ķ���
	public boolean addUserAddress(UserAddress address) {
		return dao.addUserAddress(address);
	}

	//���ݵ�ַ��Ų�ѯ��ַ��Ϣ
	public UserAddress queryAddressById(int id) {
		return dao.queryAddressById(id);
	}

	//��Ӷ����Լ�������ϸ�ķ���
	public int addOrder(HashMap<Integer, ShopCarItem> items,
			UserAddress address,ShopCar car,User user) {
		//��������ʱ���ʽ���������ɶ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		//��ȡ��ǰ���ں�ʱ�䣬����ʽ��Ϊָ����ʽ�����ɶ������
		String orderId = sdf.format(new Date());
		//��ʽ����������
		//sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String orderDate = sdf.format(new Date());
		//ʵ������������
		Ordertable order=new Ordertable(orderId,new Date(),car.getTotalPrice(),
				user.getUserid(),address.getName(),address.getAddress(),address.getTel(),
				null);
		//�������ݿ���Ӷ����ķ���
		int num=dao.addOrderTable(order);
		//ѭ����Ӷ�����ϸ
		for(int key:items.keySet())
		{
			//ͨ��map�ļ�ֵ��������valueֵ
			ShopCarItem item = items.get(key);
			//ʵ����������ϸ����
			Orderlist ordermx=new Orderlist(0,orderId,item.getshoes().getShoesid(),item.getCount());
			//�������ݿ���Ӷ�����ϸ�ķ���
			dao.addOrderMx(ordermx);
		}
		return num;
		
	}
  
	
}
