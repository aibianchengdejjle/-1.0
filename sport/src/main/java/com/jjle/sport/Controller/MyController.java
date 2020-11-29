package com.jjle.sport.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/test")
    //这是处理跨域请求的
    @CrossOrigin
    @ResponseBody
    public  String test(){
        return "ok";
    }
}
