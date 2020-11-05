package com.application.Blog.Model;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

	private int userId,id;
	private String title, body;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
