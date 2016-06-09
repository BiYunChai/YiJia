package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Postimg implements Serializable {
    private int id;
    private int postid;
    private String picurl;

    public Postimg(int id, int postid, String picurl) {
        this.id = id;
        this.postid = postid;
        this.picurl = picurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Override
    public String toString() {
        return "Postimg{" +
                "id=" + id +
                ", postid=" + postid +
                ", picurl='" + picurl + '\'' +
                '}';
    }
}
