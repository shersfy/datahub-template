package com.datahub.template.model;

import com.datahub.commons.beans.BaseEntity;

public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 **/
    private Long id;
    
    /** 角色名称 **/
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
