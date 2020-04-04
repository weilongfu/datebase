package com.service.impl;

import java.util.ArrayList;

import com.bean.Orderinfo;
import com.bean.Ordertable;
import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService{
  private OrderDao dao = new OrderDaoImpl();
	//查询所有订单
	public ArrayList<Ordertable> query() {
		return dao.query();
	}
	@Override
	public ArrayList<Orderinfo> queryOrderinfoById(String orderid) {
		return dao.queryOrderinfoById(orderid);
	}
	
	//根据订单编号查询订单信息的方法
	public Ordertable queryById(String orderid) {
		return dao.queryById(orderid);
	}


	//根据订单编号修改订单状态的方法
	public int updateById(String orderid, String orderstase) {
	   return dao.updateById(orderid, orderstase);
	}

}
