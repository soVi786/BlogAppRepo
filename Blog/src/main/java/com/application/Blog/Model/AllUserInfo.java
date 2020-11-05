package com.application.Blog.Model;

import java.util.ArrayList;
import java.util.List;

public class AllUserInfo {
	private User user;
	private List<Post> posts = new ArrayList<Post>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}