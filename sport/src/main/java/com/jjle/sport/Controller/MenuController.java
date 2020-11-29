package com.jjle.sport.Controller;

import com.alibaba.fastjson.JSON;
import com.jjle.sport.mapper.MenuMapper;
import com.jjle.sport.pojo.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuMapper menuMapper;
    @RequestMapping("/menus")
    //跨域请求
    @CrossOrigin
    public  String getAllMenus(){
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> mainMenus = menuMapper.getMainMenus();
       if(mainMenus!=null){
           data.put("data",mainMenus);
           data.put("flag",200);
       }else {
           data.put("flag",404);
       }
        String s = JSON.toJSONString(data);
        System.out.println("成功访问");
        return s;
    }
}
