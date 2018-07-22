package com.execel.parsedemo.user.service;

import com.execel.parsedemo.user.bean.TUser;
import org.apache.catalina.User;

import java.util.List;

public interface IUserService {
    List<User> getUserList(String ccid);

    TUser getUser(Integer tid);

    List<TUser> getTuserList(String ccid);
}
