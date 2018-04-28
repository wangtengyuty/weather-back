package com.wty.Service.impl;

import com.wty.Service.ICountryDataService;
import com.wty.Service.IWeatherService;
import com.wty.pojo.Country;
import com.wty.util.JsonUtil;
import com.wty.util.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangtengyu
 * @Create 2018-04-23-9:56
 */
@Service("iWeatherService")
@Slf4j
public class WeatherServiceImpl implements IWeatherService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ICountryDataService iCountryDataService;

    private ResponseEntity<String> responseEntity = null;
    private String bodyString = null;
    private WeatherResponse weatherResponse = null;

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return getByUri(uri);
    }

    @Override
    public WeatherResponse getDataByCityKey(String cityKey) {
        String uri = WEATHER_URI + "citykey=" + cityKey;
        return getByUri(uri);
    }

    private WeatherResponse getByUri(String uri) {
        String key = uri;
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(uri)) {
            bodyString = valueOperations.get(uri);
            log.info("data from redis ");
        } else {
            responseEntity = restTemplate.getForEntity(uri, String.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                bodyString = responseEntity.getBody();
            }
            valueOperations.set(uri, bodyString, 10L, TimeUnit.SECONDS);
            log.info("data from interface");
        }
        try {
            weatherResponse = JsonUtil.string2Obj(bodyString, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }

    @Override
    public void syncDataByCityKey() throws IOException, JAXBException {
        List<Country> countryList=iCountryDataService.getCountryList();
        for(Country country:countryList){
            String uri = WEATHER_URI + "citykey=" + country.getCityKey();
            saveWeatherData(uri);
        }
    }

    private void saveWeatherData(String uri) {
        String key = uri;
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        responseEntity = restTemplate.getForEntity(uri, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            bodyString = responseEntity.getBody();
        }
        valueOperations.set(uri, bodyString, 1800L, TimeUnit.SECONDS);
        log.info("weather sync now");
        try {
            weatherResponse = JsonUtil.string2Obj(bodyString, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
