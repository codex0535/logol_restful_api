package com.logol.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	
	@Autowired
	private NewsService service;
	
	
	@GetMapping("/news")
	public List<News> list() {
		return service.listAll();
	}
	
	@GetMapping("/news/{id}")
	public ResponseEntity<News> get(@PathVariable String id) {
		try {
			News news = service.get(id);
			return new ResponseEntity<News>(news, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
}
