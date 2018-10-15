package com.datahub.template.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.datahub.commons.beans.BaseEntity;

public interface BaseMapper<T extends BaseEntity, Id extends Serializable> {
	
	int deleteById(Id id);

	int insert(T entity);

	T findById(Id id);

	int updateById(T entity);

	long findListCount(Map<String, Object> map);
	
	List<T> findList(Map<String, Object> map);
}
