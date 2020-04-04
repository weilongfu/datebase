package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

public class AdminServlet extends HttpServlet {
	// 实例化全局的数据库操作对象
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
		case "query":
			query(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "toupdate":
			toupdate(request, response);
			break;
		case "toAdmin":
			toAdmin(request, response);
			break;
		case "addAdmin":
			addAdmin(request, response);
			break;
		default:
			break;
		}
	}

	// 查看所有管理员信息的方法
	protected void query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 调用查询所有管理员信息的方法
		ArrayList<Admin> list = service.query();
		// 绑定到作用域
		request.setAttribute("list", list);
		// 转发到查看所有管理员信息的jsp页面
		request.getRequestDispatcher("GreenGoom/Admin.jsp").forward(request,
				response);
	}

	// 删除管理员的方法
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的编码格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取管理员编号
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		// 调用数据库根据管理员编号删除管理员的方法
		int num = service.delete(adminId);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('删除成功！');"
					+ "window.location ='admin.do?method=query'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('删除失败！');"
					+ "window.location ='admin.do?method=query'</script>");
		}
	}

	// 进入修改页面的方法
	protected void toupdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取管理员编号
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		// 根据管理员编号查询管理员信息
		Admin admin = service.queryById(adminId);
		// 绑定到作用域
		request.setAttribute("admin", admin);
		// 转发到修改管理员信息的jsp页面
		request.getRequestDispatcher("GreenGoom/UpdateAdmin.jsp").forward(
				request, response);
	}

	// 修改管理员的方法
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的编码格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取管理员编号
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		// 获取请求的参数
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		String adminSex = request.getParameter("adminSex");
		String adminPhone = request.getParameter("adminPhone");
		String adminGrade = request.getParameter("adminGrade");

		// 实例化对象
		Admin admin = new Admin(adminId, adminName, adminPwd, adminSex,
				adminPhone, adminGrade);
		// 调用数据库修改管理员信息的方法
		int num = service.update(admin);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('修改成功！');"
					+ "window.location ='admin.do?method=query'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('修改失败！');"
					+ "window.location ='admin.do?method=query'</script>");
		}
	}

	// 进入添加管理员jsp页面的方法
	protected void toAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 转发到添加管理员的jsp页面
		request.getRequestDispatcher("GreenGoom/AddAdmin.jsp").forward(request,
				response);
	}

	// 添加管理员的方法
	protected void addAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求的编码格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String adminName = request.getParameter("adminName");
		String adminPhone = request.getParameter("adminPhone");
		String adminSex = request.getParameter("adminSex");
		String adminGrade = request.getParameter("adminGrade");
		String adminPwd = request.getParameter("adminPwd");
		// 实例化对象
		Admin admin = new Admin(0, adminName, adminPwd, adminSex, adminPhone,
				adminGrade);
		// 调用数据库添加管理员信息的方法
		int num = service.add(admin);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('添加成功！');"
					+ "window.location ='admin.do?method=query'</script>");
		}else{
			out.print("<script type='text/javascript'>alert('添加失败！');"
					+ "window.location ='admin.do?method=query'</script>");
		}
	}
}
