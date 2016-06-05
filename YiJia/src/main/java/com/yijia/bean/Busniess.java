package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/4.
 */
public class Busniess implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String logo;
    private String name;
    private String sale;
    private String promise;
    private String tel;
    private String address;


    public Busniess(int id, String logo, String name, String sale, String promise, String tel, String address) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.sale = sale;
        this.promise = promise;
        this.tel = tel;
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getPromise() {
        return promise;
    }

    public void setPromise(String promise) {
        this.promise = promise;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
