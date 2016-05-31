package com.yijia.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by laz on 2016/5/27.
 */
public class MyQuestionData implements Serializable {
    private int userpic;
    private String username;
    private String questext;
    private String mDate;

    public MyQuestionData(int userpic, String username, String questext, int quespic, String date) {
        this.userpic = userpic;
        this.username = username;
        this.questext = questext;
        mDate = date;
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

    public String getQuestext() {
        return questext;
    }

    public void setQuestext(String questext) {
        this.questext = questext;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
