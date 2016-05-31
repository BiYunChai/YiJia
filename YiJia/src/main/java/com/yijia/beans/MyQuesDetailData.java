package com.yijia.beans;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by laz on 2016/5/29.
 */
public class MyQuesDetailData implements Serializable {
    private int userpic;
    private String username;
    private String date;
    private String quescontent;
    private int quespic;
    private int zan;
    private int comment;

    public MyQuesDetailData(int userpic, String username, String date, String quescontent, int quespic, int zan, int comment) {
        this.userpic = userpic;
        this.username = username;
        this.date = date;
        this.quescontent = quescontent;
        this.quespic = quespic;
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

    public String getQuescontent() {
        return quescontent;
    }

    public void setQuescontent(String quescontent) {
        this.quescontent = quescontent;
    }

    public int getQuespic() {
        return quespic;
    }

    public void setQuespic(int quespic) {
        this.quespic = quespic;
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
