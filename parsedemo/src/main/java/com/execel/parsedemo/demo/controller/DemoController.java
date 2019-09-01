package com.execel.parsedemo.demo.controller;

import com.execel.parsedemo.comm.response.BaseResponse;
import com.execel.parsedemo.demo.param.UserParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {

    @PostMapping("createUser")
    public BaseResponse createUser(@RequestBody UserParam userParam){

        log.info("输入得用户信息是{}",userParam);

        return null;
    }
}
