package com.logol.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
	
	@Autowired
	private NewsRepository repo;
	
	public List<News> listAll() {
		return repo.findAll();
	}
	
	public void save(News news) {
		repo.save(news);
	}
	
	public News get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
