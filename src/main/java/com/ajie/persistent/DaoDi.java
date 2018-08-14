package com.ajie.persistent;

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public abstract class DaoDi<T> {

	/** 项目的抽象路径 */
	public static final String ROOT_PATH = System.getProperty("user.dir")
			+ File.separator + "webapp";
	public static final String CLASS_PATH = ROOT_PATH + File.separator
			+ "WEB-INF" + File.separator + "classes" + File.separator;

	private T p_Bean;

	protected DaoDi(T bean) {
		p_Bean = bean;
	}

	public T getBean() {
		return p_Bean;
	}

	public void save() {

	}

	@SuppressWarnings("unused")
	public void invoke(String methodName) {
		URL[] urls = new URL[1];
		URLClassLoader loader = null;
		try {
			urls[0] = new URL("file", null, CLASS_PATH);
			loader = new URLClassLoader(urls);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String className = p_Bean.getClass().getName();
		try {
			Class<?> clazz = loader.loadClass(className);
			Field[] fields = clazz.getFields();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
