package com.ajie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajie.member.MemberService;
import com.ajie.pojo.Member;

@Controller
public class HomeController {
	public static final Logger _Logger = org.slf4j.LoggerFactory
			.getLogger(HomeController.class);
	public static final String PREFIX = "member/";
	public static final String INDEX_URL = "http://www.ajie18.top:8080/webApp";
	@Resource
	private MemberService memberService;
	public HomeController(){
		System.out.println("初始化控制器");
	}
	@RequestMapping
	String mine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		if (null == id) {
			id = "0";
		}
		Member member = memberService.getMemberById(Integer.valueOf(id));
		if (null == member) {
			_Logger.info("member为空");
		} else {
			_Logger.info(member.getName());
			_Logger.info(member.getAge() + "");
		}
		request.setAttribute("msg", "param came from controller");
		return PREFIX + "mine";
	}

	@RequestMapping
	void aj_getMenber(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		setAjaxContentType(response);
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		if (id == null || "".equals(id)) {
			out.print(new JSONObject().put("isok", false).put("msg", "找不到用户"));
			closeAjax(out);
			return;
		}
		Member member = memberService.getMemberById(Integer.valueOf(id));
		if (null == member) {
			out.print(new JSONObject().put("isok", false).put("msg", "用户不存在"));
			closeAjax(out);
			return;
		}
		out.print(new JSONObject().put("isok", true)
				.put("name", member.getName()).put("age", member.getAge()));
	}

	private void setAjaxContentType(HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
	}

	private void closeAjax(PrintWriter out) {
		out.flush();
		out.close();
	}

}
