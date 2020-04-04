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
	//ʵ����ȫ�����ݿ���������
	private OrderService service = new OrderServiceImpl();
	
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
        
        //��ȥ�鿴����ҳ��ķ���
        protected void query(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//�������ݿⷽ�����в�ѯ
        	ArrayList<Ordertable> list= service.query();
        	//�󶨵�������
        	request.setAttribute("list", list);
        	//ת����������jspҳ��
        	request.getRequestDispatcher("GreenGoom/Orderinfo.jsp").forward(request, response);
        }
        
        
        //����鿴��������ҳ��ķ���
        protected void orderinfo(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//��ȡ�������
        	String orderid = request.getParameter("orderid");
        	//�������ݿ��ѯ������ϸ��Ϣ�ķ���
        	ArrayList<Orderinfo> list=service.queryOrderinfoById(orderid);
        	//�����ݰ󶨵�������
        	request.setAttribute("list", list);
        	//ת������������ҳ��
        	request.getRequestDispatcher("GreenGoom/Orderinfos.jsp").forward(request, response);
        }
        
        
        //�����޸Ķ���ҳ��ķ���
        protected void toupdate(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//��ȡ����ҳ��Ķ������
        	String orderid=request.getParameter("orderid");
        	//�������ݿ���ݶ�����Ų�ѯ������Ϣ�ķ���
        	Ordertable order = service.queryById(orderid);
        	//�󶨵�������
        	request.setAttribute("order", order);
        	//ת�����޸Ķ���jspҳ��
        	request.getRequestDispatcher("GreenGoom/UpdateOrder.jsp").forward(request, response);
        }
        
        
        //�޸Ķ���״̬�ķ���
        protected void update(HttpServletRequest request, HttpServletResponse response)
            	throws ServletException, IOException {
        	//��ȡ����ҳ��Ķ������
        	String orderid=request.getParameter("orderid");
        	//��ȡ�޸�֮��Ķ���״̬
        	String orderstase = request.getParameter("orderstase");
        	//�������ݿ���ݶ�������޸Ķ���״̬�ķ���
        	service.updateById(orderid, orderstase);
        	//ת���鿴����ҳ��ķ���
        	query(request, response);
        }
} 
