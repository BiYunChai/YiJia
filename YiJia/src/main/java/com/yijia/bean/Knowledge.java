package com.yijia.bean;

import java.sql.Date;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Knowledge {
    String title;
    String content;
    String knowledgepic;
    Date ktime;

    public Knowledge(String title, String content, String knowledgepic, Date ktime) {
        this.title = title;
        this.content = content;
        this.knowledgepic = knowledgepic;
        this.ktime = ktime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKnowledgepic() {
        return knowledgepic;
    }

    public void setKnowledgepic(String knowledgepic) {
        this.knowledgepic = knowledgepic;
    }

    public Date getKtime() {
        return ktime;
    }

    public void setKtime(Date ktime) {
        this.ktime = ktime;
    }
}
