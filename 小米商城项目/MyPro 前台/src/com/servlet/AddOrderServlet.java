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
 * 进入订单页面或添加订单的servlet
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
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		// 获取请求页面的参数
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
	 * 进入订单jsp页面（查询当前用户所有收货地址）的方法
	 */
	protected void goorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从session获取当前用户的用户编号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 如果已有用户登录 通过当前用户编号查询收货地址信息
		if (user != null) {
			// 实例化数据库操作类对象
			UserAddressService service = new UserAddressServiceImpl();

			// 获取当前登录用户对应的收货地址
			ArrayList<UserAddress> userAddress = service.queryById(user
					.getUserid());
			// 将当前用户的所有收货地址放入session
			session.setAttribute("userAddresses", userAddress);
			// 重定向到订单页面
			response.sendRedirect("MyShoes/Order.jsp");
		}
	}

	/**
	 * 添加收货地址信息的方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addOrderAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从session获取当前用户的用户编号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 如果已有用户登录 拿到当前用户编号
		if (user != null) {
			// 创建地址对象
			UserAddress myAdd = new UserAddress(0, user.getUserid(),
					request.getParameter("txtArea"),
					request.getParameter("txtAddress"),
					request.getParameter("txtZipcode"),
					request.getParameter("txtName"),
					request.getParameter("txtTel"));
			// 实例化数据库操作类对象
			UserAddressService service = new UserAddressServiceImpl();
			// 调用数据库添加地址信息的方法
			boolean bool = service.addUserAddress(myAdd);
			if (bool) {
				// 重新调用查询当前用户所有地址信息的方法
				goorder(request, response);
			}
		}

	}

	/**
	 * 添加订单以及订单明细的方法
	 */
	protected void addorder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取当前登录用户的用户编号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 获取收货地址编号
		int addId = Integer.parseInt(request.getParameter("addressId"));
		// 实例化数据库操作对象
		UserAddressService service = new UserAddressServiceImpl();
		// 通过收货地址编号获取收货地址信息
		UserAddress address = service.queryAddressById(addId);
		// 获取session中的购物车
		ShopCar car = (ShopCar) session.getAttribute("car");
		// 获取商品项集合
		HashMap<Integer, ShopCarItem> items = car.getItems();
		
		//调用数据库添加订单表和订单明细表的方法
		service.addOrder(items, address, car, user);
		
		//清空购物车
		session.removeAttribute("car");
		
		//重定向到主页
		response.sendRedirect("MyShoes/index.jsp");
	}
	
	
}
