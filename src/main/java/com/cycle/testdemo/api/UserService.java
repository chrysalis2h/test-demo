package com.cycle.testdemo.api;

import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    boolean insertUser();
}