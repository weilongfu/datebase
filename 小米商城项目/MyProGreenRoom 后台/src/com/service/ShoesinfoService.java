package com.service;

import java.util.ArrayList;

import com.bean.Shoes;
import com.bean.Shoesinfo;

public interface ShoesinfoService {
	// ��ѯ������Ʒ��Ϣ�ķ���
	public ArrayList<Shoesinfo> query();

	// ������Ʒ���ɾ����Ʒ�ķ���
	public int delete(int shoesid);
	
	//������Ʒ��Ų�ѯ��Ʒ��Ϣ
	public Shoesinfo queryById(int shoesid);
	
	//�޸���Ʒ��Ϣ�ķ���
	public int updateShoes(Shoesinfo shoes);
	
	//�����Ʒ��Ϣ�ķ���
	public int addShoes(Shoes shoes);
}
