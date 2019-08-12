package com.example.testdemo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.testdemo.api.City;
import com.example.testdemo.api.CityService;
import com.example.testdemo.dao.CityMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {


    @Override
    public IPage<City> selectPage(Page<City> page, String countryCode) {
        QueryWrapper<City> qw = new QueryWrapper<>();
        qw.eq("countrycode", countryCode);
        return this.page(page, qw);
    }
}
