package com.bai.alarmapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 23:11
 */
@SpringBootApplication
@ComponentScan(value = {"com.bai.alarmsocket","com.bai.alarmapi"})
public class AlarmApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmApiApplication.class,args);
    }

}
