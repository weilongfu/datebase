package com.dao;

import java.util.ArrayList;

import com.bean.Orders;

public interface OrdersDao {
 /**
  * ���ݵ�ǰ�û���Ų�ѯ��ǰ��¼�û�������Ϣ�ķ���
  */
	public ArrayList<Orders> queryOrders(int userid);
}
