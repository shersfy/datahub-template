package com.datahub.template.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datahub.template.feign.DatahubRepoClient;

import feign.hystrix.FallbackFactory;

/**
 * 服务调用容错回调
 * @author pengy
 *
 */
@Component
public class DatahubRepoFallbackFactory implements FallbackFactory<DatahubRepoClient> {

	protected Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private DatahubRepoFallback datahubRepoFallback;


	@Override
	public DatahubRepoClient create(Throwable cause) {
		// 屏蔽服务启动报 java.lang.RuntimeException: null
		if(!(cause instanceof RuntimeException)) {
			String err = String.format("call service '%s' error: ", DatahubRepoClient.serviceId);
			LOGGER.error(err, cause);
		}
		return datahubRepoFallback;	
	}

}
