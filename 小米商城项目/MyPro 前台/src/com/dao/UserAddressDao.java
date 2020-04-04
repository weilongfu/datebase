package com.dao;

import java.util.ArrayList;

import com.bean.Orderlist;
import com.bean.Ordertable;
import com.bean.UserAddress;

/**
 * 收货地址
 * @author pc
 *
 */
public interface UserAddressDao {
    //通过用户编号查询用户地址信息的方法  一个用户可有多个地址
	public ArrayList<UserAddress> queryById(int id);
	
	//添加地址信息的方法
	public boolean addUserAddress(UserAddress address);
	
	//通过地址编号查询地址信息
	public UserAddress queryAddressById(int id);
	
	//添加订单表的方法
	public int addOrderTable(Ordertable order);
	
	//添加订单明细表的方法
	public int addOrderMx(Orderlist ordermx);
}
