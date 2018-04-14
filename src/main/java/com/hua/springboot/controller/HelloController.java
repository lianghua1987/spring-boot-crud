package com.hua.springboot.controller;


import com.hua.springboot.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if("aaa".equals(user)){
            throw new UserNotFoundException("User not found");
        }
        return "Hello";
    }

//    @RequestMapping({"/", "index.html"})
//    public String index() {
//        return "login";
//    }


    @RequestMapping("/success")
    //classpath: /templates/success.html
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("hello1", "<h1>你好</h1>");
        map.put("id", "主键");
        map.put("name", "名字");
        map.put("paragraph", "this is a paragraph");
        map.put("url", "http://www.google.com");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "/success";
    }
}
