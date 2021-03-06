package com.jjle.sport.mapper;


import com.jjle.sport.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User getUserByMassage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(@Param("id") Integer id,@Param("state") Boolean state);  //修改用户权限
    public int addUser(User user);
    public User getUpdateUser(int id);
    public int editUser(User user);
    public int deleteUser(int id);
}
