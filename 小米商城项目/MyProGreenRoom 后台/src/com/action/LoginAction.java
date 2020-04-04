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
	// ʵ�������ݿ���������
	private AdminService service = new AdminServiceImpl();
	//����ʵ�������
	private Admin admins=new Admin();
	
	public Admin getModel() {
		return admins;
	}

	public String login() throws Exception {
		// ����ģ��������ȡ����ҳ��Ĳ���
		//��ȡout����
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		//��ȡrequest����
		HttpServletRequest request=ServletActionContext.getRequest();
		//��ȡsession�Զ���
		HttpSession session=request.getSession();
		//�������ݿ��¼�ķ���
		Admin admin=service.login(admins.getAdminName(), admins.getAdminPwd());
		if(admin!=null){
			session.setAttribute("admin", admin);
			//�ض��򵽴����̨��ҳ��action
			return "login";
		} else {
			out.print("<script type='text/javascript'>alert('��¼ʧ�ܣ�');"
					+ "window.location ='GreenGoom/Login.jsp'</script>");
			return "loginsb";
		}
		
	}

}
