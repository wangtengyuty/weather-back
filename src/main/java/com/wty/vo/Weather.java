package com.wty.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author wangtengyu
 * @Create 2018-04-23-9:15
 */
@Getter
@Setter
public class Weather implements Serializable {

    private Yesterday yesterday;

    private String city;
    //空气质量指数
    private Integer aqi;

    private List<ForeCast> forecast;

    private String ganmao;

    private String wendu;
}
