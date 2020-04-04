package com.service;

import java.util.ArrayList;

import com.bean.Shoes;
import com.bean.Shoesinfo;

public interface ShoesinfoService {
	// 查询所有商品信息的方法
	public ArrayList<Shoesinfo> query();

	// 根据商品编号删除商品的方法
	public int delete(int shoesid);
	
	//根据商品编号查询商品信息
	public Shoesinfo queryById(int shoesid);
	
	//修改商品信息的方法
	public int updateShoes(Shoesinfo shoes);
	
	//添加商品信息的方法
	public int addShoes(Shoes shoes);
}
