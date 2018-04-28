package com.wty.controller;

import com.wty.Service.ICountryDataService;
import com.wty.Service.IWeatherService;
import com.wty.pojo.Country;
import com.wty.util.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wangtengyu
 * @Create 2018-04-23-9:54
 */
@RestController
@RequestMapping("/weather")
@CrossOrigin
@Slf4j
public class WeatherController {

    @Autowired
    private IWeatherService IWeatherService;

    @Autowired
    private ICountryDataService iCountryDataService;

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName){
        return IWeatherService.getDataByCityName(cityName);
    }

    @GetMapping("/cityKey/{cityKey}")
    public WeatherResponse getDataByCityId(@PathVariable("cityKey") String cityKey){
        return IWeatherService.getDataByCityKey(cityKey);
    }

    @GetMapping("/getAllCountry")
    public List<Country> getAllCountry(){
        log.info("request here");
        try {
            return iCountryDataService.getCountryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
