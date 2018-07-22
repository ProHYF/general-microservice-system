package com.execel.parsedemo.user.controller;

import com.execel.parsedemo.user.bean.TUser;
import com.execel.parsedemo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;
    @GetMapping("getUser")
    public TUser getUser(Integer ccid){
        return  service.getUser(ccid);
    }
}
