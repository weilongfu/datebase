package com.service.impl;

import java.util.ArrayList;

import com.bean.Orders;
import com.dao.OrdersDao;
import com.dao.impl.OrdersDaoImpl;
import com.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{

	private OrdersDao dao = new OrdersDaoImpl();	
	//查询订单信息的方法
	public ArrayList<Orders> queryOrders(int userid) {
		return dao.queryOrders(userid);
	}

}
