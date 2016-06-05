package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/5.
 */
public class Company implements Serializable {
    private int id;
    private String imgaddress ;
    private String Companyname;
    private float score;
    private String comtel;

    public Company(int id, String imgaddress, String companyname, float score, String comtel) {
        this.id = id;
        this.imgaddress = imgaddress;
        this.Companyname = companyname;
        this.score = score;
        this.comtel = comtel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress;
    }

    public String getCompanyname() {
        return Companyname;
    }

    public void setCompanyname(String companyname) {
        Companyname = companyname;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getComtel() {
        return comtel;
    }

    public void setComtel(String comtel) {
        this.comtel = comtel;
    }
}

