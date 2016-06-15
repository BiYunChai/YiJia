package com.yijia.bean;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Theme implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String house;
    private String type;
    private String title;
    private String description;
    private String pic;
    private List<ThemePicDetail> mThemePicDetailList;

    public Theme(int id, String title, String description, String pic,List<ThemePicDetail> mThemePicDetailList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pic = pic;
        this.mThemePicDetailList=mThemePicDetailList;
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

    public List<ThemePicDetail> getmThemePicDetailList() {
        return mThemePicDetailList;
    }

    public void setmThemePicDetailList(List<ThemePicDetail> mThemePicDetailList) {
        this.mThemePicDetailList = mThemePicDetailList;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", house='" + house + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pic='" + pic + '\'' +
                ", mThemePicDetailList=" + mThemePicDetailList +
                '}';
    }
}
