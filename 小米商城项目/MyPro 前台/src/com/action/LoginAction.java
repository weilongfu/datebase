package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
/**
 * 判断用户登录的action
 * @author pc
 *
 */
public class LoginAction extends ActionSupport{
	// 实例化数据库操作类对象
	private UserService service = new UserServiceImpl();
	
     @Override
    public String execute() throws Exception {
    	//获取request请求对象
    	HttpServletRequest request= ServletActionContext.getRequest();
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
			// 重定向到进入主页的action里面
			return "true";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "用户名或密码错误,请重新登录");
		}
    	
    	    return "false";
    }
}
