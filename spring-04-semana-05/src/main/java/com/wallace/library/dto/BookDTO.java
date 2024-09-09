package com.wallace.library.dto;

import java.io.Serializable;

import com.wallace.library.entities.Book;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String author;
	private int year;
	private String genre;

	public BookDTO() {
	}

	public BookDTO(Book obj) {
		super();
		this.id = obj.getId();
		title = obj.getTitle();
		author = obj.getAuthor();
		year = obj.getYear();
		genre = obj.getGenre();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
