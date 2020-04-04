package com.dao;

import java.util.ArrayList;

import com.bean.Orderinfo;
import com.bean.Ordertable;


public interface OrderDao {
  //��ѯ���ж����ķ���
	public ArrayList<Ordertable> query();
	
	//���ݶ�����Ų鿴��������ķ���
	public ArrayList<Orderinfo> queryOrderinfoById(String orderid);
	
	//���ݶ�����Ų�ѯ������Ϣ�ķ���
	public Ordertable queryById(String orderid);
	
	//���ݶ�������޸Ķ���״̬�ķ���
	public int updateById(String orderid,String orderstase);
}
