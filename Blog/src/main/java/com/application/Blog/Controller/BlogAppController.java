package com.application.Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Blog.Aggregator.BlogAppAggregator;
import com.application.Blog.Model.Post;

@RestController
public class BlogAppController {
	
	@Autowired BlogAppAggregator aggregator ;
	
	@GetMapping(value = "/getAllDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllDetails(){
		String resp = aggregator.getAllDetails();
		if(null != resp && !resp.isEmpty()){
			return new ResponseEntity<String>(resp,
					(resp.contains("error")) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);

		}else{
			return new ResponseEntity<String>("Details are Empty",HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object createBlog(Post post) {
		if(null != post && post.getId() > 0 && post.getUserId() > 0 &&
				null != post.getTitle() && null != post.getBody()) {
			String resp = aggregator.createBlog(post);
			return new ResponseEntity<String>(resp,
					(null != resp && !resp.isEmpty() && !resp.contains("error")) ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
		}
	}
}
