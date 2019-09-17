package com.example.helloworld.service.impl;



import android.content.Context;

import com.example.helloworld.dao.UserInfoDao;
import com.example.helloworld.dao.impl.UserInfoDaoImpl;
import com.example.helloworld.entity.UserInfo;
import com.example.helloworld.service.UserInfoService;


public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao dao;
    private UserInfoServiceImpl(Context context){
       dao = new UserInfoDaoImpl(context);
    }
    @Override
    public UserInfo get(String username) {
        return dao.select(username);
    }

    @Override
    public void save(UserInfo userInfo) {
        dao.insert(userInfo);
    }

    @Override
    public void modify(UserInfo userInfo) {
      dao.update(userInfo);
    }
}
