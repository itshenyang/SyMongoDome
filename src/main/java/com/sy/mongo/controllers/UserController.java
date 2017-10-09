package com.sy.mongo.controllers;

import com.sy.mongo.mongoDAO.pojos.User;
import com.sy.mongo.mongoService.UserMongoMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserMongoMongoService userMongoService;

    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    @ResponseBody
    public Object findAll() {
        return userMongoService.findAll();
    }


    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Object insert(@RequestBody User user) {
        return userMongoService.insert(user);
    }


    @RequestMapping(value = "insertAll", method = RequestMethod.POST)
    @ResponseBody
    public Object insertAll(@RequestBody List<User> users) {
        return userMongoService.insertAll(users);
    }

    @RequestMapping(value = "findById", method = RequestMethod.POST)
    @ResponseBody
    public Object findById(@RequestBody User user) {
        return userMongoService.findById(user);
    }


    @RequestMapping(value = "findQueryScore", method = RequestMethod.POST)
    @ResponseBody
    public Object findQueryScore(@RequestBody User user) {
        return userMongoService.findQueryScore(user);
    }

    @RequestMapping(value = "updateById", method = RequestMethod.POST)
    @ResponseBody
    public Object updateById(@RequestBody User user) {
        return userMongoService.updateById(user);
    }

    @RequestMapping(value = "updateByQueryAgeToScore", method = RequestMethod.POST)
    @ResponseBody
    public Object updateByQueryAgeToScore(@RequestBody User user) {
        return userMongoService.updateByQueryAgeToScore(user);
    }


    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteById(@RequestBody User user) {
        return userMongoService.deleteById(user);
    }

    @RequestMapping(value = "deletByQueryScoreAndAge", method = RequestMethod.POST)
    @ResponseBody
    public Object deletByQueryScoreAndAge(@RequestBody User user) {
        return userMongoService.deletByQueryScoreAndAge(user);
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteAll() {
        return userMongoService.deleteAll();
    }


}
