package com.project.springboot001.exception;


import com.project.springboot001.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException se) {
        return Result.error(se.getCode(),se.getMessage());
    }
}
