package com.sy.mongo.mongoService;

import com.sy.mongo.mongoDAO.UserMongoMongoDAO;
import com.sy.mongo.mongoDAO.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class UserMongoMongoService extends BaseMongoService {
    @Autowired
    UserMongoMongoDAO userDAO;

    public Boolean insert(User user) {
        try {
            userDAO.insert(user);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public Boolean insertAll(List<User> list) {
        try {
            userDAO.insertAll(list);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean deleteById(User user) {
        try {
            userDAO.deleteById(user);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public Boolean deleteAll() {
        try {
            userDAO.deleteAll();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean deletByQueryScoreAndAge(User user) {  //年龄小于的 和 成绩大于的
        try {
            Criteria criteria = Criteria.where("age").gt(user.getAge()).and("score").lt(user.getScore());
            Query query = userDAO.getQuery(criteria);
            userDAO.deletByQuery(query);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public Boolean updateById(User user) {
        try {
            //Update update = userDAO.getUpdate(user);
            Update update = Update.update("id", user.get_id()).set("name", user.getName());
            userDAO.updateById(user.get_id(), update);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public Boolean updateByQueryAgeToScore(User user) { //年龄等于多少  的修改分数
        try {
            Criteria criteria = Criteria.where("age").is(user.getAge());
            Query query = userDAO.getQuery(criteria);
            User updateUser = new User();
            updateUser.setScore(user.getScore());
            Update update = userDAO.getUpdate(updateUser);
            userDAO.updateByQuery(query, update);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public List<User> findAll() {
        try {
            List<User> list2 = userDAO.findAll();
            return list2;
        } catch (Exception e) {

        }
        return null;

    }

    public User findById(User user) {
        try {
            User user1 = userDAO.findById(user.get_id());
            return user1;
        } catch (Exception e) {

        }
        return null;
    }

    public List<User> findQueryScore(User user) { //查询分数是
        try {
            Criteria criteria = Criteria.where("score").is(user.getScore());
            List<User> list = userDAO.findQuery(userDAO.getQuery(criteria));
            return list;
        } catch (Exception e) {

        }
        return null;
    }

}
