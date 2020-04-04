package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.bean.Admin;
import com.bean.Ordertable;
import com.bean.Pagination;
import com.bean.Shoesinfo;
import com.bean.User;
public class MyJdbcTemplate {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement stat;

	/**
	 * 定义对数据库进行增删改的方法
	 */
	public int update(String sql, Object[] params) {
		int num = 0;
		try {
			// 创建连接对象
			con = DBUtil.getConnection();
			// 编写语句对象
			ps = con.prepareStatement(sql);
			// 填充参数
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					if (params[i] instanceof Date) {
						// Date类型进行处理
						Date d = (Date) params[i];
						ps.setTimestamp(i + 1, new Timestamp(d.getTime()));
					} else {
						ps.setObject(i + 1, params[i]);
					}
				}
			}
			// 执行命令返回受影响的行数
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			DBUtil.closeAll(con, ps, rs);
		}
		return num;
	}

	/**
	 * 查询所有 带参数查询的方法
	 */
	public ArrayList query(String sql, Object[] params, ResultSetHandler handler) {
		ArrayList list = new ArrayList();
		try {
			// 创建连接对象
			con = DBUtil.getConnection();
			// 创建语句对象
			ps = con.prepareStatement(sql);
			// 3.设置参数值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 4.执行sql语句
			rs = ps.executeQuery();
			// 5.操作结果集（查询)
			list = handler.mapping(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 得到总记录数的方法
	 */
	public int getRowCount(String sql, Object[] params) {
		int count = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// 返回总记录数
		return count;
	}


	/**
	 * 根据管理员名称和管理员密码 获得管理员的方法
	 */
	public Admin selectByid(String sql, Object[] params) {
		Admin admin=null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				admin=new Admin(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// 返回总记录数
		return admin;
	}

	
	/**
	 * 根据商品id得到商品对象
	 */
public Shoesinfo queryShoesById(String sql, Object[] params) {
	Shoesinfo shoes=null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				 shoes=new Shoesinfo(rs.getString(12),
						rs.getInt(1),rs.getString(2),rs.getDouble(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),
						rs.getString(7),rs.getString(8),rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// 返回总记录数
		return shoes;
	}


	/**
	 * 根据用户编号得到用户对象
	 */
	public User queryById(String sql, Object[] params) {
		User user=null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				 user = new User(rs.getInt(1), rs.getString(2),
						 rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// 返回总记录数
		return user;
	}
	
	

	/**
	 * 根据管理员编号得到管理员对象
	 */
	public Admin queryByAdminId(String sql, Object[] params) {
		Admin admin=null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin(rs.getInt(1), rs.getString(2),
						 rs.getString(3), rs.getString(4),
						 rs.getString(5),rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// 返回总记录数
		return admin;
	}
	
	/**
	 * 分页查询的方法
	 * 
	 * @param sql
	 * @param params
	 * @param handler
	 * @param p
	 */
	public void findPages(String sql, Object[] params,
			ResultSetHandler handler, Pagination p) {
		// 不变的sql语句
		StringBuffer buf = new StringBuffer();
		buf.append("select * from (");
		buf.append("select pages.* ,row_number() over(order by 1) pagenum ");
		buf.append("from (");
		buf.append(sql);
		buf.append(") pages) where pagenum between ? and ?");
		// 得到开始记录
		int start = (p.getCurrentPage() - 1) * p.getPageSize() + 1;
		// 得到结束记录
		int end = p.getCurrentPage() * p.getPageSize();
		// 加上分页后的参数（原来参数+start+end);
		ArrayList newParams = new ArrayList();
		if (params != null) {
			for (Object obj : params) {
				newParams.add(obj);
			}
		}
		newParams.add(start);
		newParams.add(end);
		ArrayList list = this.query(buf.toString(), newParams.toArray(),
				handler);

		// 设置当前显示的记录信息
		p.setList(list);
		// 设置总记录数
		String sqlCount = "select count(*) "
				+ sql.substring(sql.indexOf("from"));
		int rowCount = this.getRowCount(sqlCount, params);
		p.setRowCount(rowCount);
	}
	
	/**
	 * 根据订单编号得到订单对象的方法
	 */
	public Ordertable queryOrderById(String sql, Object[] params) {
		Ordertable order=null;
		try {
			// 创建连接对象
			con = DBUtil.getConnection();
			// 创建语句对象
			ps = con.prepareStatement(sql);
			// 3.设置参数值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 4.执行sql语句
			rs = ps.executeQuery();
			// 5.操作结果集（查询)
			if(rs.next()){
				order=new Ordertable(rs.getString(1),rs.getDate(2),
						rs.getDouble(3),rs.getInt(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, ps, rs);
		}
		return order;
	}
}
