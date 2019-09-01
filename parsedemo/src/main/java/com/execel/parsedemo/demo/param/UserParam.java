package com.execel.parsedemo.demo.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 */
@Data
public class UserParam {

    @NotNull(message = "用户名不能为空")
    private String userName;

    @Max(value = 10)
    @Min(value = 0)
    private Integer age;




}
