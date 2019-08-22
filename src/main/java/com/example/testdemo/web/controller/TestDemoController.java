package com.example.testdemo.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testdemo.api.City;
import com.example.testdemo.api.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/test-demo")
public class TestDemoController {

    private Logger logger = LogManager.getLogger(TestDemoController.class);
    @Autowired
    private CityService cityService;

    @Autowired
    private DataSource dataSource;

    @GetMapping()
    public JSONObject testDemo() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `city` where Name = 'Qingdao';");
        ResultSet resultSet = preparedStatement.executeQuery();
        JSONObject result = new JSONObject();
        while (resultSet.next()) {
            result.put("ID", resultSet.getInt("ID"));
            result.put("Name", resultSet.getString("Name"));
            result.put("CountryCode", resultSet.getString("CountryCode"));
            result.put("District", resultSet.getString("District"));
            result.put("Population", resultSet.getInt("Population"));
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return result;
    }

    @GetMapping("/{id}")
    public City testDemo(@PathVariable Integer id) throws SQLException {
        logger.info("logger.info");
        logger.error("logger.error");
        logger.debug("logger.debug");
        City city = cityService.getById(id);
        return city;
    }

    @GetMapping("/page/{countryCode}")
    public Page<City> selectPage(@PathVariable String countryCode) throws SQLException {
        Page<City> cityPage = new Page<>();
        cityService.selectPage(cityPage, countryCode);
        return cityPage;
    }

    @GetMapping("/pop/{pop}")
    public List<City> getCityOverPopulation(@PathVariable Integer pop) throws SQLException {
        List<City> city = cityService.getCityOverPopulation(pop);
        return city;
    }
}
