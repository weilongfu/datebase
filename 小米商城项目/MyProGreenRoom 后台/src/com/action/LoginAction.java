package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

public class LoginAction extends ActionSupport implements ModelDriven<Admin> {
	// 实例化数据库操作类对象
	private AdminService service = new AdminServiceImpl();
	//声明实体类对象
	private Admin admins=new Admin();
	
	public Admin getModel() {
		return admins;
	}

	public String login() throws Exception {
		// 利用模型驱动获取请求页面的参数
		//获取out对象
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		//获取session对对象
		HttpSession session=request.getSession();
		//调用数据库登录的方法
		Admin admin=service.login(admins.getAdminName(), admins.getAdminPwd());
		if(admin!=null){
			session.setAttribute("admin", admin);
			//重定向到处理后台首页的action
			return "login";
		} else {
			out.print("<script type='text/javascript'>alert('登录失败！');"
					+ "window.location ='GreenGoom/Login.jsp'</script>");
			return "loginsb";
		}
		
	}

}
