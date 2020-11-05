package com.application.Blog.Aggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.Blog.Model.AllUserInfo;
import com.application.Blog.Model.Post;
import com.application.Blog.Model.User;
import com.application.Blog.Service.BlogAppServiceInt;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BlogAppAggregator {
	
	@Autowired BlogAppServiceInt service ;
	@Autowired ObjectMapper mapper ;
	
	public String getAllDetails() {
		String resp = "" ;
		try {
			List<User> users = service.getUserDetails();
			List<Post> posts = (null != users && !users.isEmpty()) ? service.getPostDetails() : null; 
			if(null != posts) {
				List<AllUserInfo> allUserInfo = new ArrayList<AllUserInfo>();
				for(User user : users) {
					AllUserInfo userInfo = new AllUserInfo();
					userInfo.setUser(user);
					List<Post> blogs = posts.stream().filter
							(post -> post.getUserId() == user.getId()).collect(Collectors.toList());
					userInfo.setPosts(blogs);
					allUserInfo.add(userInfo);
				}
				resp = mapper.writeValueAsString(allUserInfo);
			}
		}catch(Exception e) {
			resp =  "Error occurred in " + e.getMessage();
		}
		return resp;
	}

	public String createBlog(Post post) {
		String resp = "";
		try {
			resp = service.createBlogPost(post) ;
		}catch(Exception e) {
			resp = "Error occurred in " +e.getMessage();
		}
		return resp ;
	}
}
