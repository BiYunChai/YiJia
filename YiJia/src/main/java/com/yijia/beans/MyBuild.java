package com.yijia.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by laz on 2016/5/23.
 */
//此处实现序列化接口主要为了通过intent传递javabean对象
public class MyBuild implements Serializable{
   private String mybuild;
    private String mDate;

    public MyBuild(String mybuild, String date) {
        this.mybuild = mybuild;
        mDate = date;
    }

    public String getMybuild() {
        return mybuild;
    }

    public void setMybuild(String mybuild) {
        this.mybuild = mybuild;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
