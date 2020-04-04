package com.service.impl;

import com.bean.Pagination;
import com.bean.Shoesinfo;
import com.dao.ShoesInfoDao;
import com.dao.impl.ShoesInfoDaoImpl;
import com.service.ShoesInfoService;

public class ShoesInfoServiceImpl implements ShoesInfoService{
  private ShoesInfoDao dao=new ShoesInfoDaoImpl();
	/**
	 * �������� �ؼ��� ��ҳ��ѯ�ķ���
	 */
	public void findPages(String type, String key, Pagination pagination) {
		dao.findPages(type, key, pagination);
	}
	@Override
	public Shoesinfo queryById(int id) {
		return dao.queryById(id);
	}
      
}
