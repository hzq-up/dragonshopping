package com.hzq.dragonshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
    //登录
    @RequestMapping("login")
    public Object login() {
        return "login";
    }

    //首页
    @RequestMapping("")
    public Object index() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("");
        return "forward:index.do";
    }
    @RequestMapping("index")
    public Object indext() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("");
        return "forward:index.do";
    }
    //注册
    @RequestMapping("regist")
    public Object regist() {
        return "regist";
    }

}
