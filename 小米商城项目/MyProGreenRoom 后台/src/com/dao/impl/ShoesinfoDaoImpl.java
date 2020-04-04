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

	//查询所有商品信息的方法
	public ArrayList<Shoesinfo> query() {
		String sql="select * from shoesinfo";
		return this.query(sql, null, new MyResultSetHandler());
	}
     
	//定义内部类处理商品类结果集
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

	//根据商品编号删除商品的方法
	public int delete(int shoesid) {
		String sql="delete from shoesinfo where shoesid=?";
		//添加参数
		Object[] params={shoesid};
		return this.update(sql, params);
	}

	//根据商品编号查询商品信息
	public Shoesinfo queryById(int shoesid) {
		String sql="select * from shoesinfo where shoesid=?";
		Object[] params={shoesid};
		return this.queryShoesById(sql, params);
	}

	//修改商品信息的方法
	public int updateShoes(Shoesinfo shoes) {
		String sql="update shoesinfo set "
				+ "shoesname=?,shoesprice=?,"
				+ "shoescount=?,shoesstate=?,release=?,"
				+ "color=? where shoesid=?";
		//添加参数
		Object[] params={shoes.getShoesname(),
				shoes.getShoesprice(),shoes.getShoescount(),
				shoes.getShoesstate(),shoes.getRelease(),
				shoes.getColor(),shoes.getShoesid()};
		return this.update(sql, params);
	}

	//添加商品信息的方法
	public int addShoes(Shoes shoes) {
		String sql="insert into shoesinfo values(seq_tb_user_shoesinfoid.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={shoes.getShoesname(),shoes.getShoesprice(),shoes.getIntroduce(),
				shoes.getShoesintr(),shoes.getShoescount(),shoes.getShoesstate(),shoes.getRelease(),
				shoes.getColor(),shoes.getShoesType(),shoes.getKeyword(),shoes.getShoesimg()};
		return this.update(sql, params);
	}
}
