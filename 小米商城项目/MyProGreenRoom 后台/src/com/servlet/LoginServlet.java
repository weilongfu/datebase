package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Admin;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

public class LoginServlet extends HttpServlet {

	// 实例化数据库操作类对象
	private AdminService service = new AdminServiceImpl();

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
		case "login":
			login(request, response);
			break;
		case "reg":
			reg(request, response);
			break;
		default:
			break;
		}
	}

	// 判断用户登录的方法
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的编码格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取请求页面的参数
		String AdminName = request.getParameter("AdminName");
		String AdminPwd = request.getParameter("AdminPwd");

		Admin admin = service.login(AdminName, AdminPwd);
		// 将当前登录管理员对象存入session
		HttpSession session = request.getSession();
		// 如果登录成功！
		if (admin != null) {
			session.setAttribute("admin", admin);
			// 重定向到处理后台主页的servlet
			response.sendRedirect("shoes.do?method=query");
		} else {
			out.print("<script type='text/javascript'>alert('登录失败！');"
					+ "window.location ='GreenGoom/Login.jsp'</script>");
		}
	}

	// 用户注册的方法
	protected void reg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求的编码格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取 请求页面的参数
		String AdminName = request.getParameter("AdminName");
		String AdminPwd = request.getParameter("AdminPwd");
		String AdminSex = request.getParameter("AdminSex");
		String AdminPhone = request.getParameter("AdminPhone");
		Admin admin = new Admin(0, AdminName, AdminPwd, AdminSex, AdminPhone,
				null);
		// 调用数据库注册管理员的方法
		int num = service.reg(admin);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('注册成功！');window.location ='GreenGoom/Login.jsp'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('注册失败！');window.location ='GreenGoom/reg.jsp'</script>");
		}
	}
}
