package com.yijia.bean;

import java.io.Serializable;
import java.util.List;

public class Build implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	
	private String buildname;
	private List<step> steps;
	public Build(int id, String buildname,List<step> steps) {
		super();
		this.id = id;
		this.steps=steps;
		this.buildname = buildname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBuildname() {
		return buildname;
	}
	public void setBuildname(String buildname) {
		this.buildname = buildname;
	}
	public List<step> getSteps() {
		return steps;
	}
	public void setSteps(List<step> steps) {
		this.steps = steps;
	}
	@Override
	public String toString() {
		return "Build [id=" + id + ", buildname=" + buildname + ", steps="
				+ steps + "]";
	}
	
	
	

}
