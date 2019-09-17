package com.example.helloworld.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class DBHepler extends SQLiteOpenHelper {
    public static final String DB_NAME="course.db";
    public static final int DB_VERSION=1;
    public static final String TBL_NAME_USER = "tb_user";
    public static final String TBL_USER="create table if not exists"+TBL_NAME_USER +
            "(_id integer primary key autoincrement，"+
            "user_name varchar,"+
            "nick_name varchar," +
            "sex varchar，" +
            "signature varchar）";
    private static  DBHepler helper;
    private DBHepler(@Nullable Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
   public static DBHepler getInstance(Context context){
        if(helper == null){
            helper =new DBHepler(context);
        }
        return  helper;
    }

//    public DBHepler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
