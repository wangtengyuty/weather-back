package com.wty.util;

import com.wty.vo.Weather;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author wangtengyu
 * @Create 2018-04-23-9:12
 */

@Getter
@Setter
public class WeatherResponse implements Serializable {

    private Weather data;

    private String desc;

    private Integer status;

}
