package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet{
	//实例化数据库操作类对象
	 private UserService service = new UserServiceImpl();
	
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
        	  String method = request.getParameter("method");
        	  switch (method) {
			case "query":
				 query(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "toUpdate":
				toUpdate(request, response);
			case "updateUser":
				updateUser(request, response);
				break;
			case "addUser":
				addUser(request, response);
				break;
			case "toAddUser":
				toAddUser(request, response);
				break;
			default:
				break;
			}
        }
          
          
          //进入查看用户信息的servlet页面
          protected void query(HttpServletRequest request, HttpServletResponse response)
              	throws ServletException, IOException {
        	  
        	  ArrayList<User> list = service.query();
        	  //绑定到作用域
        	  request.setAttribute("list", list);
        	  //转发到查看用户信息的jsp页面
        	  request.getRequestDispatcher("GreenGoom/Userinfo.jsp").forward(request, response);
          }
          
          //删除用户信息的方法
          protected void delete(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //获取用户id
        	  int userid=Integer.parseInt(request.getParameter("userid"));
        	  //调用根据用户编号删除用户信息的方法
        	  service.delete(userid);
        	  //转发到查看所有用户信息的方法
        	  query(request, response);
          }
          
          //进入修改用户信息的方法
          protected void toUpdate(HttpServletRequest request, HttpServletResponse response)
              	throws ServletException, IOException {
        	  //获取用户id
        	  int userid=Integer.parseInt(request.getParameter("userid"));
        	  //调用根据用户编号查询用户信息的方法
        	  User user=service.toUpdate(userid);
        	  //绑定到作用域
        	  request.setAttribute("user", user);
        	  //转到修改用户信息的jsp页面
        	  request.getRequestDispatcher("GreenGoom/UpdateUser.jsp").forward(request, response);
          }
          
          //修改用户信息的方法
          protected void updateUser(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //获取用户id
        	  int userid=Integer.parseInt(request.getParameter("userid"));
        	  //获取修改之后的值
        	  String uname = request.getParameter("uname");
        	  String pwd = request.getParameter("pwd");
        	  String uphone = request.getParameter("uphone");
        	  //实例化用户对象
        	  User user = new User(userid,uname,pwd,uphone);
        	  //调用数据库修改用户信息的方法
        	  service.update(user);
        	  //修改成功 转发到显示所有用户信息的jsp页面
        	  query(request, response);
          }
          
          
          //添加用户的方法
          protected void addUser(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //获取请求页面的参数
        	  String uname = request.getParameter("uname");
        	  String pwd = request.getParameter("pwd");
        	  String uphone = request.getParameter("uphone");
        	  //实例化用户对象
        	  User user = new User(0,uname,pwd,uphone);
        	  //调用数据库添加用户的方法
        	  service.add(user);
        	  //转发到显示所有用户的jsp页面
        	  query(request, response);
          }
          
          //去添加用户页面的方法
          protected void toAddUser(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //转发到添加用户的jsp页面
        	  request.getRequestDispatcher("GreenGoom/addUser.jsp").forward(request, response);
          }
}
