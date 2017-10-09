package com.sy.mongo.mongoDAO;

import com.sy.mongo.mongoDAO.pojos.User;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/9/29.
 */
@Repository
public class UserDAO extends BaseDAO<User> implements BaseDAOInterface<User> {


    @Override
    public Update getUpdate(User user) {
        Update update = new Update();
//        if (!StringUtils.isEmpty(user.get_id())) {
//            update.set("id", user.get_id());
//        }
        if (!StringUtils.isEmpty(user.getName())) {
            update.set("name", user.getName());
        }
        if (!StringUtils.isEmpty(user.getAge())) {
            update.set("age", user.getAge());
        }
        if (!StringUtils.isEmpty(user.getLikes())) {
            update.set("likes", user.getLikes());
        }
        if (!StringUtils.isEmpty(user.getScore())) {
            update.set("score", user.getScore());
        }
        if (!StringUtils.isEmpty(user.getTime())) {
            update.set("time", user.getTime());
        }
        return update;
    }




}
