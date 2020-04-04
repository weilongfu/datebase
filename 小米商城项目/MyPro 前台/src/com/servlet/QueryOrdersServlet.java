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
 * 查看当前用户订单信息的servlet
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
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		// 获取请求参数
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
	 * 查询当前用户的所有订单信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void queryOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取当前登录的用户的用户编号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//调用数据库根据用户编号查询订单信息的方法
		OrdersService service = new OrdersServiceImpl();
		ArrayList<Orders> list=service.queryOrders(user.getUserid());
		//将订单信息绑定到作用域
		request.setAttribute("orders", list);
		//转发到订单页面
		request.getRequestDispatcher("MyShoes/Ordersinfo.jsp").forward(request, response);
	}
}
