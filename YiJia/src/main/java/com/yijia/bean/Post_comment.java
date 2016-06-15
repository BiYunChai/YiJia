package com.yijia.bean;

import java.io.Serializable;
import java.sql.Date;

public class Post_comment implements Serializable {

	/**
	 * username,nickname,content,date
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String comm_username;
	private String comm_content;
	private String date;

	public Post_comment(String username, String comm_username, String comm_content, String date) {
		this.username = comm_username;
		this.comm_username = comm_username;
		this.comm_content = comm_content;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComm_username() {
		return comm_username;
	}

	public void setComm_username(String comm_username) {
		this.comm_username = comm_username;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Post_comment{" +
				"username='" + username + '\'' +
				", comm_username='" + comm_username + '\'' +
				", comm_content='" + comm_content + '\'' +
				", date='" + date + '\'' +
				'}';
	}
}
