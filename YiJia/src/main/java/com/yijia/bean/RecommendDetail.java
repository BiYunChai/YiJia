package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/5.
 */
public class RecommendDetail implements Serializable {
    private int id;
    private int pic_id;
    private int pic_num;
    private String pic;

    public RecommendDetail(int id, int pic_id, int pic_num, String pic) {
        this.id = id;
        this.pic_id = pic_id;
        this.pic_num = pic_num;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public int getPic_num() {
        return pic_num;
    }

    public void setPic_num(int pic_num) {
        this.pic_num = pic_num;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}