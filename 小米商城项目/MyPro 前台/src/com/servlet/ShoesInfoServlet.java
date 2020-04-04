package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Shoesinfo;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class ShoesInfoServlet extends HttpServlet {
	/**
	 * ������ҳ��servlet
	 */
	private UserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		ArrayList<Shoesinfo> list = service.toindex("С�����ǵ�Ʒ", "�ϼ�");
		// �����ݴ���session��
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		// ��̬�õ�������
		String path = request.getContextPath();
		// �ض�����ҳ
		response.sendRedirect(path + "/MyShoes/index.jsp");
	}
}
