package com.sy.mongo.services;

import com.sy.mongo.mongoDAO.UserDAO;
import com.sy.mongo.mongoDAO.pojos.User;
import com.sy.mongo.utils.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class UserMongoService {
    @Autowired
    UserDAO userDAO;


    public List<User> selectAll() {
        List<User> list = userDAO.mongoTemplate.findAll(User.class);
        L.w(list.toString());
        userDAO.findAll();
        return list;
    }

}
