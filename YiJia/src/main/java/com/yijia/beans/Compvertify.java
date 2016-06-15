package com.yijia.beans;

import java.io.Serializable;

public class Compvertify implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cid;//装修公司id
	private String vertifyaddress;
	public Compvertify() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compvertify(int id, int cid, String vertifyaddress) {
		super();
		this.id = id;
		this.cid = cid;
		this.vertifyaddress = vertifyaddress;
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
	public String getVertifyaddress() {
		return vertifyaddress;
	}
	public void setVertifyaddress(String vertifyaddress) {
		this.vertifyaddress = vertifyaddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Compvertify [id=" + id + ", cid=" + cid + ", vertifyaddress="
				+ vertifyaddress + "]";
	}
	

}
