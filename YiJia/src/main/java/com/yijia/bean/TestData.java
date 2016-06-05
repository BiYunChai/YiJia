package com.yijia.bean;

import java.io.Serializable;


/**
 * Created by Administrator on 2016/5/25.
 */
public class TestData implements Serializable {
    private int id;
    private int imgaddress ;
    private String Companyname;
    private float score;
    private String comtel;

    public TestData(int id, int imgaddress, String companyname, float score, String comtel) {
        this.id = id;
        this.imgaddress = imgaddress;
        Companyname = companyname;
        this.score = score;
        this.comtel = comtel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(int imgaddress) {
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
