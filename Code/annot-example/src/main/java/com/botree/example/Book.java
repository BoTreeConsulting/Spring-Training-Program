package com.botree.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {
	
	@Autowired
	Author author;
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Author getAuthor() {
		return author;
	}

}
