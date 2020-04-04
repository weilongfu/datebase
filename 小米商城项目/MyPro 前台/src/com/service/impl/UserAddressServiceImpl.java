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
 * 收货地址信息
 * @author pc
 *
 */
public class UserAddressServiceImpl implements UserAddressService{

	private UserAddressDao dao = new UserAddressDaoImpl();
	
	//通过用户编号查询用户地址信息的方法  一个用户可有多个地址
	public ArrayList<UserAddress> queryById(int id) {
		return dao.queryById(id);
	}

	//添加地址信息的方法
	public boolean addUserAddress(UserAddress address) {
		return dao.addUserAddress(address);
	}

	//根据地址编号查询地址信息
	public UserAddress queryAddressById(int id) {
		return dao.queryAddressById(id);
	}

	//添加订单以及订单明细的方法
	public int addOrder(HashMap<Integer, ShopCarItem> items,
			UserAddress address,ShopCar car,User user) {
		//设置日期时间格式，便于生成订单编号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		//获取当前日期和时间，并格式化为指定格式，生成订单编号
		String orderId = sdf.format(new Date());
		//格式化订单日期
		//sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String orderDate = sdf.format(new Date());
		//实例化订单对象
		Ordertable order=new Ordertable(orderId,new Date(),car.getTotalPrice(),
				user.getUserid(),address.getName(),address.getAddress(),address.getTel(),
				null);
		//调用数据库添加订单的方法
		int num=dao.addOrderTable(order);
		//循环添加订单明细
		for(int key:items.keySet())
		{
			//通过map的键值遍历集合value值
			ShopCarItem item = items.get(key);
			//实例化订单明细对象
			Orderlist ordermx=new Orderlist(0,orderId,item.getshoes().getShoesid(),item.getCount());
			//调用数据库添加订单明细的方法
			dao.addOrderMx(ordermx);
		}
		return num;
		
	}
  
	
}
