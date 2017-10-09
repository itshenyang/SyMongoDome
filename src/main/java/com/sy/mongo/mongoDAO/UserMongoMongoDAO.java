package com.sy.mongo.mongoDAO;

import com.sy.mongo.mongoDAO.pojos.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/29.
 */
@Repository
public class UserMongoMongoDAO extends BaseMongoDAO<User> implements BaseMongoDAOInterface<User> {



    @Override
    public Update getUpdate(User user) {
        Update update = new Update();
//        if (!StringUtils.isEmpty(user.get_id())) {
//            update.set("id", user.get_id());
//        }
        if (user.getName() != null) {
            update = update.set("name", user.getName());
        }
        if (user.getAge() != null) {
            update = update.set("age", user.getAge());
        }
        if (user.getLikes() != null) {
            update = update.set("likes", user.getLikes());
        }
        if (user.getScore() != null) {
            update = update.set("score", user.getScore());
        }
        if (user.getTime() != null) {
            update = update.set("time", user.getTime());
        }
        return update;
    }


}
