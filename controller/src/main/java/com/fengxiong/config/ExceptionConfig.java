package com.fengxiong.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describle: 全局异常处理
 * @author: pangxiaofeng
 * @create: 2020/12/18
 **/
@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        return "We正在努力成长中";
    }


}
