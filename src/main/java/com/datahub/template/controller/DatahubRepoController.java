package com.datahub.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datahub.template.feign.DatahubRepoClient;

@RestController
public class DatahubRepoController extends BaseController{
	
	@Autowired
	private DatahubRepoClient client;
	
	@GetMapping("/tmp/repo/dbtype/list")
	public Object listDbTyps(Boolean support){
		return client.callListDbtype(support);
	}
	
}
