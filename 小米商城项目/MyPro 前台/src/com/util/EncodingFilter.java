package com.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EncodingFilter implements Filter {
	private String encoding;

	//����������ʱ���Զ����ø÷���
	@Override
	public void destroy() {

	}

	//��ÿ������ʱ���Զ�����
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("encoding............");

		// �õ���ǰ������ʽ
		String method = req.getMethod();

		if ("post".equalsIgnoreCase(method)) {
			// ��������ı���ΪUTF-8,ֻ�ܽ��post��ʽ�µ���������
			request.setCharacterEncoding(encoding);
		} else {
			// String name=request.getParameter("name");
			// name= new String(name.getBytes("ISO-8859-1"),"UTF-8");
			// �õ����е����������ֵ��map<String,String[]>
			Map<String, String[]> map = req.getParameterMap();
			// ������ֵ
			for (String[] values : map.values()) {
				for (int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("ISO-8859-1"),
							"UTF-8");
				}
			}
		}
        HttpSession session = req.getSession();
       
		chain.doFilter(request, response);

		System.out.println("encoding-----end");
	}

	//��������ʼ��ʱ���Զ����ø÷���
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// �õ���������������Ϣ
		encoding = filterConfig.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}

	}

}
