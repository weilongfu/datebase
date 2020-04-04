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
	// ʵ����ȫ�ֵ����ݿ��������
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

	// �鿴���й���Ա��Ϣ�ķ���
	protected void query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ò�ѯ���й���Ա��Ϣ�ķ���
		ArrayList<Admin> list = service.query();
		// �󶨵�������
		request.setAttribute("list", list);
		// ת�����鿴���й���Ա��Ϣ��jspҳ��
		request.getRequestDispatcher("GreenGoom/Admin.jsp").forward(request,
				response);
	}

	// ɾ������Ա�ķ���
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��������ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ����Ա���
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		// �������ݿ���ݹ���Ա���ɾ������Ա�ķ���
		int num = service.delete(adminId);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('ɾ���ɹ���');"
					+ "window.location ='admin.do?method=query'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('ɾ��ʧ�ܣ�');"
					+ "window.location ='admin.do?method=query'</script>");
		}
	}

	// �����޸�ҳ��ķ���
	protected void toupdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����Ա���
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		// ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
		Admin admin = service.queryById(adminId);
		// �󶨵�������
		request.setAttribute("admin", admin);
		// ת�����޸Ĺ���Ա��Ϣ��jspҳ��
		request.getRequestDispatcher("GreenGoom/UpdateAdmin.jsp").forward(
				request, response);
	}

	// �޸Ĺ���Ա�ķ���
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��������ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ����Ա���
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		// ��ȡ����Ĳ���
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		String adminSex = request.getParameter("adminSex");
		String adminPhone = request.getParameter("adminPhone");
		String adminGrade = request.getParameter("adminGrade");

		// ʵ��������
		Admin admin = new Admin(adminId, adminName, adminPwd, adminSex,
				adminPhone, adminGrade);
		// �������ݿ��޸Ĺ���Ա��Ϣ�ķ���
		int num = service.update(admin);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('�޸ĳɹ���');"
					+ "window.location ='admin.do?method=query'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('�޸�ʧ�ܣ�');"
					+ "window.location ='admin.do?method=query'</script>");
		}
	}

	// ������ӹ���Աjspҳ��ķ���
	protected void toAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ת������ӹ���Ա��jspҳ��
		request.getRequestDispatcher("GreenGoom/AddAdmin.jsp").forward(request,
				response);
	}

	// ��ӹ���Ա�ķ���
	protected void addAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��������ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String adminName = request.getParameter("adminName");
		String adminPhone = request.getParameter("adminPhone");
		String adminSex = request.getParameter("adminSex");
		String adminGrade = request.getParameter("adminGrade");
		String adminPwd = request.getParameter("adminPwd");
		// ʵ��������
		Admin admin = new Admin(0, adminName, adminPwd, adminSex, adminPhone,
				adminGrade);
		// �������ݿ���ӹ���Ա��Ϣ�ķ���
		int num = service.add(admin);
		if (num > 0) {
			out.print("<script type='text/javascript'>alert('��ӳɹ���');"
					+ "window.location ='admin.do?method=query'</script>");
		}else{
			out.print("<script type='text/javascript'>alert('���ʧ�ܣ�');"
					+ "window.location ='admin.do?method=query'</script>");
		}
	}
}
