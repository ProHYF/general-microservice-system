package com.ytravler.demo.execle;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHanlderResult;
import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.ytravler.demo.execle.bean.User;
import com.ytravler.demo.user.bean.TUser;
import com.ytravler.demo.user.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExcelHandler extends ExcelDataHandlerDefaultImpl<User> implements IExcelVerifyHandler {

    private IUserService service;

    @Override
    public Object importHandler(User obj, String name, Object value) {
        Map<String,Object> mapResult=new HashMap<>();
        List<TUser> userList = service.getTuserList(value + "");
        if(userList.size()>0){
             verifyHandler("错误");
        }
        return super.importHandler(obj, name, value);
    }

    public IUserService validate(IUserService service) {
        return this.service=service;
    }

    @Override
    public ExcelVerifyHanlderResult verifyHandler(Object o) {
        if("错误".equals(o)){
            return  new ExcelVerifyHanlderResult(false,"错误");
        }
        return new ExcelVerifyHanlderResult(true);
    }
}
