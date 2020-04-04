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
	//ʵ�������ݿ���������
	 private UserService service = new UserServiceImpl();
	
          @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
        		throws ServletException, IOException {
        	doPost(request, response);
        }
          
          @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
        	   //���ñ����ʽ
        	  request.setCharacterEncoding("UTF-8");
               //��ȡ�������
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
          
          
          //����鿴�û���Ϣ��servletҳ��
          protected void query(HttpServletRequest request, HttpServletResponse response)
              	throws ServletException, IOException {
        	  
        	  ArrayList<User> list = service.query();
        	  //�󶨵�������
        	  request.setAttribute("list", list);
        	  //ת�����鿴�û���Ϣ��jspҳ��
        	  request.getRequestDispatcher("GreenGoom/Userinfo.jsp").forward(request, response);
          }
          
          //ɾ���û���Ϣ�ķ���
          protected void delete(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //��ȡ�û�id
        	  int userid=Integer.parseInt(request.getParameter("userid"));
        	  //���ø����û����ɾ���û���Ϣ�ķ���
        	  service.delete(userid);
        	  //ת�����鿴�����û���Ϣ�ķ���
        	  query(request, response);
          }
          
          //�����޸��û���Ϣ�ķ���
          protected void toUpdate(HttpServletRequest request, HttpServletResponse response)
              	throws ServletException, IOException {
        	  //��ȡ�û�id
        	  int userid=Integer.parseInt(request.getParameter("userid"));
        	  //���ø����û���Ų�ѯ�û���Ϣ�ķ���
        	  User user=service.toUpdate(userid);
        	  //�󶨵�������
        	  request.setAttribute("user", user);
        	  //ת���޸��û���Ϣ��jspҳ��
        	  request.getRequestDispatcher("GreenGoom/UpdateUser.jsp").forward(request, response);
          }
          
          //�޸��û���Ϣ�ķ���
          protected void updateUser(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //��ȡ�û�id
        	  int userid=Integer.parseInt(request.getParameter("userid"));
        	  //��ȡ�޸�֮���ֵ
        	  String uname = request.getParameter("uname");
        	  String pwd = request.getParameter("pwd");
        	  String uphone = request.getParameter("uphone");
        	  //ʵ�����û�����
        	  User user = new User(userid,uname,pwd,uphone);
        	  //�������ݿ��޸��û���Ϣ�ķ���
        	  service.update(user);
        	  //�޸ĳɹ� ת������ʾ�����û���Ϣ��jspҳ��
        	  query(request, response);
          }
          
          
          //����û��ķ���
          protected void addUser(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //��ȡ����ҳ��Ĳ���
        	  String uname = request.getParameter("uname");
        	  String pwd = request.getParameter("pwd");
        	  String uphone = request.getParameter("uphone");
        	  //ʵ�����û�����
        	  User user = new User(0,uname,pwd,uphone);
        	  //�������ݿ�����û��ķ���
        	  service.add(user);
        	  //ת������ʾ�����û���jspҳ��
        	  query(request, response);
          }
          
          //ȥ����û�ҳ��ķ���
          protected void toAddUser(HttpServletRequest request, HttpServletResponse response)
                	throws ServletException, IOException {
        	  //ת��������û���jspҳ��
        	  request.getRequestDispatcher("GreenGoom/addUser.jsp").forward(request, response);
          }
}
