package com.cycle.testdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cycle.testdemo.api.City;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {

    List<City> getCityOverPopulation(Integer population, String id);
}
