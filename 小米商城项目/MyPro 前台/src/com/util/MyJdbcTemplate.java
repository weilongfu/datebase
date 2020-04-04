package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.bean.Pagination;
import com.bean.Shoesinfo;
import com.bean.User;
import com.bean.UserAddress;
import com.util.DBUtil;
public class MyJdbcTemplate {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement stat;

	/**
	 * ��������ݿ������ɾ�ĵķ���
	 */
	public int update(String sql, Object[] params) {
		int num = 0;
		try {
			// �������Ӷ���
			con = DBUtil.getConnection();
			// ��д������
			ps = con.prepareStatement(sql);
			// ������
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					if (params[i] instanceof Date) {
						// Date���ͽ��д���
						Date d = (Date) params[i];
						ps.setTimestamp(i + 1, new Timestamp(d.getTime()));
					} else {
						ps.setObject(i + 1, params[i]);
					}
				}
			}
			// ִ���������Ӱ�������
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.�ͷ���Դ
			DBUtil.closeAll(con, ps, rs);
		}
		return num;
	}

	/**
	 * ��ѯ���� ��������ѯ�ķ���
	 */
	public ArrayList query(String sql, Object[] params, ResultSetHandler handler) {
		ArrayList list = new ArrayList();
		try {
			// �������Ӷ���
			con = DBUtil.getConnection();
			// ����������
			ps = con.prepareStatement(sql);
			// 3.���ò���ֵ
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 4.ִ��sql���
			rs = ps.executeQuery();
			// 5.�������������ѯ)
			list = handler.mapping(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * �õ��ܼ�¼���ķ���
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
		// �����ܼ�¼��
		return count;
	}


	/**
	 * ����id�õ�����
	 */
	public User selectByid(String sql, Object[] params) {
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
				user=new User(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// �����ܼ�¼��
		return user;
	}

	
	/**
	 * ���ݵ�ַid�õ���ַ��Ϣ����
	 */
	public UserAddress queryAddressById(String sql, Object[] params) {
		UserAddress address=null;
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
				address=new UserAddress(rs.getInt(1),
				   rs.getInt(2),rs.getString(3),rs.getString(4),
				   rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// �����ܼ�¼��
		return address;
	}

	
	/**
	 * ������Ʒ��ŵõ���Ʒ��Ϣ
	 */
	public Shoesinfo queryById(String sql, Object[] params) {
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
				 shoes = new Shoesinfo(rs.getInt(1), rs.getString(2),
						rs.getFloat(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(con, ps, rs);
		}
		// �����ܼ�¼��
		return shoes;
	}
	/**
	 * ��ҳ��ѯ�ķ���
	 * 
	 * @param sql
	 * @param params
	 * @param handler
	 * @param p
	 */
	public void findPages(String sql, Object[] params,
			ResultSetHandler handler, Pagination p) {
		// �����sql���
		StringBuffer buf = new StringBuffer();
		buf.append("select * from (");
		buf.append("select pages.* ,row_number() over(order by 1) pagenum ");
		buf.append("from (");
		buf.append(sql);
		buf.append(") pages) where pagenum between ? and ?");
		// �õ���ʼ��¼
		int start = (p.getCurrentPage() - 1) * p.getPageSize() + 1;
		// �õ�������¼
		int end = p.getCurrentPage() * p.getPageSize();
		// ���Ϸ�ҳ��Ĳ�����ԭ������+start+end);
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

		// ���õ�ǰ��ʾ�ļ�¼��Ϣ
		p.setList(list);
		// �����ܼ�¼��
		String sqlCount = "select count(*) "
				+ sql.substring(sql.indexOf("from"));
		int rowCount = this.getRowCount(sqlCount, params);
		p.setRowCount(rowCount);
	}
	
	/**
	 * �ж��û���¼�ķ���
	 */
	/*public User login(String sql, Object[] params) {
		User book=null;
		try {
			// �������Ӷ���
			con = DBUtil.getConnection();
			// ����������
			ps = con.prepareStatement(sql);
			// 3.���ò���ֵ
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 4.ִ��sql���
			rs = ps.executeQuery();
			// 5.�������������ѯ)
			if(rs.next()){
				book=new User(rs.getString(1),rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, ps, rs);
		}
		return book;
	}*/
}
