package com.service.impl;

import java.util.ArrayList;

import com.bean.Shoes;
import com.bean.Shoesinfo;
import com.dao.ShoesinfoDao;
import com.dao.impl.ShoesinfoDaoImpl;
import com.service.ShoesinfoService;

public class ShoesinfoServiceImpl implements ShoesinfoService{
  private ShoesinfoDao dao = new ShoesinfoDaoImpl();
	//查询商品信息的方法
	public ArrayList<Shoesinfo> query() {
		return dao.query();
	}


	//根据商品编号删除商品信息的方法
	public int delete(int shoesid) {
		return dao.delete(shoesid);
	}


	//根据商品编号查询商品信息
	public Shoesinfo queryById(int shoesid) {
		return dao.queryById(shoesid);
	}


	@Override
	public int updateShoes(Shoesinfo shoes) {
		return dao.updateShoes(shoes);
	}


	//添加商品信息的方法
	public int addShoes(Shoes shoes) {
		return dao.addShoes(shoes);
	}

}
