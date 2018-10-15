package com.datahub.template.controller;


import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datahub.commons.beans.Result;
import com.datahub.template.controller.form.UserInfoForm;
import com.datahub.template.model.UserInfo;
import com.datahub.template.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController {

	@Resource
	private UserInfoService userService;
	
	@GetMapping("/list")
	public Result list(UserInfo where, Integer pageNo, Integer pageSize){
		Result result = new Result();
		result.setModel(userService.findPage(where, pageNo == null ? 1 : pageNo, pageSize == null ? 20 : pageSize));
		return result;
	}
	
	@GetMapping("/all")
	public Result list(){
		Result result = new Result();
		result.setModel(userService.findList(new UserInfo()));
		return result;
	}


	@GetMapping("/detail")
	public Result detail(Long id) {
		Result result = new Result();
		result.setModel(userService.findById(id));
		return result;
	}


	@GetMapping("/name")
	public Result getUser(String username) {
		Result result = new Result();
		result.setModel(userService.poToVo(userService.findByUsername(username)));
		return result;
	}
	
	@PostMapping("/delete")
	public Result delete(Long id) {
		Result result = new Result();
		try {
			result.setModel(userService.deleteById(id) == 1);
		} catch (Exception e) {
			result.setCode(FAIL);
			result.setMsg("delete error");
			LOGGER.error("", e);
		}
		return result;
	}

	@PostMapping("/save")
	public Result save(@Valid UserInfoForm form, BindingResult bundle) {
		Result res = new Result();
		if(bundle.hasErrors()) {
			res.setCode(FAIL);
			res.setMsg(errors(bundle.getAllErrors()));
			return res;
		}
		
		try {
			UserInfo info = new UserInfo();
			BeanUtils.copyProperties(info, form);
			
			int cnt;
			if(info.getId()==null) {
				cnt = userService.insert(info);
			} else {
				cnt = userService.updateById(info);
			}
			res.setModel(cnt==1);
		} catch (Exception e) {
			LOGGER.error("", e);
			res.setCode(FAIL);
			res.setMsg("save error");
			res.setModel(false);
		}

		return res;
	}

}
