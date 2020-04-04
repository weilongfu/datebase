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
	 * 添加购物车的servlet
	 */

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

	// 添加商品
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到请求参数
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		// 根据键值查询商品对象 添加到商品项集合
		ShoesInfoService service = new ShoesInfoServiceImpl();
		Shoesinfo shoes = service.queryById(shoesid);
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		// 如果购物车对象为空就创建购物车对象
		if (car == null) {
			car = new ShopCar();
			session.setAttribute("car", car);
		}
		// 将商品项添加到购物车
		car.addItem(shoes, 1);
		// 将原商品到作用域
		request.setAttribute("shoes", shoes);
		// 跳转到原页面
		request.getRequestDispatcher("MyShoes/xiangqing.jsp").forward(request,
				response);
	}

	// 修改购物车商品信息
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取请求参数
		int shoesid = Integer.parseInt(request.getParameter("shoesid"));
		int num = Integer.parseInt(request.getParameter("num"));

		// 创建session对象
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		// 判断session中是否有Car对象
		if (car != null) {
			// 传入此商品编号 根据商品编号修改商品数量
			car.updateItem(shoesid, num);
		}
		// 跳转到购物车页面
		response.sendRedirect("MyShoes/ShopCar.jsp");
	}

	// 删除商品
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
         //获取此商品的编号
		int id = Integer.parseInt(request.getParameter("shoesid"));
		
		HttpSession session = request.getSession();
		ShopCar car = (ShopCar) session.getAttribute("car");
		// 判断session中是否有Car对象
		if (car != null) {
			//根据商品编号删除商品项
			car.deleteItem(id);
		}
		// 跳转到购物车页面
		response.sendRedirect("MyShoes/ShopCar.jsp");
	}
}
