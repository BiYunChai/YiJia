package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by laz on 2016/6/1.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private int sex;
    private String heading;
    private String adddetail;
    private String vertify;
    private int ustatus;

    public User(String username, String nickname, String password, String phone, String email, int sex, String heading, String adddetail, String vertify, int ustatus) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.heading = heading;
        this.adddetail = adddetail;
        this.vertify = vertify;
        this.ustatus = ustatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getAdddetail() {
        return adddetail;
    }

    public void setAdddetail(String adddetail) {
        this.adddetail = adddetail;
    }

    public String getVertify() {
        return vertify;
    }

    public void setVertify(String vertify) {
        this.vertify = vertify;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }
}
