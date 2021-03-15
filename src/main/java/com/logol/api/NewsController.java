package com.logol.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	
	@Autowired
	private NewsService service;
	
	
	@GetMapping("/news")
	public List<News> list() {
		return service.listAll();
	}
	
}
