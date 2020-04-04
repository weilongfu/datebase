package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.Shoesinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class ShoesAction extends ActionSupport{
	private UserService service = new UserServiceImpl();
	/**
	 * 进入主页的action
	 * @return
	 */
	public String toindex(){
		//获取request请求对象
		HttpServletRequest request=ServletActionContext.getRequest();
		ArrayList<Shoesinfo> list = service.toindex("小米明星单品", "上架");
		// 将数据存入session中
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		return "toindex";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
