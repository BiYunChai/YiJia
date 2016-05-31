package com.yijia.bean;

import java.io.Serializable;


/**
 * Created by Administrator on 2016/5/25.
 */
public class TestData implements Serializable {
    private int imgaddress ;
    private String topic;
    private String designer;
    private String rectime;
    public TestData( int imgaddress, String topic,
                      String designer, String rectime) {
        super();

        this.imgaddress = imgaddress;
        this.topic = topic;
        this.designer = designer;
        this.rectime = rectime;
    }


    public int getImgaddress() {
        return imgaddress;
    }
    public void setImgaddress(int imgaddress) {
        this.imgaddress = imgaddress;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getDesigner() {
        return designer;
    }
    public void setDesigner(String designer) {
        this.designer = designer;
    }
    public String getRectime() {
        return rectime;
    }
    public void setRectime(String rectime) {
        this.rectime = rectime;
    }



}
