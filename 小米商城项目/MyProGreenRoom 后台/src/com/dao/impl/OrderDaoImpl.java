package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Orderinfo;
import com.bean.Ordertable;
import com.dao.OrderDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class OrderDaoImpl extends MyJdbcTemplate implements OrderDao{

	//��ѯ���ж����ķ���
	public ArrayList<Ordertable> query() {
		String sql="select * from ordertable";
		return this.query(sql, null, new MyResultSetHandler());
	}

	
	
	
	
	public class MyResultSetHandler implements ResultSetHandler{

		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList<Ordertable> list=new ArrayList<Ordertable>();
			while (rs.next()) {
				Ordertable order=new Ordertable(rs.getString(1),
						rs.getDate(2),rs.getDouble(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				list.add(order);
			}
			return list;
		}
		
	}





	//���ݶ�����Ų�ѯ��������ķ���
	public ArrayList<Orderinfo> queryOrderinfoById(String orderid) {
		String sql="select * from ordertable ta "
				+ "join orderlist li on ta.orderid=li.orderid  "
				+ "join shoesinfo info on li.shoesid=info.shoesid "
				+ "where ta.orderid=?";
		Object[] params={orderid};
		return this.query(sql, params, new MyResultSet());
	}
	
	//�����ڲ��ദ������
	public class MyResultSet implements ResultSetHandler{

		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList<Orderinfo> list = new ArrayList<Orderinfo>();
			while (rs.next()) {
				Orderinfo orderinfo=new Orderinfo(rs.getString("shoesimg"),
						rs.getString("orderid"),rs.getString("shoesname"),
						rs.getDouble("shoesprice"),rs.getDate("orderDate"),
						rs.getString("username"),rs.getString("orderAddress"),
						rs.getString("phoen"),rs.getString("orderstase"),rs.getString("shoesnum"));
				list.add(orderinfo);
			}
			return list;
		}
		
	}


	//���ݶ�����Ų�ѯ������Ϣ�ķ���
	public Ordertable queryById(String orderid) {
		String sql="select * from ordertable where orderid=?";
		Object[] params={orderid};
		return this.queryOrderById(sql, params);
	}


	//���ݶ�������޸Ķ���״̬�ķ���
	public int updateById(String orderid, String orderstase) {
		String sql="update ordertable set orderstase=? where orderid=?";
		Object[] params={orderstase,orderid};
		return this.update(sql, params);
	}
}
