package com.hua.springboot.controller;

import com.hua.springboot.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


//  @ExceptionHandler(UserNotFoundException.class)
//  @ResponseBody
//    public Map handleExcption(Exception e){
//      Map<String, Object> map = new HashMap<>();
//      map.put("code", "4003");
//      map.put("message", "user not found");
//      map.put("exception", e);
//      return map;
//
//    }


    @ExceptionHandler(UserNotFoundException.class)
    public String handleExcption(Exception e, HttpServletRequest httpServletRequest){
        //Must pass error code, 4xx, 5xx

//AbstractErrorController.java
//        Integer statusCode = (Integer) request
//                .getAttribute("javax.servlet.error.status_code");

        httpServletRequest.setAttribute("javax.servlet.error.status_code", 408);

        Map<String, Object> map = new HashMap<>();
        map.put("code", "408");
        map.put("message", "user not found");

        httpServletRequest.setAttribute("ext", map);
        return "forward:/error";

    }
}
