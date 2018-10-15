package com.datahub.template.service;

import java.io.Serializable;
import java.util.List;

import com.datahub.commons.beans.BaseEntity;
import com.datahub.commons.beans.Page;
import com.datahub.commons.beans.Result.ResultCode;

public interface BaseService<T extends BaseEntity, Id extends Serializable> {
	
	int SUCESS = ResultCode.SUCESS;
	int FAIL   = ResultCode.FAIL;
	int NOR    = 0;
	int DEL    = 1;
	int TMP    = -1;
	
	int deleteById(Id id);

	int insert(T entity);

	T findById(Id id);

	int updateById(T entity);
	
	long findListCount(T where);
	
	List<T> findList(T where);

	Page<T> findPage(T where, int pageNo, int pageSize);
}
