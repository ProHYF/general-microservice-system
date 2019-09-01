package com.execel.parsedemo.comm.response;

import lombok.Getter;

/**
 * @author Administrator
 */
@Getter
public enum BaseResponseEnum {
    SUCESS("Success",200),
    SERVER_ERROR("Internal Server Error",500),
    CHECK_PARAM_ERROR("ERROR Param",400);
    private String msg;
    private int code;

    BaseResponseEnum(String msg,int code){
        this.msg=msg;
        this.code=code;
    }
}
