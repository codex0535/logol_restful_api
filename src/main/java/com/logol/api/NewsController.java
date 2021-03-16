package com.logol.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<News> get(@PathVariable Integer id) {
		try {
			News news = service.get(id);
			return new ResponseEntity<News>(news, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/news")
	public void add(@RequestBody News news) {
		service.save(news);
	}
	
	@PutMapping("/news/{id}")
	public ResponseEntity<?> update(@RequestBody News news, @PathVariable Integer id) {
		try {
//			News existNews = service.get(id);
			service.save(news);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@DeleteMapping("/news/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
