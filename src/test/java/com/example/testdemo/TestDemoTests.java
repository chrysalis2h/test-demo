package com.example.testdemo;

import com.example.testdemo.dao.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemoTests {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void contextLoads() {
        System.out.println(cityMapper.selectById("1903"));
    }

}
