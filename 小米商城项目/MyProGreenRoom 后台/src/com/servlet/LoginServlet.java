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

	// ʵ�������ݿ���������
	private AdminService service = new AdminServiceImpl();

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

	// �ж��û���¼�ķ���
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��������ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ����ҳ��Ĳ���
		String AdminName = request.getParameter("AdminName");
		String AdminPwd = request.getParameter("AdminPwd");

		Admin admin = service.login(AdminName, AdminPwd);
		// ����ǰ��¼����Ա�������session
		HttpSession session = request.getSession();
		// �����¼�ɹ���
		if (admin != null) {
			session.setAttribute("admin", admin);
			// �ض��򵽴����̨��ҳ��servlet
			response.sendRedirect("shoes.do?method=query");
		} else {
			out.print("<script type='text/javascript'>alert('��¼ʧ�ܣ�');"
					+ "window.location ='GreenGoom/Login.jsp'</script>");
		}
	}

	// �û�ע��ķ���
	protected void reg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ ����ҳ��Ĳ���
		String AdminName = request.getParameter("AdminName");
		String AdminPwd = request.getParameter("AdminPwd");
		String AdminSex = request.getParameter("AdminSex");
		String AdminPhone = request.getParameter("AdminPhone");
		Admin admin = new Admin(0, AdminName, AdminPwd, AdminSex, AdminPhone,
				null);
		// �������ݿ�ע�����Ա�ķ���
		int num = service.reg(admin);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('ע��ɹ���');window.location ='GreenGoom/Login.jsp'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('ע��ʧ�ܣ�');window.location ='GreenGoom/reg.jsp'</script>");
		}
	}
}
