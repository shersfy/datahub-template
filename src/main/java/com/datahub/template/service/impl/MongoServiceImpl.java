package com.datahub.template.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.datahub.template.service.MongoService;
import com.mongodb.client.result.DeleteResult;

@Service
public class MongoServiceImpl implements MongoService{

	@Autowired
	private MongoTemplate mongoTemplate;


	@Override
	public int save(Object obj) {
		if(obj==null) {
			return 0;
		}
		mongoTemplate.save(obj);
		return 1;
	}

	@Override
	public int saveAll(Collection<? extends Object> objs) {
		if(objs==null || objs.isEmpty()) {
			return 0;
		}
		mongoTemplate.insertAll(objs);
		return objs.size();
	}


	@Override
	public <T> T findById(String id, Class<T> entityClass) {
		return mongoTemplate.findById(id, entityClass);
	}

	@Override
	public <T> List<T> find(Query query, Class<T> entityClass) {
		return mongoTemplate.find(query, entityClass);
	}

	@Override
	public <T> long count(Query query, Class<T> entityClass) {
		return mongoTemplate.count(query, entityClass);
	}

	@Override
	public <T> long remove(Query query, Class<T> entityClass) {
		DeleteResult res = mongoTemplate.remove(query, entityClass);
		return res.getDeletedCount();
	}

	@Override
	public <T> long removeById(String id, Class<T> entityClass) {

		if(StringUtils.isBlank(id)) {
			return 0;
		}

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));

		return this.remove(query, entityClass);
	}

}
