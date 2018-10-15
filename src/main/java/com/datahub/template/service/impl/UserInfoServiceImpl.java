package com.datahub.template.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datahub.template.mapper.BaseMapper;
import com.datahub.template.mapper.UserInfoMapper;
import com.datahub.template.model.Role;
import com.datahub.template.model.UserInfo;
import com.datahub.template.model.vo.UserInfoVo;
import com.datahub.template.service.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, Long>
	implements UserInfoService {
	
	@Autowired
	private UserInfoMapper mapper;

	@Override
	public BaseMapper<UserInfo, Long> getMapper() {
		return mapper;
	}

	@Override
	public UserInfo findByUsername(String username) {
		return mapper.findByUsername(username);
	}

	@Override
	public UserInfoVo poToVo(UserInfo po) {
		if(po==null) {
			return null;
		}
		
		UserInfoVo vo = new UserInfoVo();
		try {
			BeanUtils.copyProperties(vo, po);
			// 查询角色
			// List<Role> roles = roleService.findList(where);
			List<Role> roles = new ArrayList<>();
			Role role = new Role();
			role.setId(1L);
			role.setName("admin");
			role.setCreateTime(po.getCreateTime());
			role.setUpdateTime(po.getUpdateTime());
			roles.add(role);
			vo.setRoles(roles);
			
		} catch (Exception e) {
			// ignore
		}
		return vo;
	}
	
}
