package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Shoesinfo;
import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	// ʵ�������ݿ���������
	private UserService service = new UserServiceImpl();

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
        //��ȡ�������
		String method=request.getParameter("method");
		switch (method) {
		case "login":
			login(request, response);
			break;
		case "reg":
			reg(request, response);
			break;
		case "logout":
			logout(request, response);
		default:
			break;
		}
	}

	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����ҳ��Ĳ���
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		User user = service.login(uname, pwd);
		if (user != null) {
			// ���û���Ϣ����session��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//�õ������¼ǰ��ҳ��
			String url=(String)session.getAttribute("url");
			String path=request.getContextPath();
			if(url==null){
				//����õ��Ľ����¼ǰ��ҳ��Ϊ�յĻ� �����������ҳ��servlet
				url=path+"/index.do";
			}
			// �ض��򵽵�¼ǰ��ҳ��
			response.sendRedirect(path+"/index.do");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "�û������������,�����µ�¼");
			response.sendRedirect("MyShoes/login.jsp");
		}
	}
	
	protected void reg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ�������
		String uname=request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String uphone=request.getParameter("uphone");
		//��ӵ��û�
		User user=new User(0,uname,pwd,uphone);
		//����ע��ķ���
		int num=service.register(user);
		if(num!=0){
			//��ʾע��ɹ�
			out.print("<script type='text/javascript'>alert('ע��ɹ���');window.location ='MyShoes/login.jsp'</script>");
			
		}else{
			//ע��ʧ��
			out.print("<script type='text/javascript'>alert('ע��ʧ�ܣ�');window.location = 'MyShoes/reg.jsp'</script>");
		}
	}
	
	/**
	 * ע������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      // �ûỰ����ʧЧ
	   request.getSession().invalidate();
	   
	   //ע���� �ض�����ҳ
	   response.sendRedirect("index.do");
	}
}
