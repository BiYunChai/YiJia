package com.yijia.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Post implements Serializable{
    private int id;
    private String userphoto;
    private String uasernickname;
    private String content;
    private String Date;
    private List<Postimg> Postimgs;



    public Post(String userphoto,int id, String uasernickname, String content, String date, List<Postimg> Postimgs) {

        this.id = id;
        this.uasernickname = uasernickname;
        this.userphoto=userphoto;
        this.content = content;
        this.Date = date;
        this.Postimgs = Postimgs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUasernickname() {
        return uasernickname;
    }

    public void setUasernickname(String uasernickname) {
        this.uasernickname = uasernickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public List<Postimg> getPostimgs() {
        return Postimgs;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public void setPostimgs(List<Postimg> Postimgs) {
        this.Postimgs = Postimgs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userphoto='" + userphoto + '\'' +
                ", uasernickname='" + uasernickname + '\'' +
                ", content='" + content + '\'' +
                ", Date='" + Date + '\'' +
                ", Postimgs=" + Postimgs +
                '}';
    }
}
