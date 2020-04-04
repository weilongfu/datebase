package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Shoesinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ShoesinfoService;
import com.service.impl.ShoesinfoServiceImpl;

public class IndexAction extends ActionSupport implements ModelDriven<Shoesinfo>{
	private Shoesinfo shoes=new Shoesinfo();
	//����ģ������ ��ȡ�޸�ҳ���ҳ�������
	public Shoesinfo getModel() {
		return shoes;
	}
	
	//ɾ����Ʒ��Ϣ�ķ���
	public String delete(){
		//��ȡɾ������Ʒ���
		HttpServletRequest request=ServletActionContext.getRequest();
		int shoesid=Integer.parseInt(request.getParameter("shoesid"));
		// ʵ�������ݿ���������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//���ø�����Ʒ���ɾ����Ʒ��Ϣ�ķ���
		service.delete(shoesid);
		return "delete";
	}
	
	
	//�����޸�ҳ��ķ���
	public String toUpdate(){
		//��ȡ���
		HttpServletRequest request=ServletActionContext.getRequest();
		int shoesid=Integer.parseInt(request.getParameter("shoesid"));
		// ʵ�������ݿ���������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//����ͨ����Ų�ѯ��Ʒ��Ϣ
		Shoesinfo shoes=service.queryById(shoesid);
		//�󶨵�������
		request.setAttribute("shoes", shoes);
		return "toUpdate";
	}
	
	
	//�޸���Ʒ��Ϣ�ķ���
	public String update(){
		//�õ�
		//ʵ�������ݿ��������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//�������ݿ��޸���Ʒ��Ϣ�ķ��� ��ʹ��ģ��������ȡ�����޸�ҳ��ı����ݶ���Ž�ȥ
		int num=service.updateShoes(this.shoes);
		//ת������̨��ҳ
		return "update";
	}
	
	//������ҳ��ķ���
	public String query(){
		// ʵ�������ݿ���������
		ShoesinfoService service = new ShoesinfoServiceImpl();
		// ���ò�ѯ������Ʒ��Ϣ�ķ���
		ArrayList<Shoesinfo> list = service.query();
		//��ȡ�������
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return "index";
	}
	
	@Override
	public String execute() throws Exception {
		
		return NONE;
	}


}
