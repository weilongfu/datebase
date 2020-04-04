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
		 //得到session的user属性
		User user=(User) session.getAttribute("user");
		//除了首页，登录，登录处理页面，需要登录后才可访问
		String path=req.getRequestURI();
		
		//得到工程名
		String serverName=req.getContextPath();
		
		if(user!=null || path.equals(serverName+"/MyShoes/login.jsp")  //进入登录页面不拦截
				|| path.equals(serverName+"/login.do")         //进入处理登录页面不拦截//进入处理注册页面不拦截
				|| path.equals(serverName+"/MyShoes/index.jsp")  //进入主页不拦截
				|| path.equals(serverName+"/index.do")          //进入处理主页页面不拦截
				|| path.equals(serverName+"/MyShoes/reg.jsp")    //进入注册页面不拦截 
				){
			chain.doFilter(request, response);
		}else{
			//将当前请求的url保存到session中
			session.setAttribute("url", path);
			
			//没有登录，进入登录页面
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
