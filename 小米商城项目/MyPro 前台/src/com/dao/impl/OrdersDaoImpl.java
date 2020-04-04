package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Orders;
import com.dao.OrdersDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class OrdersDaoImpl extends MyJdbcTemplate implements OrdersDao{

	//≤È—Ø∂©µ•
	public ArrayList<Orders> queryOrders(int userid) {
		String sql="select * from ordertable "
				+ "ta join orderlist li on ta.orderid=li.orderid "
				+ "join shoesinfo info on li.shoesid=info.shoesid "
				+ "where userid=?";
		Object[] params={userid};
		return this.query(sql, params, new MyResultSetHandler());
	}

	public class MyResultSetHandler implements ResultSetHandler{

		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList  list = new ArrayList();
			while (rs.next()) {
				Orders order=new Orders(rs.getString(24),rs.getString(1),rs.getString(8),
						rs.getDouble(15),rs.getDate(2));
				list.add(order);
			}
			return list;
		}
		
	}
}
