package com.dao;

import java.util.ArrayList;

import com.bean.Pagination;
import com.bean.Shoesinfo;

public interface ShoesInfoDao {
	/**
	 * 根据关键字，实现分页 查询
	 * @param key
	 * @param pagination
	 */
   public void findPages(String type,String key,Pagination pagination);
   
   /**
    * 通过商品编号查询商品信息
    */
   public Shoesinfo queryById(int id); 
}
