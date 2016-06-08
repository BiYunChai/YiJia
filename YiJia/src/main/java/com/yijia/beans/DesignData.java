package com.yijia.beans;

import java.io.Serializable;

/**
 * Created by laz on 2016/6/8.
 */
public class DesignData implements Serializable {
    String design_title;
    String designer;
    String design_style;
    String design_square;
    String design_price;
    String design_type;
    String design_buildaddress;
    String design_inspire;
    int design_pic;

    public DesignData(String design_title, String designer, String design_style, String design_square,String design_price,String design_type,  String design_buildaddress, String design_inspire, int design_pic) {
        this.design_title = design_title;
        this.designer = designer;
        this.design_style = design_style;
        this.design_type = design_type;
        this.design_square = design_square;
        this.design_price = design_price;
        this.design_buildaddress = design_buildaddress;
        this.design_inspire = design_inspire;
        this.design_pic = design_pic;
    }

    public String getDesign_title() {
        return design_title;
    }

    public void setDesign_title(String design_title) {
        this.design_title = design_title;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDesign_style() {
        return design_style;
    }

    public void setDesign_style(String design_style) {
        this.design_style = design_style;
    }

    public String getDesign_type() {
        return design_type;
    }

    public void setDesign_type(String design_price) {
        this.design_type = design_price;
    }

    public String getDesign_price() {
        return design_price;
    }

    public void setDesign_price(String design_price) {
        this.design_price = design_price;
    }
    public String getDesign_square() {
        return design_square;
    }
    public void setDesign_square(String design_square) {
        this.design_square = design_square;
    }

    public String getDesign_buildaddress() {
        return design_buildaddress;
    }

    public void setDesign_buildaddress(String design_buildaddress) {
        this.design_buildaddress = design_buildaddress;
    }

    public String getDesign_inspire() {
        return design_inspire;
    }

    public void setDesign_inspire(String design_inspire) {
        this.design_inspire = design_inspire;
    }

    public int getDesign_pic() {
        return design_pic;
    }

    public void setDesign_pic(int design_pic) {
        this.design_pic = design_pic;
    }
}
