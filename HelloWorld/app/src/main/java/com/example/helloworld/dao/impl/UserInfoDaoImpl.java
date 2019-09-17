package com.example.helloworld.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.helloworld.dao.UserInfoDao;
import com.example.helloworld.entity.UserInfo;
import com.example.helloworld.utils.DBHepler;

import java.util.List;


public class UserInfoDaoImpl implements UserInfoDao {
    private DBHepler helper;//用于创建数据库，获取数据库对象
    private SQLiteDatabase db; //用于执行SQL语句
    public UserInfoDaoImpl(Context context){
        helper=DBHepler.getInstance(context);
    }
    @Override
    public List<UserInfo> select() {
        return null;
    }

    @Override
    public UserInfo select(String username) {
        UserInfo userInfo = null;
        db = helper.getReadableDatabase();
        Cursor cursor = db.query(DBHepler.TBL_NAME_USER,null,"user_name=?",new String[]{username},null,null,null);
        if(cursor !=null && cursor.moveToFirst()){
            userInfo = new UserInfo();
            userInfo.setUsername(cursor.getString(
                    cursor.getColumnIndex("user_name")));
            userInfo.setNickname(cursor.getString(
                    cursor.getColumnIndex("nick_name")));
            userInfo.setSex(cursor.getString(
                    cursor.getColumnIndex("sex")));
            userInfo.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            userInfo.setSignature(cursor.getString(cursor.getColumnIndex("signature")));
            cursor.close();

        }
        db.close();
        return userInfo;

    }

    @Override
    public void insert(UserInfo userInfo) {
        ContentValues values = new ContentValues();
        values.put("user_name",userInfo.getUsername());
        values.put("nick_name",userInfo.getNickname());
        values.put("sex",userInfo.getSex());
        values.put("signature",userInfo.getSignature());
        db = helper.getWritableDatabase();
        db.insert(DBHepler.TBL_NAME_USER,null,values);
        db.close();
    }

    @Override
    public void update(UserInfo userInfo) {
        ContentValues values = new ContentValues();
        values.put("user_name",userInfo.getUsername());
        values.put("nick_name",userInfo.getNickname());
        values.put("sex",userInfo.getSex());
        values.put("signature",userInfo.getSignature());
        db = helper.getWritableDatabase();
        db.update(DBHepler.TBL_NAME_USER,values,"user_name",new String[]{userInfo.getUsername()});
        db.close();
    }

    @Override
    public void delete(UserInfo userInfo) {
        db = helper.getWritableDatabase();
        db.delete(DBHepler.TBL_NAME_USER,
        "user_name?",new String[]{userInfo.getUsername()});
        db.close();

    }
}
