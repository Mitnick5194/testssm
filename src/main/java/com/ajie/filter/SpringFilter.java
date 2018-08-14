package com.ajie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SpringFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain nextChain) throws IOException, ServletException {
		System.out.println("调用spring bean注入的filter");
		nextChain.doFilter(arg0, arg1);// 一定要有这句 否则拦截链会断掉 从而无法后面的工作
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("这是从spring bean注入的filter");
	}

}
