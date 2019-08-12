package com.example.testdemo.api;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class City {

    private Integer id;
    private String name;
    private String countrycode;
    private String district;
    private Integer population;
    @TableLogic
    private Integer deleted;

}
