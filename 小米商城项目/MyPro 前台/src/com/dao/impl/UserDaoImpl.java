package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Shoesinfo;
import com.bean.User;
import com.dao.UserDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class UserDaoImpl extends MyJdbcTemplate implements UserDao {

	/**
	 * 判断用户登录的方法
	 */
	public User login(String uname, String pwd) {
		String sql = "select * from tb_user where uname=? and pwd=?";
		// 添加参数
		Object[] params = { uname, pwd };
		return this.selectByid(sql, params);
	}

	/**
	 * 注册
	 */
	public int register(User user) {
		String sql = "insert into tb_user values(seq_tb_user_userid.nextval,?,?,?)";
		Object[] params = { user.getUname(), user.getPwd(), user.getUphone() };
		return this.update(sql, params);
	}

	/**
	 * 进入主页的方法
	 */
	@Override
	public ArrayList toindex(String keyword, String shoesstate) {
		String sql = "select * from shoesinfo where keyword=? and shoesstate=? and shoesstate='上架'";
		Object[] params = { keyword, shoesstate };
		return this.query(sql, params, new MyResultSetHandler());
	}

	public class MyResultSetHandler implements ResultSetHandler {

		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList<Shoesinfo> list = new ArrayList<Shoesinfo>();
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
}
