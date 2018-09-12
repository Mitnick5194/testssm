package com.ajie.member;

import com.ajie.pojo.Member;

public interface MemberService {

	Member getMemberById(int id);

	public void insertMember(MemberInter mem);
}
