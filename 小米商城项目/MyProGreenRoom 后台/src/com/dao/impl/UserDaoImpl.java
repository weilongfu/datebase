package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.User;
import com.dao.UserDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class UserDaoImpl extends MyJdbcTemplate implements UserDao{

	@Override
	public ArrayList<User> query() {
		String sql="select * from tb_user";
		return this.query(sql, null, new MyResultSetHandler());
	}


	//定义内部类对用户表的结果集进行处理
	public class MyResultSetHandler implements ResultSetHandler{

		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList<User> list=new ArrayList<User>();
			while (rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				list.add(user);
			}
			return list;
		}
		
	}


	//删除用户信息的方法
	public int delete(int userid) {
		String sql = "delete from tb_user where userid=?";
		//添加参数
		Object[] params={userid};
		return this.update(sql, params);
	}


	//根据用户编号查询用户信息的方法
	public User toUpdate(int userid) {
		String sql="select * from tb_user where userid=?";
		//添加参数
		Object[] params={userid};
		return this.queryById(sql, params);
	}


	//修改用户信息的方法
	public int update(User user) {
		String sql="update tb_user set uname = ? ,pwd=?,uphone=? where userid=?";
		//添加参数
		Object[] params = {user.getUname(),user.getPwd(),user.getUphone(),user.getUserid()};
		return this.update(sql, params);
	}


	//添加用户的方法
	public int add(User user) {
		String sql="insert into tb_user values(seq_tb_user_userid.nextval,?,?,?)";
		//添加参数
		Object [] params={user.getUname(),user.getPwd(),user.getUphone()};
		return this.update(sql, params);
	}
	

}
