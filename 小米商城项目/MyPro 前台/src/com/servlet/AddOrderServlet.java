package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ShopCar;
import com.bean.ShopCarItem;
import com.bean.User;
import com.bean.UserAddress;
import com.service.UserAddressService;
import com.service.impl.UserAddressServiceImpl;

/**
 * ���붩��ҳ�����Ӷ�����servlet
 * 
 * @author pc
 *
 */
public class AddOrderServlet extends HttpServlet {

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

		case "goorder":
			goorder(request, response);
			break;

		case "addOrderAddress":
			addOrderAddress(request, response);
			break;

		case "addorder":
			addorder(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * ���붩��jspҳ�棨��ѯ��ǰ�û������ջ���ַ���ķ���
	 */
	protected void goorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��session��ȡ��ǰ�û����û����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// ��������û���¼ ͨ����ǰ�û���Ų�ѯ�ջ���ַ��Ϣ
		if (user != null) {
			// ʵ�������ݿ���������
			UserAddressService service = new UserAddressServiceImpl();

			// ��ȡ��ǰ��¼�û���Ӧ���ջ���ַ
			ArrayList<UserAddress> userAddress = service.queryById(user
					.getUserid());
			// ����ǰ�û��������ջ���ַ����session
			session.setAttribute("userAddresses", userAddress);
			// �ض��򵽶���ҳ��
			response.sendRedirect("MyShoes/Order.jsp");
		}
	}

	/**
	 * ����ջ���ַ��Ϣ�ķ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addOrderAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��session��ȡ��ǰ�û����û����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// ��������û���¼ �õ���ǰ�û����
		if (user != null) {
			// ������ַ����
			UserAddress myAdd = new UserAddress(0, user.getUserid(),
					request.getParameter("txtArea"),
					request.getParameter("txtAddress"),
					request.getParameter("txtZipcode"),
					request.getParameter("txtName"),
					request.getParameter("txtTel"));
			// ʵ�������ݿ���������
			UserAddressService service = new UserAddressServiceImpl();
			// �������ݿ���ӵ�ַ��Ϣ�ķ���
			boolean bool = service.addUserAddress(myAdd);
			if (bool) {
				// ���µ��ò�ѯ��ǰ�û����е�ַ��Ϣ�ķ���
				goorder(request, response);
			}
		}

	}

	/**
	 * ��Ӷ����Լ�������ϸ�ķ���
	 */
	protected void addorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ��ǰ��¼�û����û����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// ��ȡ�ջ���ַ���
		int addId = Integer.parseInt(request.getParameter("addressId"));
		// ʵ�������ݿ��������
		UserAddressService service = new UserAddressServiceImpl();
		// ͨ���ջ���ַ��Ż�ȡ�ջ���ַ��Ϣ
		UserAddress address = service.queryAddressById(addId);
		// ��ȡsession�еĹ��ﳵ
		ShopCar car = (ShopCar) session.getAttribute("car");
		// ��ȡ��Ʒ���
		HashMap<Integer, ShopCarItem> items = car.getItems();
		
		//�������ݿ���Ӷ�����Ͷ�����ϸ��ķ���
		service.addOrder(items, address, car, user);
		
		//��չ��ﳵ
		session.removeAttribute("car");
		
		//�ض�����ҳ
		response.sendRedirect("MyShoes/index.jsp");
	}
	
	
}
