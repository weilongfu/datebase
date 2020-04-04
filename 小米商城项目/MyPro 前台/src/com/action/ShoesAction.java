package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.Shoesinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class ShoesAction extends ActionSupport{
	private UserService service = new UserServiceImpl();
	/**
	 * ������ҳ��action
	 * @return
	 */
	public String toindex(){
		//��ȡrequest�������
		HttpServletRequest request=ServletActionContext.getRequest();
		ArrayList<Shoesinfo> list = service.toindex("С�����ǵ�Ʒ", "�ϼ�");
		// �����ݴ���session��
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		return "toindex";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
