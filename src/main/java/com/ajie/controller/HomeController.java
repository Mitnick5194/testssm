package com.ajie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajie.member.MemberInter;
import com.ajie.member.MemberService;
import com.ajie.member.User;
import com.ajie.member.UserService;
import com.ajie.member.impl.TestExtService;
import com.ajie.pojo.Member;

@Controller
public class HomeController {
	public static final Logger _Logger = org.slf4j.LoggerFactory.getLogger(HomeController.class);
	public static final String PREFIX = "member/";
	public static final String INDEX_URL = "http://www.ajie18.top:8080/webApp";
	@Resource
	private MemberService memberService;
	@Resource
	private UserService userService;

	public HomeController() {
		System.out.println("初始化控制器");
	}

	@RequestMapping
	String mine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		if (null == id) {
			id = "0";
		}
		MemberInter member = memberService.getMemberById(Integer.valueOf(id));
		if (null == member) {
			_Logger.info("member为空");
		} else {
			_Logger.info(member.getName());
			_Logger.info(member.getAge() + "");
		}
		TestExtService tes = new TestExtService(memberService);
		MemberInter m = tes.getMenber(Integer.valueOf(id));
		if (null != m) {
			System.out.println(m.getName());
		}
		/*
		 * System.out.println(user.getId());
		 * System.out.println(user.getGendar());
		 */
		System.out.println(member.extra());

		request.setAttribute("msg", "param came from controller");
		return PREFIX + "mine";
	}

	@RequestMapping
	String getUser(HttpServletRequest request, HttpServletResponse response) {
		String strId = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.valueOf(strId);
		} catch (NumberFormatException e) {
			id = 0;
		}
		User user = userService.getUser(id);
		List<Integer> roles = user.getUserRoles();
		String name = user.getName();
		System.out.println(name);
		for (Integer roleid : roles) {
			System.out.println(roleid);
		}
		return null;
	}

	@RequestMapping
	void aj_getMenber(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		out.print(new JSONObject().put("isok", true).put("name", member.getName())
				.put("age", member.getAge()));
	}

	private void setAjaxContentType(HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
	}

	private void closeAjax(PrintWriter out) {
		out.flush();
		out.close();
	}

	@RequestMapping
	String addMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberInter member = new Member();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String extra = request.getParameter("extract");
		member.setId(Integer.valueOf(id));
		member.setAge(Integer.valueOf(age));
		member.setName(name);
		member.setExtra(extra);
		memberService.insertMember(member);

		return PREFIX + "mine";
	}
}
