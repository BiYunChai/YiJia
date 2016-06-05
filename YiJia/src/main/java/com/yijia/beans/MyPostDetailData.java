package com.yijia.beans;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by laz on 2016/5/29.
 */
public class MyPostDetailData implements Serializable {
    private int userpic;
    private String username;
    private String date;
    private String postcontent;
    private int postpic;
    private int zan;
    private int comment;

    public MyPostDetailData(int userpic, String username, String date, String postcontent, int postpic, int zan, int comment) {
        this.userpic = userpic;
        this.username = username;
        this.date = date;
        this.postcontent = postcontent;
        this.postpic = postpic;
        this.zan = zan;
        this.comment = comment;
    }

    public int getUserpic() {
        return userpic;
    }

    public void setUserpic(int userpic) {
        this.userpic = userpic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public int getPostpic() {
        return postpic;
    }

    public void setPostpic(int postpic) {
        this.postpic = postpic;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
