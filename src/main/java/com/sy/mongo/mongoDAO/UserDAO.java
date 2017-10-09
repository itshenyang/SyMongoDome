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
public class UserDAO extends BaseDAO<User> implements BaseDAOInterface<User> {

    @Override
    public void updateById(String id, Update update) {
        Criteria criteria_id = Criteria.where("id").is(id);
        Query query =  new Query();
        query.addCriteria(criteria_id);
        mongoTemplate.findAndModify(query, update, User.class);
    }

    @Override
    public Update getUpdate(User user) {//Update.update("id",user.get_id()).set("name", user.getName()).set("age", user.getAge()).set("likes", user.getLikes()).set("score", user.getScore()).set("time", user.getTime())
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
