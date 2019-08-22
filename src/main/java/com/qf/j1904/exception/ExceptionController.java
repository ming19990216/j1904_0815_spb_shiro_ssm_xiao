package com.qf.j1904.exception;


import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = UnauthorizedException.class)
    public String handlerException(HttpServletRequest request,Exception ex){
        return "unAuth";
    }
}
