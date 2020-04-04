package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Pagination;
import com.bean.Shoesinfo;
import com.dao.ShoesInfoDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class ShoesInfoDaoImpl extends MyJdbcTemplate implements ShoesInfoDao {

	/**
	 * 根据类型 关键字，实现分页 查询
	 * 
	 * @param key
	 * @param pagination
	 */
	public void findPages(String type, String key, Pagination pagination) {
		String sql = "select * from shoesinfo where 1=1 and shoesstate='上架'";
		// 添加参数
		ArrayList params = new ArrayList();
		if (type != null) {
			sql += " and shoesType=?";
			params.add(type);
		}
		if (key != null) {
			// 根据商品名称 商品类型进行迷糊查询
			sql += " and shoesname like ? or shoesType like ?";
			params.add("%" + key + "%");
			params.add("%" + key + "%");
		}

		this.findPages(sql, params.toArray(), new MyShoesInfoResult(),
				pagination);

	}

	private class MyShoesInfoResult implements ResultSetHandler {

		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList list = new ArrayList();
			while (rs.next()) {
				Shoesinfo shoes = new Shoesinfo(rs.getInt(1), rs.getString(2),
						rs.getFloat(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12));
				list.add(shoes);
			}
			return list;
		}

	}

	/**
	 * 根据商品编号查询商品信息
	 */
	@Override
	public Shoesinfo queryById(int id) {
		String sql = "select * from shoesinfo where shoesid=? and shoesstate='上架'";
		// 添加参数
		Object[] params = { id };
		return this.queryById(sql, params);
	}

}
