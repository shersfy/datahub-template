package com.datahub.template.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.datahub.commons.beans.BaseEntity;

public class UserInfoForm extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 主键 **/
    private Long id;

    /** 用户名 **/
    @NotEmpty(message="username not empty")
    @Length(max=255, message="max length 255")
    private String username;

    /** 密码 **/
    @NotEmpty(message="password not empty")
    @Length(max=255, message="max length 255")
    private String password;

    /** 邮箱 **/
    @NotEmpty(message="email not empty")
    @Email(message="email format error")
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