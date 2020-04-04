package com.service.impl;

import com.bean.Pagination;
import com.bean.Shoesinfo;
import com.dao.ShoesInfoDao;
import com.dao.impl.ShoesInfoDaoImpl;
import com.service.ShoesInfoService;

public class ShoesInfoServiceImpl implements ShoesInfoService{
  private ShoesInfoDao dao=new ShoesInfoDaoImpl();
	/**
	 * 根据类型 关键字 分页查询的方法
	 */
	public void findPages(String type, String key, Pagination pagination) {
		dao.findPages(type, key, pagination);
	}
	@Override
	public Shoesinfo queryById(int id) {
		return dao.queryById(id);
	}
      
}
