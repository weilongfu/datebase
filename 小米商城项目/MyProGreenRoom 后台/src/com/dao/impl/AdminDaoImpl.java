package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Admin;
import com.dao.AdminDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class AdminDaoImpl extends MyJdbcTemplate implements AdminDao{

	// 判断管理员登录的方法
	public Admin login(String AdminName, String AdminPwd) {
		String sql = "select * from Administrator "
				+ "where  AdminName=? and AdminPwd=? ";
		// 添加参数
         Object[] params = {AdminName,AdminPwd};  
		return this.selectByid(sql, params);
	}

	//注册管理员的方法
	public int reg(Admin admin) {
		String sql="insert into Administrator values(seq_Administrator_AdminId.Nextval,?,?,?,?,'普通管理员')";
		//添加参数
		Object[] params = {admin.getAdminName(),admin.getAdminPwd(),
				admin.getAdminSex(),admin.getAdminPhone()};
		return this.update(sql, params);
	}

	//查询所有管理员的方法
	public ArrayList<Admin> query() {
		String sql="select * from Administrator";
		return this.query(sql, null, new ResultSetHandler() {
			@Override
			public ArrayList mapping(ResultSet rs) throws SQLException {
				ArrayList<Admin> list = new ArrayList<Admin>();
				while (rs.next()) {
					Admin admin=new Admin(rs.getInt(1),rs.getString(2),
							rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6));
					list.add(admin);
				}
				return list;
			}
		});
	
	}

	//根据管理员编号删除管理员的方法
	public int delete(int adminId) {
		String sql="delete from Administrator where AdminId=?";
		Object[] params={adminId};
		return this.update(sql, params);
	}

	// 根据管理员编号查询管理员信息
	public Admin queryById(int adminId) {
		String sql="select * from Administrator where AdminId=?";
		Object[] params={adminId};
		return this.queryByAdminId(sql, params);
	}

	//根据管理员编号修改管理员信息的方法
	public int update(Admin admin) {
		String sql="update Administrator set AdminName=?,AdminPwd=?,AdminSex=?,AdminPhone=?,AdminGrade=? where AdminId=?";
		Object[] params={admin.getAdminName(),admin.getAdminPwd(),
				admin.getAdminSex(),admin.getAdminPhone(),
				admin.getAdminGrade(),admin.getAdminId()};
		return this.update(sql, params);
	}

	//添加管理员的方法
	public int add(Admin admin) {
		String sql="insert into Administrator values(seq_Administrator_AdminId.Nextval,?,?,?,?,?)";
		Object[] params={admin.getAdminName(),admin.getAdminPwd(),
				admin.getAdminSex(),admin.getAdminPhone(),admin.getAdminGrade()};
		return this.update(sql, params);
	}

}
