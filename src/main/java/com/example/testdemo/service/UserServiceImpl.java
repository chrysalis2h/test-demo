package com.example.testdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.testdemo.api.User;
import com.example.testdemo.api.UserService;
import com.example.testdemo.dao.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public boolean insertUser(){
        User user = new User("insertUser", "0", "insertUser", "insertUser", "0", new Date());
        boolean insertResult = this.save(user);
        logger.info("insertUser result = {}", insertResult);
        return insertResult;
//        throw new RuntimeException();
//        return insertResult;
    }
}
