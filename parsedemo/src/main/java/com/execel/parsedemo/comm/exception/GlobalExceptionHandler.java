package com.execel.parsedemo.comm.exception;

import com.execel.parsedemo.comm.response.BaseResponse;
import com.execel.parsedemo.comm.response.BaseResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public BaseResponse processDefaultException(HttpServletResponse response, Exception exception){
        exception.printStackTrace();
        log.info("调用外部异常:[{}]",exception.getMessage());
        return BaseResponse.exception(BaseResponseEnum.SERVER_ERROR.getCode(),"系统异常,请联系管理员");
    }

    /**
     * 内部调用
     */
    @ExceptionHandler(InternalApiException.class)
    public BaseResponse processMicroServiceException(InternalApiException  exception){
        exception.printStackTrace();
        log.info("调用外部异常:[{}]",exception.getMessage());
        return BaseResponse.exception(BaseResponseEnum.SERVER_ERROR.getCode(),exception.getMessage());
    }

    /**
     *  处理参数校验
     */
    @ExceptionHandler(value={MethodArgumentNotValidException.class, BindException.class})
    public BaseResponse handleIllegalParamException(Exception validException) {
        BaseResponse result=new BaseResponse();
        if (validException instanceof MethodArgumentNotValidException) {
            convertError(((MethodArgumentNotValidException) validException).getBindingResult(), result);
        } else if (validException instanceof BindException) {
            convertError(((BindException) validException).getBindingResult(), result);
        }

        return result;
    }

    public static void convertError(Errors error, BaseResponse result) {
        if (error.hasErrors()) {
            result.setCode(BaseResponseEnum.CHECK_PARAM_ERROR.getCode());
            Map<String, String> errMap = new HashMap<String, String>();
            String errorMsg = "";
            if (error.hasGlobalErrors()) {
                String globalMsg = "";
                for (ObjectError ferr : error.getGlobalErrors()) {
                    globalMsg = globalMsg + ferr.getDefaultMessage() + ";";
                }
                errorMsg += globalMsg;
                errMap.put("_global_msg", globalMsg);
            }
            if (error.hasFieldErrors()) {
                for (FieldError ferr : error.getFieldErrors()) {
                    errMap.put(ferr.getField(), ferr.getDefaultMessage());
                    errorMsg = errorMsg + ferr.getDefaultMessage() + ";";
                }
            }
            result.setMsg(errorMsg);
            result.setData(errMap);
        }
    }
}

