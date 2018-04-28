package com.wty.schedule;

import com.wty.Service.IWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-14:15
 */

@Slf4j
public class WeatherSyncJob extends QuartzJobBean {

    @Autowired
    private IWeatherService IWeatherService;

    /**
     * 定时任务 根据时间取获取一遍所有城市的数据放进缓存
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            IWeatherService.syncDataByCityKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
