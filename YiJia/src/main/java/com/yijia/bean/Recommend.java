package com.yijia.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Recommend implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imgaddress ;
    private String topic;
    private String designer;
    private Date rectime;
    public Recommend( String imgaddress, String topic, String designer, Date rectime) {
        super();

        this.imgaddress = imgaddress;
        this.topic = topic;
        this.designer = designer;
        this.rectime = rectime;

    }


    public String getImgaddress() {
        return imgaddress;
    }
    public void setImgaddress(String imgaddress) {
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
    public Date getRectime() {
        return rectime;
    }
    public void setRectime(Date rectime) {
        this.rectime = rectime;
    }



}