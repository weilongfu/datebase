package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Shoes;
import com.bean.Shoesinfo;
import com.dao.ShoesinfoDao;
import com.util.MyJdbcTemplate;
import com.util.ResultSetHandler;

public class ShoesinfoDaoImpl extends MyJdbcTemplate implements ShoesinfoDao{

	//��ѯ������Ʒ��Ϣ�ķ���
	public ArrayList<Shoesinfo> query() {
		String sql="select * from shoesinfo";
		return this.query(sql, null, new MyResultSetHandler());
	}
     
	//�����ڲ��ദ����Ʒ������
	public class MyResultSetHandler implements ResultSetHandler{

		@Override
		public ArrayList mapping(ResultSet rs) throws SQLException {
			ArrayList<Shoesinfo> list=new ArrayList<Shoesinfo>();
			while (rs.next()) {
				Shoesinfo shoes=new Shoesinfo(rs.getString(12),
						rs.getInt(1),rs.getString(2),rs.getDouble(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),
						rs.getString(7),rs.getString(8),rs.getString(9));
				list.add(shoes);
			}
			return list;
		}
		
		
	}

	//������Ʒ���ɾ����Ʒ�ķ���
	public int delete(int shoesid) {
		String sql="delete from shoesinfo where shoesid=?";
		//��Ӳ���
		Object[] params={shoesid};
		return this.update(sql, params);
	}

	//������Ʒ��Ų�ѯ��Ʒ��Ϣ
	public Shoesinfo queryById(int shoesid) {
		String sql="select * from shoesinfo where shoesid=?";
		Object[] params={shoesid};
		return this.queryShoesById(sql, params);
	}

	//�޸���Ʒ��Ϣ�ķ���
	public int updateShoes(Shoesinfo shoes) {
		String sql="update shoesinfo set "
				+ "shoesname=?,shoesprice=?,"
				+ "shoescount=?,shoesstate=?,release=?,"
				+ "color=? where shoesid=?";
		//��Ӳ���
		Object[] params={shoes.getShoesname(),
				shoes.getShoesprice(),shoes.getShoescount(),
				shoes.getShoesstate(),shoes.getRelease(),
				shoes.getColor(),shoes.getShoesid()};
		return this.update(sql, params);
	}

	//�����Ʒ��Ϣ�ķ���
	public int addShoes(Shoes shoes) {
		String sql="insert into shoesinfo values(seq_tb_user_shoesinfoid.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={shoes.getShoesname(),shoes.getShoesprice(),shoes.getIntroduce(),
				shoes.getShoesintr(),shoes.getShoescount(),shoes.getShoesstate(),shoes.getRelease(),
				shoes.getColor(),shoes.getShoesType(),shoes.getKeyword(),shoes.getShoesimg()};
		return this.update(sql, params);
	}
}
