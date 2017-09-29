package com.sy.mongo.services;

import com.sy.mongo.mongoDAO.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class UserMongoService {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> selectAll() {
        return mongoTemplate.findAll(User.class);
    }

}
