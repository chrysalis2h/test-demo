package com.cycle.rubbish.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cycle.rubbish.api.City;
import com.cycle.rubbish.api.CityService;
import com.cycle.rubbish.config.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @GetMapping("/pop")
    public List<City> getCityOverPopulation(@RequestParam(required = false) Integer pop,
                                            @RequestParam(required = false) String id) throws SQLException {
        List<City> city = cityService.getCityOverPopulation(pop, id);
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> sss = inputStream.
                flatMap((childList) -> childList.stream()).collect(Collectors.toList());
        System.out.println(sss);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        integers.stream().reduce(0, Integer::sum);

        Integer result = city.stream().reduce(0, (a, b) -> {
            return a + b.getPopulation();
        }, (a, b) -> 0);
        System.out.println(result);

        Map<String, Integer> contrycodeAndPopulationMap = city.stream().reduce(new HashMap<String, Integer>(), (a, b) -> {
            Integer bPop = a.get(b.getCountrycode());
            if (bPop == null) {
                bPop = b.getPopulation();
            } else {
                bPop = bPop + b.getPopulation();
            }
            a.put(b.getCountrycode(), bPop);
            return a;
        }, (a, b) -> null);
        System.out.println(contrycodeAndPopulationMap);
        return city;
    }

    @GetMapping("/exception")
    public String testException(@RequestParam(required = false) String test) throws BusinessException {
        if (StringUtils.isEmpty(test)) {
            throw BusinessException.getException("测试异常");
        }
        return test;
    }
}
