package com.botree.example;

import org.springframework.stereotype.Component;

@Component
public class Author {
	
	String authorName = "Ryan Bates";
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
