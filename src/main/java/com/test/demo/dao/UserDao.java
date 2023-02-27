package com.test.demo.dao;

import com.test.demo.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    public List<User> getUserList();
    public User findUser(String id);
    public void signUp(@Param("user") User user);
    public void updateUser(@Param("user") User user);
    public void deleteUser(String id);
    public int findAge(String id);
    public String findID(String name, String email, String phone);
    public String findPW(String id, String name, String email, String phone);
}
