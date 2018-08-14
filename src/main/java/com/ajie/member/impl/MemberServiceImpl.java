package com.ajie.member.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ajie.mapper.MemberMapper;
import com.ajie.member.MemberService;
import com.ajie.pojo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberMapper memberMapper;

	public MemberServiceImpl() {
		System.out.println("成功扫描了member service");
	}

	public Member getMemberById(int id) {
		Member member = memberMapper.selectByPrimaryKey(id);
		return member;
	}

}
