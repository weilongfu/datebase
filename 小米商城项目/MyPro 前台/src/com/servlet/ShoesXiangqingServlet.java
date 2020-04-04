package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Shoesinfo;
import com.service.ShoesInfoService;
import com.service.impl.ShoesInfoServiceImpl;

public class ShoesXiangqingServlet extends HttpServlet {
//����ȫ�ֵ����ݿ��������
	private ShoesInfoService service=new ShoesInfoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		//��ȡ����ҳ��Ĳ���
		String method = request.getParameter("method");
		switch (method) {
		case "shoes":
			toshoes(request, response);
			break;

		default:
			break;
		}
	}
	
	
	protected void toshoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����ҳ�����Ʒ���
		int shoesid=Integer.parseInt(request.getParameter("shoesid"));
		//������Ʒ��Ų�ѯ��Ʒ��Ϣ ��������Ʒ��Ϣ
		Shoesinfo shoes=this.service.queryById(shoesid);
		//����Ʒ��Ϣ�󶨵�������
		request.setAttribute("shoes", shoes);
		//ת������Ʒ����ҳ��
		request.getRequestDispatcher("MyShoes/xiangqing.jsp").forward(request, response);
	}
		
	
}
