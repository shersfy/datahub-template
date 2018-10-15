package com.datahub.template.model;

import com.datahub.commons.beans.BaseEntity;

public class UserInfo extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 主键 **/
    private Long id;

    /** 用户名 **/
    private String username;

    /** 密码 **/
    private String password;

    /** 邮箱 **/
    private String email;

    /** 备注 **/
    private String note;

    /** 删除标志(0:正常(默认)，1：删除) **/
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}