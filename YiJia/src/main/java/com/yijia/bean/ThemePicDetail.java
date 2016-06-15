package com.yijia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/11.
 */
public class ThemePicDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	public ThemePicDetail(String address) {
		super();
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ThemePicDetail [address=" + address + "]";
	}
    
}
