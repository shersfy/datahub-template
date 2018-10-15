package com.datahub.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.datahub.template.feign")
@ComponentScan(basePackages="com.datahub.template", 
excludeFilters= @Filter(type=FilterType.ANNOTATION, value=FeignClient.class))
@MapperScan("com.datahub.template.mapper")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
