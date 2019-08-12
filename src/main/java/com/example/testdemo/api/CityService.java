package com.example.testdemo.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CityService extends IService<City>{

    IPage<City> selectPage(Page<City> page, String countryCode);
}
