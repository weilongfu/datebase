package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Shoesinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ShoesinfoService;
import com.service.impl.ShoesinfoServiceImpl;

public class IndexAction extends ActionSupport implements ModelDriven<Shoesinfo>{
	private Shoesinfo shoes=new Shoesinfo();
	//利用模型驱动 获取修改页面表单页面的数据
	public Shoesinfo getModel() {
		return shoes;
	}
	
	//删除商品信息的方法
	public String delete(){
		//获取删除的商品编号
		HttpServletRequest request=ServletActionContext.getRequest();
		int shoesid=Integer.parseInt(request.getParameter("shoesid"));
		// 实例化数据库操作类对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//调用根据商品编号删除商品信息的方法
		service.delete(shoesid);
		return "delete";
	}
	
	
	//进入修改页面的方法
	public String toUpdate(){
		//获取编号
		HttpServletRequest request=ServletActionContext.getRequest();
		int shoesid=Integer.parseInt(request.getParameter("shoesid"));
		// 实例化数据库操作类对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//调用通过编号查询商品信息
		Shoesinfo shoes=service.queryById(shoesid);
		//绑定到作用域
		request.setAttribute("shoes", shoes);
		return "toUpdate";
	}
	
	
	//修改商品信息的方法
	public String update(){
		//拿到
		//实例化数据库操作对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		//调用数据库修改商品信息的方法 把使用模型驱动获取到的修改页面的表单数据对象放进去
		int num=service.updateShoes(this.shoes);
		//转发到后台主页
		return "update";
	}
	
	//进入主页面的方法
	public String query(){
		// 实例化数据库操作类对象
		ShoesinfoService service = new ShoesinfoServiceImpl();
		// 调用查询所有商品信息的方法
		ArrayList<Shoesinfo> list = service.query();
		//获取请求对象
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return "index";
	}
	
	@Override
	public String execute() throws Exception {
		
		return NONE;
	}


}
