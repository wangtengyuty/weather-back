package com.wty.config;

import com.wty.schedule.WeatherSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangtengyu
 * @Create 2018-04-24-14:52
 */
@Configuration
public class QuartzConfig {

    private static final int Time=1800;

    @Bean
    public JobDetail weatherSyncJobDetail(){
        return JobBuilder.newJob(WeatherSyncJob.class).withIdentity("weatherSyncJob").storeDurably().build();
    }



    @Bean
    public Trigger weatherSyncTrigger(){
        SimpleScheduleBuilder scheduleBuilder= SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(Time).repeatForever();
        Trigger trigger= TriggerBuilder.newTrigger().forJob(weatherSyncJobDetail()).withIdentity("weatherSyncTrigger")
                .withSchedule(scheduleBuilder).build();
        return trigger;
    }




}
