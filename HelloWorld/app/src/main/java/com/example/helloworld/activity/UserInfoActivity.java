package com.example.helloworld.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.entity.UserInfo;
import com.example.helloworld.service.impl.UserInfoServiceImpl;
import com.example.helloworld.utils.SharedUtils;

public class UserInfoActivity extends AppCompatActivity {
    private TextView tvNickname,tvUsername,tvSex,tvSignature;
    private LinearLayout setting_name, setting_nickname;
    private String spUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }

    public void initData() {
        spUsername = SharedUtils.readValue(this, "loginUser");
        service = new UserInfoServiceImpl(this);
        userInfo = service.get(spUsername);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setUsername(spUsername);
            userInfo.setNickname("课程助手");
            userInfo.setSignature("课程助手");
            userInfo.setSex("男");

        }
    }
    private void initView(){
        tvUsername = findViewById(R.id.tv_username);
        tvNickname = findViewById(R.id.);

        tvUsername = findViewById(R.id.tv_username);

    }


    private void modifyNickname(){
        //获取已有的内容
        String nickname = tvNickname.getText().toString();
        //2.根据需要传递数据到下一个activity
        Intent intent  = new Intent(UserInfoActivity.this,ChangeUserInfoActivity);
        Bundle bundle = new Bundle();
        bundle.putString("title","设置昵称");
        bundle.putString("value",nickname);
        bundle.putString("flag",1);
        intent.putExtra(bundle);
        startActivityForResult(intent,1);
    }












