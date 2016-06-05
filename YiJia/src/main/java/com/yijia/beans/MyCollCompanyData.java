package com.yijia.beans;

import java.io.Serializable;

/**
 * Created by laz on 2016/6/4.
 */
public class MyCollCompanyData implements Serializable {
    private int collcomp_pic;
    private String collcomp_name;
    private String rate;

    public MyCollCompanyData(int collcomp_pic, String collcomp_name, String rate) {
        this.collcomp_pic = collcomp_pic;
        this.collcomp_name = collcomp_name;
        this.rate = rate;
    }

    public int getCollcomp_pic() {
        return collcomp_pic;
    }

    public void setCollcomp_pic(int collcomp_pic) {
        this.collcomp_pic = collcomp_pic;
    }

    public String getCollcomp_name() {
        return collcomp_name;
    }

    public void setCollcomp_name(String collcomp_name) {
        this.collcomp_name = collcomp_name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
