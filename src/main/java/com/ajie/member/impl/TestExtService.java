package com.ajie.member.impl;

import com.ajie.member.MemberService;
import com.ajie.pojo.Member;

/**
 * 继承是不行的 事例化TestExtService时也会new一个MemberServiceImpl
 * 根本就不是spring注入的MemberServiceImpl
 * 
 * @author niezhenjie
 */
public class TestExtService /*extends MemberServiceImpl */{
	MemberService memberSrevice;
	public TestExtService(MemberService memberSrevice){
		this.memberSrevice = memberSrevice;
	}
	
	public Member getMenber(int id) {
		Member menber = memberSrevice.getMemberById(id);
		return menber;
	}
}
