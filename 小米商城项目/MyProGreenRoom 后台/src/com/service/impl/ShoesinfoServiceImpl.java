package com.service.impl;

import java.util.ArrayList;

import com.bean.Shoes;
import com.bean.Shoesinfo;
import com.dao.ShoesinfoDao;
import com.dao.impl.ShoesinfoDaoImpl;
import com.service.ShoesinfoService;

public class ShoesinfoServiceImpl implements ShoesinfoService{
  private ShoesinfoDao dao = new ShoesinfoDaoImpl();
	//��ѯ��Ʒ��Ϣ�ķ���
	public ArrayList<Shoesinfo> query() {
		return dao.query();
	}


	//������Ʒ���ɾ����Ʒ��Ϣ�ķ���
	public int delete(int shoesid) {
		return dao.delete(shoesid);
	}


	//������Ʒ��Ų�ѯ��Ʒ��Ϣ
	public Shoesinfo queryById(int shoesid) {
		return dao.queryById(shoesid);
	}


	@Override
	public int updateShoes(Shoesinfo shoes) {
		return dao.updateShoes(shoes);
	}


	//�����Ʒ��Ϣ�ķ���
	public int addShoes(Shoes shoes) {
		return dao.addShoes(shoes);
	}

}
