package com.ajie.pojo;

import com.ajie.member.MemberInter;

public class Member implements MemberInter {

	private Integer id;

	private String name;

	private Integer age;

	private String extra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public String extra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
}