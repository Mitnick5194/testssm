package com.ajie.member;

import java.util.Date;
import java.util.List;

/**
 * @author niezhenjie
 */
public interface User {

	
	/** 标记用户已锁定 */
	public static final int STATE_LOCK = 1 << 0;

	/** 用户没有通过邮箱验证 ， 对象将不做持久操作 */
	public static final int STATE_UNIVERIFICATION = 1 << 1;

	/** 管理员 */
	public static final int SU_ROLE = 0x10000;

	/** 保存用户的session的key */
	public static final String USER_SESSION_KEY = "ussk";

	/** 保存用户账号的session的key */
	public static final String USER_SESSION_ACCOUNT = "ussk-cct";

	/** 保存用户密码的session的key */
	public static final String USER_SESSION_PASSWORD = "ussk-pss";

	/** 回话标识 */
	public static final String USER_COOKIE_SESSION = "uooss";

	public Integer getId();

	public void setId(Integer id);

	public String getName();

	/*public void setName(String name);*/

	public String getNickname();

	public void setNickname(String nickname);

	public String getPassword();

	public void setPassword(String password);

	public String getSynopsis();

	public void setSynopsis(String synopsis);

	public Byte getSex();

	public void setSex(Byte sex);

	public String getPhone();

	public void setPhone(String phone);

	public String getEmail();

	public void setEmail(String email);

	public Date getCreatetime();

	public void setCreatetime(Date createtime);

	public Date getLastactive();

	public void setLastactive(Date lastactive);

	public List<Integer> getUserRoles();

	public void setRoles(String roles);

	public String getHeader();

	public void setHeader(String header);

	public Integer getMark();

	public void setMark(Integer mark);

}
