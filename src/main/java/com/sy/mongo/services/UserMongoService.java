package com.sy.mongo.services;

import com.sy.mongo.mongoDAO.pojos.col;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class UserMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<col> selectAll(){
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is("599e759c41655b4169caea0e"));
    }

}
