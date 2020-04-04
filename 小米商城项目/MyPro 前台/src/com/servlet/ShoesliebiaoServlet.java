package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Pagination;
import com.service.ShoesInfoService;
import com.service.impl.ShoesInfoServiceImpl;

public class ShoesliebiaoServlet extends HttpServlet {
	private ShoesInfoService service=new ShoesInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	     	//���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		//��ȡ��ҳ��ѯ���͵�ֵ
		String type= request.getParameter("type");
		//����������Ĳ���ֵ 
		String key = request.getParameter("key");
		//���õ�ǰҳ��
		int page=1;
		//ʵ������ҳ�����
		Pagination pagination=new Pagination();
		//���õ�ǰҳ
        if(request.getParameter("page")!=null){
     	   page=Integer.parseInt(request.getParameter("page"));
     	   pagination.setCurrentPage(page);
        }
        //���÷�ҳ�ķ���
      	service.findPages(type, key, pagination);
        //����ҳ�����󶨵�������
      	request.setAttribute("pagination", pagination);
        //ת�����б�ҳ��
      	request.getRequestDispatcher("MyShoes/liebiao.jsp").forward(request, response);
	}
}
