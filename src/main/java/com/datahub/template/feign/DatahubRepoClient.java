package com.datahub.template.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datahub.template.hystrix.DatahubRepoFallbackFactory;

/**
 * 微服务datahub-repository调用FeignClient
 * @author shersfy
 *
 */
@FeignClient(name=DatahubRepoClient.serviceId, fallbackFactory=DatahubRepoFallbackFactory.class)
public interface DatahubRepoClient {
	
	String serviceId = "datahub-repository";
	
	/**资源库--数据库类型列表**/
	@RequestMapping(method = RequestMethod.GET, value = "/repo/dbtype/list")
    @ResponseBody
    Object callListDbtype(@RequestParam("support")Boolean support);
	
}
