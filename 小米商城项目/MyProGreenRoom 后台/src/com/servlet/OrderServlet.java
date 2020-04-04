package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Orderinfo;
import com.bean.Ordertable;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

public class OrderServlet extends HttpServlet{
	//实例化全局数据库操作类对象
	private OrderService service = new OrderServiceImpl();
	
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
        		throws ServletException, IOException {
        	doPost(request, response);
        }
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
            //设置编码格式
        	request.setCharacterEncoding("UTF-8");
        	//获取请求参数
        	String method=request.getParameter("method");
        	switch (method) {
			case "query":
				query(request, response);
				break;
			case "orderinfo":
				orderinfo(request, response);
				break;
			case "toupdate":
				toupdate(request, response);
				break;
			case "update":
				 update(request, response);
				break;
			default:
				break;
			}
        }
        
        //进去查看订单页面的方法
        protected void query(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//调用数据库方法进行查询
        	ArrayList<Ordertable> list= service.query();
        	//绑定到作用域
        	request.setAttribute("list", list);
        	//转发到订单的jsp页面
        	request.getRequestDispatcher("GreenGoom/Orderinfo.jsp").forward(request, response);
        }
        
        
        //进入查看订单详情页面的方法
        protected void orderinfo(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//获取请求参数
        	String orderid = request.getParameter("orderid");
        	//调用数据库查询订单详细信息的方法
        	ArrayList<Orderinfo> list=service.queryOrderinfoById(orderid);
        	//将数据绑定到作用域
        	request.setAttribute("list", list);
        	//转发到订单详情页面
        	request.getRequestDispatcher("GreenGoom/Orderinfos.jsp").forward(request, response);
        }
        
        
        //进入修改订单页面的方法
        protected void toupdate(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//获取请求页面的订单编号
        	String orderid=request.getParameter("orderid");
        	//调用数据库根据订单编号查询订单信息的方法
        	Ordertable order = service.queryById(orderid);
        	//绑定到作用域
        	request.setAttribute("order", order);
        	//转发到修改订单jsp页面
        	request.getRequestDispatcher("GreenGoom/UpdateOrder.jsp").forward(request, response);
        }
        
        
        //修改订单状态的方法
        protected void update(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//获取请求页面的订单编号
        	String orderid=request.getParameter("orderid");
        	//获取修改之后的订单状态
        	String orderstase = request.getParameter("orderstase");
        	//调用数据库根据订单编号修改订单状态的方法
        	service.updateById(orderid, orderstase);
        	//转发查看订单页面的方法
        	query(request, response);
        }
} 
