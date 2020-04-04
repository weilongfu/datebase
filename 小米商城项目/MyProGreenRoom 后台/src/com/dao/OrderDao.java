package com.dao;

import java.util.ArrayList;

import com.bean.Orderinfo;
import com.bean.Ordertable;


public interface OrderDao {
  //查询所有订单的方法
	public ArrayList<Ordertable> query();
	
	//根据订单编号查看订单详情的方法
	public ArrayList<Orderinfo> queryOrderinfoById(String orderid);
	
	//根据订单编号查询订单信息的方法
	public Ordertable queryById(String orderid);
	
	//根据订单编号修改订单状态的方法
	public int updateById(String orderid,String orderstase);
}
