package com.sy.mongo.mongoDAO;

import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by Administrator on 2017/9/29.
 */
public interface BaseDAOInterface<T> {

    Update getUpdate(T t);


}
