package com.botree.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory = new AnnotationConfigApplicationContext("com.botree.example");
		Book book = (Book)factory.getBean("book");
		System.out.println(book.getAuthor().getAuthorName());

	}

}
