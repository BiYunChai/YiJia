package com.yijia.bean;

import java.util.IdentityHashMap;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Theme {
    private int id;
    private String house;
    private String type;
    private String title;
    private String description;
    private String pic;

    public Theme(int id, String title, String description, String pic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
