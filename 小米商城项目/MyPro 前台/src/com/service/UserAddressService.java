package com.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.bean.ShopCar;
import com.bean.ShopCarItem;
import com.bean.User;
import com.bean.UserAddress;

/**
 * 收货地址
 * @author pc
 *
 */
public interface UserAddressService {
	  //通过用户编号查询用户地址信息的方法  一个用户可有多个地址
		public ArrayList<UserAddress> queryById(int id);
		
		//添加地址信息的方法
		public boolean addUserAddress(UserAddress address);
		
		//通过地址编号查询地址信息
		public UserAddress queryAddressById(int id);
		
		//添加订单表和订单明细表的方法
		public int addOrder(HashMap<Integer, ShopCarItem> items ,UserAddress address,ShopCar car,User user);
}
