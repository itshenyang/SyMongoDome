package com.sy.mongo.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/29.
 */
@Service
public class AbstractBaseMongoTemplete {

    protected MongoTemplate mongoTemplate;

    /**
     * 设置mongoTemplate
     * @param mongoTemplate the mongoTemplate to set
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        // TODO Auto-generated method stub
        MongoTemplate mongoTemplate = applicationContext.getBean("mongoTemplate", MongoTemplate.class);
        setMongoTemplate(mongoTemplate);
    }
}
