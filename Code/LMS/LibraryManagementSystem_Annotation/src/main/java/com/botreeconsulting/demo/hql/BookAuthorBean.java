package com.botreeconsulting.demo.hql;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;

public class BookAuthorBean {
	private Author author;
	private Book book;
	
	public BookAuthorBean() {
		// TODO Auto-generated constructor stub
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}	
}