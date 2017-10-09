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
public class BaseMongoDAO<T> {


    public Class<T> BaseT;

    public BaseMongoDAO() {
        try {
            if (BaseT == null) {
                //获取泛型的Class对象
                BaseT = (Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
            }
        } catch (Exception e) {
        }

    }

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
        mongoTemplate.dropCollection(BaseT);
    }

    public void deletByQuery(Query query) {
        mongoTemplate.remove(query, BaseT);
    }

    public void updateById(String id, Update update) {
        Criteria criteria_id = Criteria.where("_id").is(id);
        Query query = new Query();
        query.addCriteria(criteria_id);
        mongoTemplate.upsert(query, update, BaseT);
    }

    public void updateByQuery(Query query, Update update) {
        mongoTemplate.upsert(query, update, BaseT);
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(BaseT);
    }

    public T findById(String id) {
        return (T) mongoTemplate.findById(id, BaseT);
    }

    public List<T> findQuery(Query query) {
        return (List<T>) mongoTemplate.find(query, BaseT);
    }

    public Query getQuery(Criteria... criterias) {
        Query query = new Query();
        for (int i = 0; i < criterias.length; i++) {
            query.addCriteria(criterias[i]);
        }
        return query;
    }


}
