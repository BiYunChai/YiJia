package com.yijia.beans;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      private int id;
    //logo地址
      private String logoaddress ;
    //公司名称
      private String Companyname;
      private float  score;
      private String comtel;
      private String compaddgeneral;
      private String  compadddetail;
    //设计方案
      private List<Compdesign> compdesign; 
    //公司证书
      private List<Compvertify> compvertify; 
      private String compemail;
    //公司简介
      private String compdescription;
    //投诉人数
      private int complaintNum;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int id, String logoaddress, String companyname, float score,
			String comtel, String compaddgeneral, String compadddetail,
			List<Compdesign> compdesign, List<Compvertify> compvertify,
			String compemail, String compdescription, int complaintNum) {
		super();
		this.id = id;
		this.logoaddress = logoaddress;
		Companyname = companyname;
		this.score = score;
		this.comtel = comtel;
		this.compaddgeneral = compaddgeneral;
		this.compadddetail = compadddetail;
		this.compdesign = compdesign;
		this.compvertify = compvertify;
		this.compemail = compemail;
		this.compdescription = compdescription;
		this.complaintNum = complaintNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogoaddress() {
		return logoaddress;
	}
	public void setLogoaddress(String logoaddress) {
		this.logoaddress = logoaddress;
	}
	public String getCompanyname() {
		return Companyname;
	}
	public void setCompanyname(String companyname) {
		Companyname = companyname;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getComtel() {
		return comtel;
	}
	public void setComtel(String comtel) {
		this.comtel = comtel;
	}
	public String getCompaddgeneral() {
		return compaddgeneral;
	}
	public void setCompaddgeneral(String compaddgeneral) {
		this.compaddgeneral = compaddgeneral;
	}
	public String getCompadddetail() {
		return compadddetail;
	}
	public void setCompadddetail(String compadddetail) {
		this.compadddetail = compadddetail;
	}
	public List<Compdesign> getCompdesign() {
		return compdesign;
	}
	public void setCompdesign(List<Compdesign> compdesign) {
		this.compdesign = compdesign;
	}
	public List<Compvertify> getCompvertify() {
		return compvertify;
	}
	public void setCompvertify(List<Compvertify> compvertify) {
		this.compvertify = compvertify;
	}
	public String getCompemail() {
		return compemail;
	}
	public void setCompemail(String compemail) {
		this.compemail = compemail;
	}
	public String getCompdescription() {
		return compdescription;
	}
	public void setCompdescription(String compdescription) {
		this.compdescription = compdescription;
	}
	public int getComplaintNum() {
		return complaintNum;
	}
	public void setComplaintNum(int complaintNum) {
		this.complaintNum = complaintNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", logoaddress=" + logoaddress
				+ ", Companyname=" + Companyname + ", score=" + score
				+ ", comtel=" + comtel + ", compaddgeneral=" + compaddgeneral
				+ ", compadddetail=" + compadddetail + ", compdesign="
				+ compdesign + ", compvertify=" + compvertify + ", compemail="
				+ compemail + ", compdescription=" + compdescription
				+ ", complaintNum=" + complaintNum + "]";
	}
 

}

