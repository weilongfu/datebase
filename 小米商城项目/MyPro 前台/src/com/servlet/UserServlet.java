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
	// 实例化数据库操作类对象
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
        //获取请求参数
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
		// 获取请求页面的参数
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		User user = service.login(uname, pwd);
		if (user != null) {
			// 将用户信息放入session中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//得到进入登录前的页面
			String url=(String)session.getAttribute("url");
			String path=request.getContextPath();
			if(url==null){
				//如果得到的进入登录前的页面为空的话 就跳入进入首页的servlet
				url=path+"/index.do";
			}
			// 重定向到登录前的页面
			response.sendRedirect(path+"/index.do");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "用户名或密码错误,请重新登录");
			response.sendRedirect("MyShoes/login.jsp");
		}
	}
	
	protected void reg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取请求参数
		String uname=request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String uphone=request.getParameter("uphone");
		//添加到用户
		User user=new User(0,uname,pwd,uphone);
		//调用注册的方法
		int num=service.register(user);
		if(num!=0){
			//提示注册成功
			out.print("<script type='text/javascript'>alert('注册成功！');window.location ='MyShoes/login.jsp'</script>");
			
		}else{
			//注册失败
			out.print("<script type='text/javascript'>alert('注册失败！');window.location = 'MyShoes/reg.jsp'</script>");
		}
	}
	
	/**
	 * 注销处理
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      // 让会话立即失效
	   request.getSession().invalidate();
	   
	   //注销完 重定向到主页
	   response.sendRedirect("index.do");
	}
}
