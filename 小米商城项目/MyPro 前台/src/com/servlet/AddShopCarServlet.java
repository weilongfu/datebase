package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Shoesinfo;
import com.bean.ShopCar;
import com.service.ShoesInfoService;
import com.service.impl.ShoesInfoServiceImpl;

public class AddShopCarServlet extends HttpServlet {
	/**
	 * ��ӹ��ﳵ��servlet
	 */

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
		// ��ȡ����ҳ��Ĳ���
		String method = request.getParameter("method");
		switch (method) {
		case "add":
			add(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		default:
			break;
		}
	}

	// �����Ʒ
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ��������
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		// ���ݼ�ֵ��ѯ��Ʒ���� ��ӵ���Ʒ���
		ShoesInfoService service = new ShoesInfoServiceImpl();
		Shoesinfo shoes = service.queryById(shoesid);
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		// ������ﳵ����Ϊ�վʹ������ﳵ����
		if (car == null) {
			car = new ShopCar();
			session.setAttribute("car", car);
		}
		// ����Ʒ����ӵ����ﳵ
		car.addItem(shoes, 1);
		// ��ԭ��Ʒ��������
		request.setAttribute("shoes", shoes);
		// ��ת��ԭҳ��
		request.getRequestDispatcher("MyShoes/xiangqing.jsp").forward(request,
				response);
	}

	// �޸Ĺ��ﳵ��Ʒ��Ϣ
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�������
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		int num = Integer.parseInt(request.getParameter("num"));

		// ����session����
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		// �ж�session���Ƿ���Car����
		if (car != null) {
			// �������Ʒ��� ������Ʒ����޸���Ʒ����
			car.updateItem(shoesid, num);
		}
		// ��ת�����ﳵҳ��
		response.sendRedirect("MyShoes/ShopCar.jsp");
	}

	// ɾ����Ʒ
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
         //��ȡ����Ʒ�ı��
		int id = Integer.parseInt(request.getParameter("shoesid"));
		
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		// �ж�session���Ƿ���Car����
		if (car != null) {
			//������Ʒ���ɾ����Ʒ��
			car.deleteItem(id);
		}
		// ��ת�����ﳵҳ��
		response.sendRedirect("MyShoes/ShopCar.jsp");
	}
}
