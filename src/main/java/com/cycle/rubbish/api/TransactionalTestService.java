package com.cycle.rubbish.api;

import com.baomidou.mybatisplus.extension.service.IService;

public interface TransactionalTestService extends IService<City> {

    void testResult();

    void insert1();

    void insert2();
}
