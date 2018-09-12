package com.ajie.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ajie.member.User;

public class BaseUser implements User {

	private Integer id;

	private String name;

	private String nickname;

	private String password;

	private String synopsis;

	private Byte sex;

	private String phone;

	private String email;

	private Date createtime;

	private Date lastactive;

	private String roles;

	private String header;

	private Integer mark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	/*
	 * public void setName(String name) { this.name = name == null ? null :
	 * name.trim(); }
	 */

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis == null ? null : synopsis.trim();
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastactive() {
		return lastactive;
	}

	public void setLastactive(Date lastactive) {
		this.lastactive = lastactive;
	}

	public List<Integer> getUserRoles() {
		String[] rs = roles.split(",");
		List<Integer> list = new ArrayList<Integer>(rs.length);
		for (String r : rs) {
			try {
				int roleid = Integer.valueOf(r);
				list.add(roleid);
			} catch (Exception e) {
				// TODO 打印日志
			}
		}
		return list;
	}

	public void setRoles(String roles) {
		this.roles = roles == null ? null : roles.trim();
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header == null ? null : header.trim();
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getOuterId() {
		return null;
	}
}