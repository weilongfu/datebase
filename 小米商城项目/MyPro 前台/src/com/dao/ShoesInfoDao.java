package com.dao;

import java.util.ArrayList;

import com.bean.Pagination;
import com.bean.Shoesinfo;

public interface ShoesInfoDao {
	/**
	 * ���ݹؼ��֣�ʵ�ַ�ҳ ��ѯ
	 * @param key
	 * @param pagination
	 */
   public void findPages(String type,String key,Pagination pagination);
   
   /**
    * ͨ����Ʒ��Ų�ѯ��Ʒ��Ϣ
    */
   public Shoesinfo queryById(int id); 
}
