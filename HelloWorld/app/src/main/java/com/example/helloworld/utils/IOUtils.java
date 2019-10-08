package com.example.helloworld.utils;



import android.util.Xml;

import com.example.helloworld.entity.ExerciseDetail;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
     public static List<ExerciseDetail> getXmlContents(InputStream is)throws Exception {
         List<ExerciseDetail> details = null;
         ExerciseDetail detail = null;
         //创建一个解析题
         XmlPullParser parser = Xml.newPullParser();
         //2.设置输入源
         parser.setInput(is, StandardCharsets.UTF_8.toString());
         //3.根据EventType类型，判断节点名称，解析数据，将输入放入集合
         int eventType = parser.getEventType();
         while(eventType != XmlPullParser.END_DOCUMENT){
             String nodeName = parser.getName();
             switch (eventType){
                 case XmlPullParser
             }
         }

     }








    public static String convert(InputStream is, Charset encode) {
        try {
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, encode));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> convert(String json, Class<T> cls) {
        return JSON.parseArray(json, cls);
    }
}