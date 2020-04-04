package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req=(HttpServletRequest)request;
		 HttpServletResponse resp=(HttpServletResponse)response;
		 HttpSession session=req.getSession();
		 //�õ�session��user����
		User user=(User) session.getAttribute("user");
		//������ҳ����¼����¼����ҳ�棬��Ҫ��¼��ſɷ���
		String path=req.getRequestURI();
		
		//�õ�������
		String serverName=req.getContextPath();
		
		if(user!=null || path.equals(serverName+"/MyShoes/login.jsp")  //�����¼ҳ�治����
				|| path.equals(serverName+"/login.do")         //���봦���¼ҳ�治����//���봦��ע��ҳ�治����
				|| path.equals(serverName+"/MyShoes/index.jsp")  //������ҳ������
				|| path.equals(serverName+"/index.do")          //���봦����ҳҳ�治����
				|| path.equals(serverName+"/MyShoes/reg.jsp")    //����ע��ҳ�治���� 
				){
			chain.doFilter(request, response);
		}else{
			//����ǰ�����url���浽session��
			session.setAttribute("url", path);
			
			//û�е�¼�������¼ҳ��
			resp.sendRedirect(serverName+"/MyShoes/login.jsp");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
