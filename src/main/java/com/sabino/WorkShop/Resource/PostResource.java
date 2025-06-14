package com.sabino.WorkShop.Resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sabino.WorkShop.Domain.Post;
import com.sabino.WorkShop.Resource.util.URL;
import com.sabino.WorkShop.Service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	public PostService service;
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
		
		
	}
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> post = service.findByTitle(text);
		return ResponseEntity.ok().body(post);
		
	}
	
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch
	  (@RequestParam(value = "text", defaultValue = "") String text,
			  @RequestParam(value = "minDate", defaultValue = "") String minDate,
			  @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		text = URL.decodeParam(text);
		Date min = URL.dateConvert(minDate, new Date(0L));
		Date max = URL.dateConvert(maxDate, new Date(0L));
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
		


}}
