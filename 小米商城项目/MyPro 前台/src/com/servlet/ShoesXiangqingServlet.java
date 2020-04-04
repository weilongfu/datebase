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
//定义全局的数据库操作方法
	private ShoesInfoService service=new ShoesInfoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		//获取请求页面的参数
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
		//获取请求页面的商品编号
		int shoesid=Integer.parseInt(request.getParameter("shoesid"));
		//根据商品编号查询商品信息 并返回商品信息
		Shoesinfo shoes=this.service.queryById(shoesid);
		//将商品信息绑定到作用域
		request.setAttribute("shoes", shoes);
		//转发到商品详情页面
		request.getRequestDispatcher("MyShoes/xiangqing.jsp").forward(request, response);
	}
		
	
}
