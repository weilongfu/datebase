package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Orders;
import com.bean.User;
import com.service.OrdersService;
import com.service.impl.OrdersServiceImpl;

/**
 * �鿴��ǰ�û�������Ϣ��servlet
 * 
 * @author pc
 *
 */
public class QueryOrdersServlet extends HttpServlet {
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
		// ��ȡ�������
		String method = request.getParameter("method");
		switch (method) {
		case "queryOrder":
			queryOrder(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * ��ѯ��ǰ�û������ж�����Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void queryOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ��ǰ��¼���û����û����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//�������ݿ�����û���Ų�ѯ������Ϣ�ķ���
		OrdersService service = new OrdersServiceImpl();
		ArrayList<Orders> list=service.queryOrders(user.getUserid());
		//��������Ϣ�󶨵�������
		request.setAttribute("orders", list);
		//ת��������ҳ��
		request.getRequestDispatcher("MyShoes/Ordersinfo.jsp").forward(request, response);
	}
}
