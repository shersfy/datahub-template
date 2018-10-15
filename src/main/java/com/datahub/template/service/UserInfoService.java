package com.datahub.template.service;

import com.datahub.template.model.UserInfo;
import com.datahub.template.model.vo.UserInfoVo;

public interface UserInfoService extends BaseService<UserInfo, Long> {

	UserInfo findByUsername(String username);
	
	/**
	 * PO(持久化对象)转换为VO(值对象)
	 * @param po 持久化对象
	 * @return 值对象
	 */
	UserInfoVo poToVo(UserInfo po);
	
}
