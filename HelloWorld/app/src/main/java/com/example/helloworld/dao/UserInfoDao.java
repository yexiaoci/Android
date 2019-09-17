package com.example.helloworld.dao;

import com.example.helloworld.entity.UserInfo;

import java.util.List;



public interface UserInfoDao {
    List<UserInfo> select();
    UserInfo select(String username);
    void insert(UserInfo userInfo);
    void update(UserInfo userInfo);
    void delete(UserInfo userInfo);

}
