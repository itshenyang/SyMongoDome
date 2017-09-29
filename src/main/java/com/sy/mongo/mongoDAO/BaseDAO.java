package com.sy.mongo.mongoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Repository
public abstract class BaseDAO<T> {

    private Class<T> BaseT;



    @Autowired
    public MongoTemplate mongoTemplate;


    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    public void insertAll(List<T> ts) {
        mongoTemplate.insertAll(ts);
    }

    public void deleteById(T t) {
        mongoTemplate.remove(t);
    }

    public void deleteAll() {
        mongoTemplate.dropCollection(BaseT.getClass());
    }

    public void deletByQuery(T t, Query query) {
        mongoTemplate.remove(query, t.getClass());
    }

    public void updateById(Long id, Update update) {
        Criteria criteria_id = Criteria.where("id").is(id);
        Query query = new Query();
        query.addCriteria(criteria_id);
        mongoTemplate.updateFirst(query, update, BaseT.getClass());
    }

    public void updateByQuery(Query query, Update update) {
        mongoTemplate.upsert(query, update, BaseT.getClass());
    }

    public List<T> findAll() {
        return (List<T>) mongoTemplate.findAll(BaseT.getClass());
    }

    public T findById(Long id) {
        return (T) mongoTemplate.findById(id, BaseT.getClass());
    }

    public List<T> findQuery(Query query) {
        return (List<T>) mongoTemplate.find(query, BaseT.getClass());
    }

    public Query getQuery(Criteria... criterias) {
        Query query = new Query();
        for (int i = 0; i < criterias.length; i++) {
            query.addCriteria(criterias[i]);
        }
        return query;
    }


}
