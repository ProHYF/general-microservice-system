package com.ytraveler.config;

import com.ytraveler.config.exception.AppResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置全局的exception处理
 *
 * @author xss
 * @version 1.0
 * @date 2019-03-13 13:42
 */
@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionConfig {


    /**
     * 作用范围
     */
    @ExceptionHandler(Throwable.class)
    public AppResponse handlerException(Throwable throwable, HttpServletResponse response, HttpServletRequest request){
        return null;
    }

    /**
     * 之后再readme文件中总结异常处理的几种方式。
     *   1.
     *   2.
     *   3.
     */

}
