package com.hua.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    //@PutMapping
    //@GetMapping
    //@DeleteMapping
    @PostMapping(value="/user/login")
    //@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && "1".equals(password)) {
            httpSession.setAttribute("username", username);
            return "redirect:/home.html";
        } else{
            map.put("msg","用户名/密码错误");
            return "login";
        }

    }

}
