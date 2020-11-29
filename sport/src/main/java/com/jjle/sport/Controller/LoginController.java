package com.jjle.sport.Controller;

import com.alibaba.fastjson.JSON;
import com.jjle.sport.mapper.UserMapper;
import com.jjle.sport.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserMapper userDao;
    @CrossOrigin   // 处理跨域请求的
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        String flag = "error";
        User us=userDao.getUserByMassage(user.getUsername(),user.getPassword());
        HashMap<String,Object>res=new HashMap<>();
        if(us!=null){
            flag="ok";
        }
        res.put("flag",flag);
        res.put("user",user);
        //变化为json字符串
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
