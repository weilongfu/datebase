package com.service;

import java.util.ArrayList;

import com.bean.Orders;

public interface OrdersService {
	 /**
	  * 根据当前用户编号查询当前登录用户订单信息的方法
	  */
		public ArrayList<Orders> queryOrders(int userid);
		
}
