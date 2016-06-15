package com.yijia.beans;

import java.io.Serializable;

public class Compdesign implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	 private int id;
	 private int cid;
	 private String design_pic;
	 private String design_title;
	 private String designer;
	 private String design_style;
	 private double design_price;
	 private String design_type;
	 private double design_square;
	 private String design_buildaddress;
	 private String design_inspire;
	public Compdesign() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compdesign(int id, int cid, String design_pic, String design_title,
			String designer, String design_style, double design_price,
			String design_type, double design_square,
			String design_buildaddress, String design_inspire) {
		super();
		this.id = id;
		this.cid = cid;
		this.design_pic = design_pic;
		this.design_title = design_title;
		this.designer = designer;
		this.design_style = design_style;
		this.design_price = design_price;
		this.design_type = design_type;
		this.design_square = design_square;
		this.design_buildaddress = design_buildaddress;
		this.design_inspire = design_inspire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getDesign_pic() {
		return design_pic;
	}
	public void setDesign_pic(String design_pic) {
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
	public double getDesign_price() {
		return design_price;
	}
	public void setDesign_price(double design_price) {
		this.design_price = design_price;
	}
	public String getDesign_type() {
		return design_type;
	}
	public void setDesign_type(String design_type) {
		this.design_type = design_type;
	}
	public double getDesign_square() {
		return design_square;
	}
	public void setDesign_square(double design_square) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Compdesign [id=" + id + ", cid=" + cid + ", design_pic="
				+ design_pic + ", design_title=" + design_title + ", designer="
				+ designer + ", design_style=" + design_style
				+ ", design_price=" + design_price + ", design_type="
				+ design_type + ", design_square=" + design_square
				+ ", design_buildaddress=" + design_buildaddress
				+ ", design_inspire=" + design_inspire + "]";
	}
	

}
