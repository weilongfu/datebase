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

	//过滤器销毁时，自动调用该方法
	@Override
	public void destroy() {

	}

	//在每次请求时，自动调用
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("encoding............");

		// 得到当前的请求方式
		String method = req.getMethod();

		if ("post".equalsIgnoreCase(method)) {
			// 设置请求的编码为UTF-8,只能解决post方式下的中文问题
			request.setCharacterEncoding(encoding);
		} else {
			// String name=request.getParameter("name");
			// name= new String(name.getBytes("ISO-8859-1"),"UTF-8");
			// 得到所有的请求参数及值得map<String,String[]>
			Map<String, String[]> map = req.getParameterMap();
			// 遍历的值
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

	//过滤器初始化时，自动调用该方法
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 得到过滤器的配置信息
		encoding = filterConfig.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}

	}

}
