package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bean.Orderlist;
import com.bean.Ordertable;
import com.bean.ShopCarItem;
import com.bean.UserAddress;
import com.dao.UserAddressDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class UserAddressDaoImpl extends MyJdbcTemplate implements UserAddressDao{

	//ͨ���û���Ų�ѯ�û���ַ��Ϣ�ķ���
	public ArrayList<UserAddress> queryById(int id) {
		String sql="select * from userAddress where userId=?";
		//��Ӳ���
		Object[] params={id};
		return this.query(sql, params, new MyResultSetHandler());
	}

	
	//��ӵ�ַ��Ϣ�ķ���
	public boolean addUserAddress(UserAddress address) {
		String sql="insert into useraddress values(seq_userAddress_id.Nextval,?,?,?,?,?,?)";
		//��Ӳ���
		Object[] params = {address.getUserid(),address.getArea(),
				address.getAddress(),address.getZipcode(),address.getName(),address.getTel()};
		int num=this.update(sql, params);
		if(num>0){
			return true;
		}
		return false;
	}
	
	
	//ͨ����ַ��Ų�ѯ��ַ��Ϣ
	@Override
	public UserAddress queryAddressById(int id) {
		String sql="select * from userAddress where Id=?";
		Object[] params={id};
		return this.queryAddressById(sql, params);
	}

	
	
	
	//�����ڲ��ڴ����ַ��Ϣ�����
	public class MyResultSetHandler implements ResultSetHandler{
		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList<UserAddress> list = new ArrayList<UserAddress>();
			while (rs.next()) {
				UserAddress address=new UserAddress(rs.getInt(1),
						rs.getInt(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7));
				list.add(address);
			}
			return list;
		}
	}




	//��Ӷ�����ķ���
	public int addOrderTable(Ordertable order) {
		String sql="insert into ordertable values(?,sysdate,?,?,?,?,?,'δ����')";
		//��Ӳ���
		Object[] params = {order.getOrderid(),order.getOrderPrice(),
				order.getUserid(),order.getUsername(),order.getOrderAddress(),
				order.getPhoen()};
		return this.update(sql, params);
	}


	//��Ӷ�����ϸ��ķ���
	public int addOrderMx(Orderlist ordermx) {
		String sql="insert into orderlist values(seq_orderliste_id.nextval,?,?,?)";
		Object[] params={ordermx.getOrderId(),ordermx.getShoesid(),ordermx.getShoesnum()};
		return this.update(sql, params);
	}


	


	
	
}
