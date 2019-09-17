package com.example.helloworld.service;


import com.example.helloworld.entity.UserInfo;

public interface UserInfoService {
    UserInfo get(String username);
    void save(UserInfo userInfo);
    void modify(UserInfo userInfo);
}
