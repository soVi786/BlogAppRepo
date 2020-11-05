package com.application.Blog.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.Blog.Model.Post;
import com.application.Blog.Model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BlogAppServiceImpl implements BlogAppServiceInt{
	
	RestTemplate restTemplate  = new RestTemplate();
	@Autowired 
	ObjectMapper mapper ;
	
	@Override
	public List<User> getUserDetails() throws Exception{
		List<User> users = new ArrayList<User>();
		String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
		if(null != response && !response.isEmpty()) {
			users = (List<User>) mapper.readValue(response, new TypeReference<List<User>>() {});
		}
		return users;
	}

	@Override
	public List<Post> getPostDetails() throws Exception{
		List<Post> posts = new ArrayList<Post>();
		String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
		if(null != response && !response.isEmpty()) {
			posts = (List<Post>) mapper.readValue(response, new TypeReference<List<Post>>() {});
		}
		return posts;
	}

	@Override
	public String createBlogPost(Post post) throws Exception {
		String response  = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", post, String.class);
		return response ;
	}

}
