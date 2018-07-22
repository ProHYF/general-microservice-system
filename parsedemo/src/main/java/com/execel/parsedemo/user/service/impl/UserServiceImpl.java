package com.execel.parsedemo.user.service.impl;

import com.execel.parsedemo.user.bean.TUser;
import com.execel.parsedemo.user.service.IUserService;
import org.apache.catalina.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<User> getUserList(String ccid) {
        Map<String,Object> params=new HashMap<>();
        params.put("","");
        return null;
    }

    @Override
    public TUser getUser(Integer tid) {
        return sqlSessionTemplate.selectOne("mapper.TUserMapper.selectByPrimaryKey",tid);
    }

    @Override
    public List<TUser> getTuserList(String ccid) {
        return sqlSessionTemplate.selectList("mapper.TUserMapper.selectTuserListByccid",ccid);
    }
}
