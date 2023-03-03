package com.example.demo.exception;

import com.example.demo.vo.Result;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 86187
 * @Date: 2023/3/3 09:05
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler  {

    private static final Logger LOGGER= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler (HttpServletRequest request, Exception e){

        LOGGER.error(ExceptionUtils.getStackTrace(e));

        return  Result.fail("服务器错误");
    }


    @ExceptionHandler(value = DemoException.class)
    public Result demoExceptionHandler(HttpServletRequest request , DemoException demoException){
        LOGGER.error(demoException.getMessage());
        return Result.fail(demoException.getCode(),demoException.getMessage());
    }

}
