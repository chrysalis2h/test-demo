package com.example.testdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testdemo.api.City;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {

    List<City> getCityOverPopulation(Integer population);
}
