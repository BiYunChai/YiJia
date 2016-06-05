package com.yijia.bean;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Good {
    private int id;
    private String name;
    private String price;
    private String pic;

    public Good(String name, String price,String pic) {
        this.name = name;
        this.price = price;
        this.pic=pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
