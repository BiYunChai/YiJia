package com.yijia.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by laz on 2016/5/27.
 */
public class MyPostData implements Serializable {
    private int userpic;
    private String username;
    private String postcontent;
    private int postpic;
    private String mDate;

    public MyPostData(int userpic, String username, String postcontent, int postpic, String date) {
        this.userpic = userpic;
        this.username = username;
        this.postcontent = postcontent;
        this.postpic = postpic;
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

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
