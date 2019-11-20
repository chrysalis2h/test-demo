package com.example.testdemo.demo.fragments;

import com.example.testdemo.api.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.Optional;

/**
 *  * @ClassName: OptionalDemo
 *  * @Description: Optional测试类
 *  * @Author: HJ
 *  * @Date: 2019\11\20 0020 9:24
 *  * @Version: v1.0 文件初始创建
 */
@Slf4j
public class OptionalDemo {

    public Optional<User> getUser(String id) {
        if (StringUtils.isEmpty(id)) {
            return Optional.of(new User(String.valueOf(Math.random())));
        }
        return Optional.empty();
    }

    public void testGetUser() {
        Optional<User> userOp = this.getUser(null);
        if (userOp.isPresent()) {
            User user = userOp.get();
        } else {

        }

        userOp.map(User::getPhone);
        userOp.map(User::getPhone).orElseThrow(OBJECT_NOT_EXIST::new);
        userOp.map(User::getPhone).orElse("默认值");

    }

}
