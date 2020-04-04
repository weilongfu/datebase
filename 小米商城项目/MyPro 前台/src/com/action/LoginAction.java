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
 * �ж��û���¼��action
 * @author pc
 *
 */
public class LoginAction extends ActionSupport{
	// ʵ�������ݿ���������
	private UserService service = new UserServiceImpl();
	
     @Override
    public String execute() throws Exception {
    	//��ȡrequest�������
    	HttpServletRequest request= ServletActionContext.getRequest();
    	// ��ȡ����ҳ��Ĳ���
    	String uname = request.getParameter("uname");
   		String pwd = request.getParameter("pwd");
    	User user = service.login(uname, pwd);
    	
    	if (user != null) {
			// ���û���Ϣ����session��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//�õ������¼ǰ��ҳ��
			String url=(String)session.getAttribute("url");
			String path=request.getContextPath();
			if(url==null){
				//����õ��Ľ����¼ǰ��ҳ��Ϊ�յĻ� �����������ҳ��servlet
				url=path+"/index.do";
			}
			// �ض��򵽽�����ҳ��action����
			return "true";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "�û������������,�����µ�¼");
		}
    	
    	    return "false";
    }
}
