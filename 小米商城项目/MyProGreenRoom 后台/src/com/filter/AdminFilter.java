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
 * 判断是否是超级管理员登录
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

		// 设置编码格式
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		// 得到session对象
		HttpSession session = req.getSession();
		// 得到当前请求的uri地址信息
		String path = req.getRequestURI();
		// 得到工程名
		String serverName = req.getContextPath();
		// 判断如果请求的是执行管理员操作的admin.do页面 并且当前管理员等级是超级管理员就跳过拦截机制
		if (path.equals(serverName + "/admin.do")) {
			
			// 得到session的admmin属性
			Admin admin = (Admin) session.getAttribute("admin");
			// 得到当前登录的管理员等级
			String AdminGrade = admin.getAdminGrade();
			if (AdminGrade.equals("超级管理员")) {
				chain.doFilter(request, response);
			} else {
				out.print("<script type='text/javascript'>alert('权限不足，您不是超级管理员！');"
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
