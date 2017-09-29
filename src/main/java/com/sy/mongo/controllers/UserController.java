package com.sy.mongo.controllers;

import com.sy.mongo.services.UserMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/29.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserMongoService userMongoService;

    @RequestMapping(value = "allUser", method = RequestMethod.POST)
    @ResponseBody
    public Object allUser(){
        return userMongoService.selectAll();
    }
}
