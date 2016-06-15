package com.yijia.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Recommend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pic_id;
	
	private String imgaddress ;
	private String topic;
	private String designer;
	private Date rectime;
	private List<RecommendDetail> details;
	public Recommend(int pic_id, String imgaddress, String topic,
			String designer, Date rectime,List<RecommendDetail> details) {
		super();
		this.pic_id = pic_id;
		
		this.imgaddress = imgaddress;
		this.topic = topic;
		this.designer = designer;
		this.rectime = rectime;
		this.details=details;
	}
	public int getPic_id() {
		return pic_id;
	}
	public void setPic_id(int pic_id) {
		this.pic_id = pic_id;
	}
	
	public String getImgaddress() {
		return imgaddress;
	}
	public void setImgaddress(String imgaddress) {
		this.imgaddress = imgaddress;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public Date getRectime() {
		return rectime;
	}
	public void setRectime(Date rectime) {
		this.rectime = rectime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<RecommendDetail> getDetails() {
		return details;
	}
	public void setDetails(List<RecommendDetail> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Recommend [pic_id=" + pic_id + ", imgaddress=" + imgaddress
				+ ", topic=" + topic + ", designer=" + designer + ", rectime="
				+ rectime + ", details=" + details + "]";
	}
	
	
	
	
	

}
