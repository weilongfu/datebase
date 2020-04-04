package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Admin;
import com.dao.AdminDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class AdminDaoImpl extends MyJdbcTemplate implements AdminDao{

	// �жϹ���Ա��¼�ķ���
	public Admin login(String AdminName, String AdminPwd) {
		String sql = "select * from Administrator "
				+ "where  AdminName=? and AdminPwd=? ";
		// ��Ӳ���
         Object[] params = {AdminName,AdminPwd};  
		return this.selectByid(sql, params);
	}

	//ע�����Ա�ķ���
	public int reg(Admin admin) {
		String sql="insert into Administrator values(seq_Administrator_AdminId.Nextval,?,?,?,?,'��ͨ����Ա')";
		//��Ӳ���
		Object[] params = {admin.getAdminName(),admin.getAdminPwd(),
				admin.getAdminSex(),admin.getAdminPhone()};
		return this.update(sql, params);
	}

	//��ѯ���й���Ա�ķ���
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

	//���ݹ���Ա���ɾ������Ա�ķ���
	public int delete(int adminId) {
		String sql="delete from Administrator where AdminId=?";
		Object[] params={adminId};
		return this.update(sql, params);
	}

	// ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	public Admin queryById(int adminId) {
		String sql="select * from Administrator where AdminId=?";
		Object[] params={adminId};
		return this.queryByAdminId(sql, params);
	}

	//���ݹ���Ա����޸Ĺ���Ա��Ϣ�ķ���
	public int update(Admin admin) {
		String sql="update Administrator set AdminName=?,AdminPwd=?,AdminSex=?,AdminPhone=?,AdminGrade=? where AdminId=?";
		Object[] params={admin.getAdminName(),admin.getAdminPwd(),
				admin.getAdminSex(),admin.getAdminPhone(),
				admin.getAdminGrade(),admin.getAdminId()};
		return this.update(sql, params);
	}

	//��ӹ���Ա�ķ���
	public int add(Admin admin) {
		String sql="insert into Administrator values(seq_Administrator_AdminId.Nextval,?,?,?,?,?)";
		Object[] params={admin.getAdminName(),admin.getAdminPwd(),
				admin.getAdminSex(),admin.getAdminPhone(),admin.getAdminGrade()};
		return this.update(sql, params);
	}

}
