package com.yijia.bean;

import java.io.Serializable;
import java.util.List;

public class step implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int sid;
	
	String statu;
	String score;
	String content;
	String companyname;
	String stepname;
	String stepcontent;
	List<step_detail>  step_details;
	
	public step(int id,int sid, String statu, String score, String content,
			String companyname, String stepname,List<step_detail>  step_details,String stepcontent) {
		super();
		this.id=id;
		this.sid = sid;
		this.stepcontent=stepcontent;
		this.statu = statu;
		this.score = score;
		this.content = content;
		this.companyname = companyname;
		this.stepname = stepname;
		this.step_details=step_details;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getStepname() {
		return stepname;
	}
	public void setStepname(String stepname) {
		this.stepname = stepname;
	}
	

	

	public String getStepcontent() {
		return stepcontent;
	}

	public void setStepcontent(String stepcontent) {
		this.stepcontent = stepcontent;
	}

	public List<step_detail> getStep_details() {
		return step_details;
	}

	public void setStep_details(List<step_detail> step_details) {
		this.step_details = step_details;
	}

	@Override
	public String toString() {
		return "step [id=" + id + ", sid=" + sid + ", statu=" + statu
				+ ", score=" + score + ", content=" + content
				+ ", companyname=" + companyname + ", stepname=" + stepname
				+ ", stepcontent=" + stepcontent + ", step_details="
				+ step_details + "]";
	}

	

	
	

	
	
	
	
	
	
	

}
