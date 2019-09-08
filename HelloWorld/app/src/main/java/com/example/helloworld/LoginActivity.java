package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;



import com.example.helloworld.utils.MD5Utils;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText etUsername,etPassword;
    private Button btnRegister,btnLogin,btnForget;



    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        initToolBar();
//        initView();
//      btnLogin.setOnClickListener(new View.OnClickListener(){
//
//          @Override
//          public void onClick(View view) {
//              String username = etUsername.getText().toString();
//              String password = etPassword.getText().toString();
//              //3.2检查控件的有效性
//              SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
//              String name = pref.getString("username","");
//              String pwd = pref.getString("password", "");
//              if(TextUtils.isEmpty(username)){
//                  Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT);
//              }else if(TextUtils.isEmpty(password)){
//                  Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
//              }else if(!username.equals(name)){
//                  Toast.makeText(LoginActivity.this, "用户名错误", Toast.LENGTH_SHORT).show();
//              }else if(!MD5Utils.md5(password).equals(pwd)){
//                  Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
//              }else {
//                  Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
//                  //给btn1添加点击事件
//                  Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                  //启动
//                  startActivity(intent);
//              }
//          }
//      });
//
//      btnRegister.setOnClickListener(new View.OnClickListener(){
//
//          @Override
//          public void onClick(View view) {
//              //给btn1添加点击响应事件
//              Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
//              //启动
//              startActivity(intent);
//          }
//      });
//    }
//
//
//
//    private void initToolBar() {
//        toolbar = findViewById(R.id.title_toolbar);
//        toolbar.setTitle("登录");
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar !=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);//设置返回键
//            actionBar.setHomeButtonEnabled(true);//设置是否是首页
//        }
//        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                LoginActivity.this.finish();
//            }
//        });
//
//    }
//    private void initView() {
//        etUsername = findViewById(R.id.et_username);
//        etPassword = findViewById(R.id.et_password);
//        btnRegister = findViewById(R.id.btn_register);
//        btnLogin = findViewById(R.id.btn_login);
//        btnForget = findViewById(R.id.btn_forget_password);
//
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    initView();
//     initToolbar();
    initData();
}

    private void initData() {
        String username = readPref();
        if (!TextUtils.isEmpty(username)){
           etUsername.setText(username);
        }
    }

    private String readPref() {
        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        return sp.getString("username","");
    }

    private void initView() {
       etUsername=findViewById(R.id.et_username);
       etPassword=findViewById(R.id.et_password);

        TextView tvRegister=findViewById(R.id.btn_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

//    private void initToolbar() {
//        Toolbar toolbar=findViewById(R.id.title_toolbar);
//        toolbar.setTitle("登录");
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar=getSupportActionBar();
//        if (actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LoginActivity.this.finish();
//            }
//        });
//       }

}
