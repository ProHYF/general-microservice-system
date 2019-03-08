package com.ytravler.demo.execle.bean;


import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.Pattern;

public class User {

    @Excel(name = "姓名")
    @Pattern(regexp = "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
    private String userName;

    @Excel(name = "邮箱")
    private String email;

    @Excel(name = "手机号")
    private String tel;
    @Excel(name = "性别")
    private String sex;

    @Excel(name = "验证")
    private String ccid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }
}
