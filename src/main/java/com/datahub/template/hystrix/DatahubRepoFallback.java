package com.datahub.template.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.datahub.commons.beans.Result;
import com.datahub.commons.beans.Result.ResultCode;
import com.datahub.template.feign.DatahubRepoClient;

/**
 * 服务调用容错回调
 * @author pengy
 *
 */
@Component
public class DatahubRepoFallback implements DatahubRepoClient {
	
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Override
	public Object callListDbtype(Boolean support) {
		LOGGER.error("support={}", support);
		return new Result(ResultCode.FAIL, "server error: "+serviceId).toString();
	}

}
