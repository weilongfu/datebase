package com.service.impl;

import java.util.ArrayList;

import com.bean.Orderinfo;
import com.bean.Ordertable;
import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService{
  private OrderDao dao = new OrderDaoImpl();
	//��ѯ���ж���
	public ArrayList<Ordertable> query() {
		return dao.query();
	}
	@Override
	public ArrayList<Orderinfo> queryOrderinfoById(String orderid) {
		return dao.queryOrderinfoById(orderid);
	}
	
	//���ݶ�����Ų�ѯ������Ϣ�ķ���
	public Ordertable queryById(String orderid) {
		return dao.queryById(orderid);
	}


	//���ݶ�������޸Ķ���״̬�ķ���
	public int updateById(String orderid, String orderstase) {
	   return dao.updateById(orderid, orderstase);
	}

}
