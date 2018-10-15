package com.datahub.template.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    public void set(String key, Object value);  
    
    public void set(String key, Object value, long times, TimeUnit timeUnit);
    
    public void setExpire(String key, long timeout, TimeUnit timeUnit);

    public Object get(String key);  
    
    public boolean delete(String key);

}
