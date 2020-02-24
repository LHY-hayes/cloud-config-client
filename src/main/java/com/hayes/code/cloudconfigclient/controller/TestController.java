package com.hayes.code.cloudconfigclient.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${from}")
    private String from1 ;

    @RequestMapping("/from1")
    public String getFrom(){

        return from1 ;

    }

    @Autowired
    private Environment env ;

    @RequestMapping("/from2")
    public String getFrom2(){

        return env.getProperty("from","undefined") ;

    }




}
