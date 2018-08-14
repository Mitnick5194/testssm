package com.ajie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain nextChain) throws IOException, ServletException {
		System.out.println("进入了TestFilter的doFilter方法");
		nextChain.doFilter(arg0, arg1);

	}

	public void init(FilterConfig config) throws ServletException {
		String param = config.getInitParameter("encoding");
		String param1 = config.getInitParameter("param1");
		String param2 = config.getInitParameter("param2");
		System.out.println(param + "  " + param1 + "  " + param2);

	}

}
