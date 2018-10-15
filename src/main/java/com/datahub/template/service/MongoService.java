package com.datahub.template.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

/**
 * MonogoDB操作
 * @author pengy
 *
 */
public interface MongoService {

	/**
	 * 保存记录
	 * @param obj
	 * @return
	 */
	int save(Object obj);
	
	/**
	 * 保存集合
	 * @param objs
	 * @return 已保存记录数
	 */
	int saveAll(Collection<? extends Object> objs);

	/**
	 * 通过ID查询记录
	 * @param id
	 * @param entityClass
	 * @return
	 */
	<T> T findById(String id, Class<T> entityClass);
	
	/**
	 * 通过查询条件查询记录列表
	 * @param query 查询条件
	 * @param entityClass
	 * @return
	 */
	<T> List<T> find(Query query, Class<T> entityClass);

	/**
	 * 通过查询条件统计满足统计记录数
	 * @param query 查询条件
	 * @param entityClass
	 * @return
	 */
	<T> long count(Query query, Class<T> entityClass);

	/**
	 * 删除满足统计的记录
	 * @param query
	 * @param entityClass
	 * @return 已删除记录数
	 */
	<T> long remove(Query query, Class<T> entityClass);
	
	/**
	 * 通过ID删除记录
	 * @param id
	 * @param entityClass
	 * @return
	 */
	<T> long removeById(String id, Class<T> entityClass);

}
