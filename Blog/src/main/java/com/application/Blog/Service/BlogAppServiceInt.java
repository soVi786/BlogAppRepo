package com.application.Blog.Service;

import java.util.List;

import com.application.Blog.Model.Post;
import com.application.Blog.Model.User;

public interface BlogAppServiceInt {

	List<User> getUserDetails() throws Exception;
	List<Post> getPostDetails() throws Exception;
	String createBlogPost(Post post) throws Exception;
	
}
