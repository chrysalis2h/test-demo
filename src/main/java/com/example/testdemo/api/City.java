package com.example.testdemo.api;

import lombok.Data;

@Data
public class City {

    private Integer id;
    private String name;
    private String countrycode;
    private String district;
    private Integer population;

}
