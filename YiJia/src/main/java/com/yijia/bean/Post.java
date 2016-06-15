package com.yijia.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Post implements Serializable{
    private int id;
    private String username;
    private String userphoto;
    private String content;
    private String date;
    private List<Postimg> Postimgs;
    private List<Post_comment> post_comments;

    public Post(int id,String usernickname, String userphoto,
                String content, String date, List<Postimg> Postimgs,List<Post_comment> post_comments) {

        this.id=id;
        this.username = usernickname;
        this.userphoto = userphoto;
        this.content = content;
        this.date = date;
        this.Postimgs = Postimgs;
        this.post_comments=post_comments;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Postimg> getPostimgs() {
        return Postimgs;
    }

    public void setPostimgs(List<Postimg> Postimgs) {
        this.Postimgs = Postimgs;
    }



    public List<Post_comment> getPost_comments() {
        return post_comments;
    }

    public void setPost_comments(List<Post_comment> post_comments) {
        this.post_comments = post_comments;
    }

    public int getPid() {
        return id;
    }

    public void setPid(int pid) {
        this.id = pid;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + id +
                ", username='" + username + '\'' +
                ", userphoto='" + userphoto + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", Postimgs=" + Postimgs +
                ", post_comments=" + post_comments +
                '}';
    }
}
