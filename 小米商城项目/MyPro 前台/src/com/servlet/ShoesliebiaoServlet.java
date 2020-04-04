package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Pagination;
import com.service.ShoesInfoService;
import com.service.impl.ShoesInfoServiceImpl;

public class ShoesliebiaoServlet extends HttpServlet {
	private ShoesInfoService service=new ShoesInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	     	//设置编码格式
		request.setCharacterEncoding("UTF-8");
		//获取分页查询类型的值
		String type= request.getParameter("type");
		//接收搜索框的参数值 
		String key = request.getParameter("key");
		//设置当前页码
		int page=1;
		//实例化分页类对象
		Pagination pagination=new Pagination();
		//设置当前页
        if(request.getParameter("page")!=null){
     	   page=Integer.parseInt(request.getParameter("page"));
     	   pagination.setCurrentPage(page);
        }
        //调用分页的方法
      	service.findPages(type, key, pagination);
        //将分页类对象绑定到作用域
      	request.setAttribute("pagination", pagination);
        //转发到列表页面
      	request.getRequestDispatcher("MyShoes/liebiao.jsp").forward(request, response);
	}
}
