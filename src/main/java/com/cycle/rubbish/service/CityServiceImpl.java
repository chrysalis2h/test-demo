package com.cycle.rubbish.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cycle.rubbish.api.City;
import com.cycle.rubbish.api.CityService;
import com.cycle.rubbish.dao.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public IPage<City> selectPage(Page<City> page, String countryCode) {
        QueryWrapper<City> qw = new QueryWrapper<>();
        qw.eq("countrycode", countryCode);
        return this.page(page, qw);
    }

    @Override
    public List<City> getCityOverPopulation(Integer population, String id) {
        return cityMapper.getCityOverPopulation(population, id);
    }
}
