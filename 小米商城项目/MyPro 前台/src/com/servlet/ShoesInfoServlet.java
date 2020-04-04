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
	 * 进入主页的servlet
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
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		ArrayList<Shoesinfo> list = service.toindex("小米明星单品", "上架");
		// 将数据存入session中
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		// 动态得到工程名
		String path = request.getContextPath();
		// 重定向到主页
		response.sendRedirect(path + "/MyShoes/index.jsp");
	}
}
