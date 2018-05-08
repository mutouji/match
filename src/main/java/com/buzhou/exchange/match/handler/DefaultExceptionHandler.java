package com.buzhou.exchange.match.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
    }
}
