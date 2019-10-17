package com.example.testdemo.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.testdemo.api.City;
import com.example.testdemo.api.TransactionalTestService;
import com.example.testdemo.api.User;
import com.example.testdemo.api.UserService;
import com.example.testdemo.dao.CityMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionalTestServiceImpl extends ServiceImpl<CityMapper, City> implements TransactionalTestService {

    Logger logger = LogManager.getLogger(TransactionalTestServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private UserService userService;

    @Override
    public void testResult() {
        logger.error("同一类中，非事务方法A调用事务方法B, A RuntimeException，事务 失效");
        logger.error("同一类中，非事务方法A调用事务方法B, B RuntimeException，事务 失效");

        logger.error("同一类中，事务方法A调用非事务方法B, A RuntimeException，事务 有效");
        logger.error("同一类中，事务方法A调用非事务方法B, B RuntimeException，事务 有效");

        logger.error("不同类中，非事务方法A调用事务方法B, A RuntimeException，事务 失效");
        logger.error("不同类中，非事务方法A调用事务方法B, B RuntimeException，事务 有效");

        logger.error("同一类中，非事务方法A调用事务方法B, B RuntimeException，事务 XX");
        logger.error("同一类中，非事务方法A调用事务方法B, B RuntimeException，事务 XX");
        logger.error("同一类中，非事务方法A调用事务方法B, B RuntimeException，事务 XX");
        logger.error("同一类中，非事务方法A调用事务方法B, B RuntimeException，事务 XX");
    }

    @Override
    public void insert1() {
        User user = new User("insert1", "0", "insert1", "insert1", "0", new Date());
        boolean insertResult = userService.save(user);
        logger.info("insert1 result = {}", insertResult);
        userService.insertUser();
//        insert2();
        throw new RuntimeException();
    }

    @Override
    public void insert2() {
        User user = new User("insert2", "0", "insert2", "insert2", "0", new Date());
        boolean insertResult = userService.save(user);
        logger.info("insert2 result = {}", insertResult);
        throw new RuntimeException();
    }
}
