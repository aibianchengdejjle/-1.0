package com.jjle.sport.Controller;

import com.alibaba.fastjson.JSON;
import com.jjle.sport.mapper.UserMapper;
import com.jjle.sport.pojo.QueryInfo;
import com.jjle.sport.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/allUser")
    @CrossOrigin //跨域请求
    public  String getAllUser(QueryInfo queryInfo){
        //用作模糊查询
        int numbers = userMapper.getUserCounts("%" + queryInfo.getQuery() + "%");
        //
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        //获取了所有的列表  这个也可以用来用作查询用户的功能
        List<User> users = userMapper.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("unmbers",numbers);
        res.put("data",users);
        String s = JSON.toJSONString(res);
        return s;
    }
    //修改用户权限
    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer id,
                                  @RequestParam("state") Boolean state){
        int i = userMapper.updateState(id,state);
//        System.out.println("用户编号:"+id);
//        System.out.println("用户状态:"+state);
        String str = i >0?"success":"error";
        return str;
    }
    //增加一名用户
    @RequestMapping("/addUser")
    @CrossOrigin
    public String addUser(@RequestBody User user){
        //System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userMapper.addUser(user);
        String str = i >0?"success":"error";
        return str;
    }
    //删除一名用户
    @RequestMapping("/deleteUser")
    @CrossOrigin
    public  String deleteUser(int id){
        System.out.println(id);
        int i = userMapper.deleteUser(id);
        String str=i>0?"success":"error";
        return  str;
    }
    //修改一名用户
    @RequestMapping("/editUser")
    @CrossOrigin
    public  String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userMapper.editUser(user);
        String str=i>0?"success":"error";
        return  str;
    }
    //获取修改人员的相关信息
    @RequestMapping("/getUpdate")
    @CrossOrigin
    public String getUpdateUser(int id){
        System.out.println("编号:"+id);
        User updateUser = userMapper.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }
}
