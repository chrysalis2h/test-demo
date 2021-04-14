package com.cycle.rubbish.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cycle.rubbish.api.City;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {

    List<City> getCityOverPopulation(Integer population, String id);
}
