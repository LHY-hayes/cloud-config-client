package com.hayes.code.cloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RefreshScope
public class TestController {

    @Value("${from}")
    private String from1 ;

    @RequestMapping("/from1")
    public String getFrom() throws InterruptedException {

        int i = new Random().nextInt(3000);
        System.out.println("本次睡眠时间💤 ： " +i);
        Thread.sleep(i);
        return from1 +" .. 本次睡眠时间💤 ： " +i ;

    }

    @Autowired
    private Environment env ;

    @RequestMapping("/from2")
    public String getFrom2(){

        return env.getProperty("from","undefined") ;

    }




}
