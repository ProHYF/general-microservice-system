package com.execel.parsedemo.comm.response;


import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class BaseResponse {
    private int code;
    private String msg;
    private Object data;

    /**
     * 抛出异常
     */
    public static BaseResponse exception(int code,String msg){
        return new BaseResponse(code,msg,null);
    }

    public BaseResponse(){}
    public BaseResponse(int code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

}
