package com.datahub.template.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.datahub.template.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	
    private RedisTemplate<String, Object> redisTemplate;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object value) {
    	setRedisTemplate(redisTemplate);
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
         vo.set(key, value);
    }
    
    public Object get(String key) {
    	setRedisTemplate(redisTemplate);
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
    
    public boolean delete(String key) {
    	setRedisTemplate(redisTemplate);
        return redisTemplate.delete(key);
    }
    
    public void set(String key, Object value,long times,TimeUnit timeUnit) {
    	setRedisTemplate(redisTemplate);
    	ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value,times,timeUnit);
    }
    
    public void setExpire(String key,long timeout,TimeUnit timeUnit) {
    	setRedisTemplate(redisTemplate);
    	redisTemplate.expire(key, timeout, timeUnit);
    }
}
