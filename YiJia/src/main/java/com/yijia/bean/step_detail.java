package com.yijia.bean;

import java.io.Serializable;

public class step_detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stepurl;
	private String Stepcontent;
	public step_detail(String stepurl, String stepcontent) {
		super();
		this.stepurl = stepurl;
		Stepcontent = stepcontent;
	}
	public String getStepurl() {
		return stepurl;
	}
	public void setStepurl(String stepurl) {
		this.stepurl = stepurl;
	}
	public String getStepcontent() {
		return Stepcontent;
	}
	public void setStepcontent(String stepcontent) {
		Stepcontent = stepcontent;
	}
	@Override
	public String toString() {
		return "step_detail [stepurl=" + stepurl + ", Stepcontent="
				+ Stepcontent + "]";
	}
	
	
	

}
