package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Comment implements Serializable {
    private int id;
    private String username;
    private String com_content;
    private String com_time;

    public Comment(int id, String username, String com_content, String com_time) {
        this.id = id;
        this.username = username;
        this.com_content = com_content;
        this.com_time = com_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", com_content='" + com_content + '\'' +
                ", com_time='" + com_time + '\'' +
                '}';
    }
}
