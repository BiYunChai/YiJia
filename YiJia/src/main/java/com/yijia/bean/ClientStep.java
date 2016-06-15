package com.yijia.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/15.
 */
public class ClientStep implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    String statu;
    String stepcontent;
    String stepname;


    public ClientStep(String statu, String stepcontent, String stepname) {
        this.statu = statu;
        this.stepcontent = stepcontent;
        this.stepname = stepname;
    }

    public String getStatu() {
        return statu;
    }
    public void setStatu(String statu) {
        this.statu = statu;
    }


    public String getStepname() {
        return stepname;
    }
    public void setStepname(String stepname) {
        this.stepname = stepname;
    }

    public String getStepcontent() {
        return stepcontent;
    }

    public void setStepcontent(String stepcontent) {
        this.stepcontent = stepcontent;
    }

    @Override
    public String toString() {
        return "ClientStep{" +
                "statu='" + statu + '\'' +
                ", stepcontent='" + stepcontent + '\'' +
                ", stepname='" + stepname + '\'' +
                '}';
    }
}
