package com.ytravler.demo.execle.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.ytravler.demo.execle.ExecleUtil;
import com.ytravler.demo.execle.UserExcelHandler;
import com.ytravler.demo.execle.bean.User;
import com.ytravler.demo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("execle")
public class ExecleController {


    @PostMapping("import")
    public void importExecle(MultipartFile file, HttpServletRequest request) {
        List<User> userList = ExecleUtil.importExcel(file, 1, 1, User.class);
        System.out.println(userList);
    }

    @Autowired
    IUserService service;
    @PostMapping("import1")
    public void aaa(MultipartFile file) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        CountDownLatch count=new CountDownLatch(10);

        ImportParams importParams = new ImportParams();
        // 数据处理
        UserExcelHandler handler = new UserExcelHandler();
        handler.setNeedHandlerFields(new String[]{"验证"});// 注意这里对应的是excel的列名。也就是对象上指定的列名。
        importParams.setDataHanlder(handler);
        handler.validate(service);
        // 需要验证
        importParams.setNeedVerfiy(true);
        try {
            ExcelImportResult<User> result = ExcelImportUtil.importExcelMore(file.getInputStream(), User.class, importParams);

            List<User> successList = result.getList();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

