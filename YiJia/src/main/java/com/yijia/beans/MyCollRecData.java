package com.yijia.beans;

import java.io.Serializable;


/**
 * Created by laz on 2016/6/3.
 */
public class MyCollRecData implements Serializable {
    private int  rec_pic ;
    private String topic;
    private String collrectime;

    public MyCollRecData(int rec_pic, String topic, String collrectime) {
        this.rec_pic = rec_pic;
        this.topic = topic;
        this.collrectime = collrectime;
    }

    public int getRec_pic() {
        return rec_pic;
    }

    public void setRec_pic(int rec_pic) {
        this.rec_pic = rec_pic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCollrectime() {
        return collrectime;
    }

    public void setCollrectime(String collrectime) {
        this.collrectime = collrectime;
    }
}
