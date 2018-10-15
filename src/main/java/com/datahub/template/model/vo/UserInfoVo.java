package com.datahub.template.model.vo;

import java.util.List;

import com.datahub.template.model.Role;
import com.datahub.template.model.UserInfo;

/**
 * UserInfo扩展类，用于客户端UI展示用(读)
 * @author shersfy
 *
 */
public class UserInfoVo extends UserInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
