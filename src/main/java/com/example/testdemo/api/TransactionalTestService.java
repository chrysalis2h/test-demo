package com.example.testdemo.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TransactionalTestService extends IService<City> {

    void testResult();

    void insert1();

    void insert2();
}
