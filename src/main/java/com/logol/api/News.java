package com.logol.api;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class News {
	private Integer id;
	private String title;
	private String description;
	private LocalDate created_date;

	public News() {
	}

	public News(Integer id, String title, String description, LocalDate created_date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created_date = created_date;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

}
