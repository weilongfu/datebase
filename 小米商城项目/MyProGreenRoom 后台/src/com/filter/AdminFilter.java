package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Admin;
import com.bean.User;

/**
 * �ж��Ƿ��ǳ�������Ա��¼
 * 
 * @author pc
 *
 */
public class AdminFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// ���ñ����ʽ
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		// �õ�session����
		HttpSession session = req.getSession();
		// �õ���ǰ�����uri��ַ��Ϣ
		String path = req.getRequestURI();
		// �õ�������
		String serverName = req.getContextPath();
		// �ж�����������ִ�й���Ա������admin.doҳ�� ���ҵ�ǰ����Ա�ȼ��ǳ�������Ա���������ػ���
		if (path.equals(serverName + "/admin.do")) {
			
			// �õ�session��admmin����
			Admin admin = (Admin) session.getAttribute("admin");
			// �õ���ǰ��¼�Ĺ���Ա�ȼ�
			String AdminGrade = admin.getAdminGrade();
			if (AdminGrade.equals("��������Ա")) {
				chain.doFilter(request, response);
			} else {
				out.print("<script type='text/javascript'>alert('Ȩ�޲��㣬�����ǳ�������Ա��');"
						+ "window.location ='shoes.do?method=query'</script>");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
