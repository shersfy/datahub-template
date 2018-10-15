package com.datahub.template.mapper;

import com.datahub.template.model.UserInfo;

public interface UserInfoMapper extends BaseMapper<UserInfo, Long> {

	UserInfo findByUsername(String username);
	
}